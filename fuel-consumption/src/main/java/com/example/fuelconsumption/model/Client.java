package com.example.fuelconsumption.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Client {
    private Long id;
    private String fullName;
    private String email;
    private List<Car> cars;
}
