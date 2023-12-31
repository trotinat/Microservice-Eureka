package ma.houssam.clientservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long card_id;
    private Boolean status = false;
    private Float currentTankSize;
}
