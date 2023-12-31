package ma.adil.adilclientservice.external;

import ma.adil.adilclientservice.model.CarModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CAR-SERVICE")
public interface CarRestClient {
    @GetMapping("/api/car")
    List<CarModel> cars();
    @GetMapping("/api/car/{id}")
    CarModel car(@PathVariable("id") Long id);
}
