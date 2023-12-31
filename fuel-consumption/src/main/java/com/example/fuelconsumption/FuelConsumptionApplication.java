package com.example.fuelconsumption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FuelConsumptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuelConsumptionApplication.class, args);
    }

}
