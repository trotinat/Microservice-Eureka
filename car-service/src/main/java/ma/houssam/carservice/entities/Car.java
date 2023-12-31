package ma.houssam.carservice.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String description;
    @Column(length = 1000)
    private String picture;
    private FuelType fuelType;
    private Float tankSize;
    private Float consumptionPerKm;
}
