package ma.houssam.clientservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.houssam.clientservice.model.CarModel;

import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class ClientResponse {
    private Long id;
    private String fullName;
    private String email;
    private List<CarModel> cars;
}
