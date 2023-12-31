package com.example.fuelconsumption.entities;


import com.example.fuelconsumption.model.Car;
import com.example.fuelconsumption.model.Client;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class FuelConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long client_id;
    private Long car_id;
    private Float price;
    private Float gazPerLiter;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Transient
    private Client client;
    @Transient
    private Car car;
}
