package com.example.adilfuelconsumption.external;


import com.example.adilfuelconsumption.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CAR-SERVICE")
public interface CarRestClient {
    @GetMapping("/api/car")
    List<Car> cars();
    @GetMapping("/api/car/{id}")
    Car car(@PathVariable("id") Long id);
}
