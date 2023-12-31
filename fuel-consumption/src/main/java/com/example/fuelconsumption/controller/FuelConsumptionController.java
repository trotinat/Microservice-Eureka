package com.example.fuelconsumption.controller;


import com.example.fuelconsumption.entities.FuelConsumption;
import com.example.fuelconsumption.service.FuelConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption")
public class FuelConsumptionController {
    @Autowired
    private FuelConsumptionService fuelConsumptionService;


    @GetMapping("/client/{id}")
    public List<FuelConsumption> fuelConsumptionsByClient(@PathVariable("id") Long id){return fuelConsumptionService.fuelConsumptionsByClientId(id);}
    @GetMapping
    public List<FuelConsumption> fuelConsumptions(){return fuelConsumptionService.fuelConsumptions();}
    @GetMapping("/{id}")
    public FuelConsumption fuelConsumption(@PathVariable("id") Long id){return fuelConsumptionService.fuelConsumption(id);}
    @PostMapping
    public void save(@RequestBody FuelConsumption fuelConsumption){fuelConsumptionService.save(fuelConsumption);}
}
