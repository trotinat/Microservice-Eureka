package com.example.fuelconsumption.repository;

import com.example.fuelconsumption.entities.FuelConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelConsumptionRepository extends JpaRepository<FuelConsumption,Long> {
    @Query("SELECT fuel FROM FuelConsumption fuel WHERE fuel.client_id=:client_id")
    public List<FuelConsumption> getFuelConsumptionsByClient_id(Long client_id);
}
