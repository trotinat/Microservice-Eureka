package ma.houssam.clientservice.service;


import ma.houssam.clientservice.dto.ClientResponse;
import ma.houssam.clientservice.entities.Car;
import ma.houssam.clientservice.entities.Client;
import ma.houssam.clientservice.external.CarRestClient;
import ma.houssam.clientservice.model.CarModel;
import ma.houssam.clientservice.repository.CarRepository;
import ma.houssam.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarRestClient carRestClient;

    private Car mapToCar(CarModel carModel){
        return Car.builder()
                .card_id(carModel.getId())
                .status(false)
                .currentTankSize(carModel.getTankSize())
                .build();
    }
    public List<Client> findAll(){
        List<Client> clients = clientRepository.findAll();
        clients.forEach(client -> {
            List<CarModel> carModels = new ArrayList<>();
            client.getCar_ids().forEach(car -> {
                CarModel carModel = carRestClient.car(car.getCard_id());
                carModel.setStatus(car.getStatus());
                carModel.setCurrentTankSize(car.getCurrentTankSize());
                carModels.add(carModel);
            });
            client.setCars(carModels);
        });

        return clients;
    }

    private ClientResponse maptoClientResponse(Client client) {
        return ClientResponse.builder()
                .cars(client.getCars())
                .email(client.getEmail())
                .fullName(client.getFullName())
                .id(client.getId())
                .build();
    }

    public ClientResponse findById(Long id){
        Client client = clientRepository.findById(id).orElse(null);
        List<CarModel> carModels = new ArrayList<>();
        assert client != null;
        client.getCar_ids().forEach(car -> {
            CarModel carModel = carRestClient.car(car.getCard_id());
            carModel.setStatus(car.getStatus());
            carModel.setCurrentTankSize(car.getCurrentTankSize());
            carModels.add(carModel);
        });
        client.setCars(carModels);
        List<Car> cars = carModels.stream()
                .map(this::mapToCar).toList();
        client.setCar_ids(cars);
        client.setCars(carModels);
        return maptoClientResponse(client);
    }
    public void save (Client client){clientRepository.save(client);}

    public void power(Long id) {
        Client client = clientRepository.findById(1L).orElse(null);
        assert client != null;
        client.getCar_ids().forEach(car -> {
            if(Objects.equals(car.getId(), id)){
                CarModel currentCar = carRestClient.car(id);
                if(car.getStatus() && car.getCurrentTankSize()>=currentCar.getConsumptionPerKm()){
                    car.setCurrentTankSize(car.getCurrentTankSize()-currentCar.getConsumptionPerKm());
                }
                car.setStatus(!car.getStatus());
            }
        });

        clientRepository.save(client);
    }

    public void trash(Long id) {
        Client client = clientRepository.findById(1L).orElse(null);
        Car car = carRepository.findById(id).orElse(null);
        assert client != null;
        client.getCar_ids().remove(car);
        clientRepository.save(client);
    }

    public void affect(Long id) {
        Client client = clientRepository.findById(1L).orElse(null);
        CarModel car = carRestClient.car(id);
        Car mappedCar = this.mapToCar(car);
        if(client != null && mappedCar !=null){
            if(!client.getCar_ids().contains(mappedCar)){
                client.getCar_ids().add(mappedCar);
                carRepository.save(mappedCar);
                clientRepository.save(client);
            }
        }
    }

    public void fuel(Long id,Float liters) {
        Car car = carRepository.findById(id).orElse(null);
        CarModel carModel = carRestClient.car(id);
        if(car != null && carModel != null){
            if(car.getCurrentTankSize()+liters>carModel.getTankSize()){
                car.setCurrentTankSize(carModel.getTankSize());
            }else{
                car.setCurrentTankSize(car.getCurrentTankSize()+liters);
            }
            carRepository.save(car);
        }
    }
}
