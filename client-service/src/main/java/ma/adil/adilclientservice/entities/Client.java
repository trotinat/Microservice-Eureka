package ma.adil.adilclientservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import ma.adil.adilclientservice.model.CarModel;

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
    @OneToMany
    @JsonIgnore
    private List<Car> car_ids;
}
