package com.example.adilfuelconsumption.model;


import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Car {
    private Long id;
    private String brand;
    private String model;
    private String description;
    private String picture;
    private FuelType fuelType;
    private Float tankSize;
    private Float consumptionPerKm;
}
