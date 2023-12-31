package ma.houssam.clientservice;

import ma.houssam.clientservice.entities.Client;
import ma.houssam.clientservice.repository.CarRepository;
import ma.houssam.clientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository, CarRepository carRepository){
        return args -> {

            clientRepository.save(
                    Client.builder()
                            .email("houssam.haraf@gmail.com")
                            .fullName("HARAF Houssam")
                            .build()
            );
        };
    }
}
