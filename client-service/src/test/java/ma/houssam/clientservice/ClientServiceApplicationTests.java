package ma.houssam.clientservice;

import ma.houssam.clientservice.entities.Client;
import ma.houssam.clientservice.external.CarRestClient;
import ma.houssam.clientservice.model.CarModel;
import ma.houssam.clientservice.model.FuelType;
import ma.houssam.clientservice.repository.CarRepository;
import ma.houssam.clientservice.repository.ClientRepository;
import ma.houssam.clientservice.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ClientServiceApplication.class) // Specify the main Spring Boot application class

@ExtendWith(MockitoExtension.class)
class ClientServiceApplicationTests {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarRestClient carRestClient;

    @InjectMocks
    private ClientService clientService ;


    @Test
    void testFindAll() {
        CarModel carModel = CarModel.builder()
                .id(1L)
                .brand("Toyota")
                .model("Corolla")
                .description("A reliable sedan")
                .picture("toyota_corolla.jpg")
                .fuelType(FuelType.DIESEL)
                .tankSize(50.0f)
                .consumptionPerKm(8.5f)
                .status(false)
                .currentTankSize(75.0f)
                .build();

        List<CarModel> carModelList = Collections.singletonList(carModel);

        when(carRestClient.car(anyLong())).thenReturn(carModel);

        Client client = Client.builder()
                .id(1L)
                .fullName("John Doe")
                .email("john@example.com")
                .cars(carModelList)
                .build();

        when(clientRepository.findAll()).thenReturn(Collections.singletonList(client));

        List<Client> clients = clientService.findAll();

        assertEquals(1, clients.size());
    }
}
