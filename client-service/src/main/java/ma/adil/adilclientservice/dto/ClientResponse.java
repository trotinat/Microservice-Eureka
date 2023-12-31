package ma.adil.adilclientservice.dto;


import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.adil.adilclientservice.model.CarModel;

import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class ClientResponse {
    private Long id;
    private String fullName;
    private String email;
    private List<CarModel> cars;
}
