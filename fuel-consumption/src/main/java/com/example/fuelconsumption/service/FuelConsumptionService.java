package com.example.fuelconsumption.service;


import com.example.fuelconsumption.entities.FuelConsumption;
import com.example.fuelconsumption.external.CarRestClient;
import com.example.fuelconsumption.external.ClientRestClient;
import com.example.fuelconsumption.repository.FuelConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FuelConsumptionService {
    @Autowired
    private FuelConsumptionRepository fuelConsumptionRepository;
    @Autowired
    private ClientRestClient clientRestClient;
    @Autowired
    private CarRestClient carRestClient;

    public List<FuelConsumption> fuelConsumptionsByClientId(Long id){
        return fuelConsumptionRepository.getFuelConsumptionsByClient_id(id);
    }
    public List<FuelConsumption> fuelConsumptions(){
        List<FuelConsumption> fuelConsumptions = fuelConsumptionRepository.findAll();
        fuelConsumptions.forEach(consumption -> {
            consumption.setCar(carRestClient.car(consumption.getCar_id()));
            consumption.setClient(clientRestClient.client(consumption.getClient_id()));
        });
        return fuelConsumptions;
    }
    public FuelConsumption fuelConsumption(Long id){
        FuelConsumption fuelConsumption = fuelConsumptionRepository.findById(id).orElse(null);
        if(fuelConsumption != null){
            fuelConsumption.setCar(carRestClient.car(fuelConsumption.getCar_id()));
            fuelConsumption.setClient(clientRestClient.client(fuelConsumption.getClient_id()));
        }
        return fuelConsumption;
    }
    public void save(FuelConsumption consumption){
        consumption.setCreatedAt(new Date());
        fuelConsumptionRepository.save(consumption);
    }
}
