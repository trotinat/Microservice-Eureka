package ma.houssam.clientservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.houssam.clientservice.model.CarModel;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    @Transient
    private List<CarModel> cars;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Car> car_ids = new ArrayList<>();
}
