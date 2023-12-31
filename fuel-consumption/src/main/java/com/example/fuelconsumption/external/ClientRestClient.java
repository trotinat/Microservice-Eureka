package com.example.fuelconsumption.external;


import com.example.fuelconsumption.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping("/api/client")
    List<Client> clients();
    @GetMapping("/api/client/{id}")
    Client client(@PathVariable("id") Long id);
}