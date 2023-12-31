package ma.houssam.carservice;

import ma.houssam.carservice.entities.Car;
import ma.houssam.carservice.entities.FuelType;
import ma.houssam.carservice.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CarRepository carRepository){
        return args -> {
            List<Car> cars = List.of(
                    Car.builder()
                            .brand("Audi")
                            .consumptionPerKm(10F)
                            .description("Audi A3 2020")
                            .fuelType(FuelType.ESSENCE)
                            .picture("https://uploads.audi-mediacenter.com/system/production/media/90567/images/72391bd2d21a80a761f0df1bd5bff197d5804daa/A201895_web_1920.jpg?1698421086")
                            .tankSize(50F)
                            .model("A3")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm(6F)
                            .description("Mercedes Class E 2018")
                            .fuelType(FuelType.ESSENCE)
                            .picture("https://i.gaw.to/content/photos/42/62/426286-mercedes-classe-e-2021-au-tour-du-coupe-et-du-cabriolet.jpg?460x287")
                            .tankSize(50F)
                            .model("Class E")
                            .build(),
                    Car.builder()
                            .brand("BMW")
                            .consumptionPerKm(9F)
                            .description("BMW Serie 2")
                            .fuelType(FuelType.ESSENCE)
                            .picture("https://www.bmw.ma/content/dam/bmw/common/all-models/2-series/series-overview/bmw-2-series-overview-page-ms-coupe.jpg/jcr:content/renditions/cq5dam.resized.img.585.low.time1627455118737.jpg")
                            .tankSize(50F)
                            .model("Serie 2")
                            .build(),
                    Car.builder()
                            .brand("BMW")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("BMW Serie 3")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://www.bmw.ma/content/dam/bmw/common/all-models/3-series/series-overview/bmw-3er-overview-page-ms-02.jpg")
                            .tankSize(50F)
                            .model("Serie 3")
                            .build(),
                    Car.builder()
                            .brand("BMW")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("BMW Serie 4")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://www.largus.fr/images/2023-03/bmw-serie-4-coupe-2024-illustration-blanc-avg-mk-bd_19.jpg")
                            .tankSize(50F)
                            .model("Serie 4")
                            .build(),
                    Car.builder()
                            .brand("BMW")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("BMW Serie 5")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://i.gaw.to/content/photos/42/61/426173-la-bmw-serie-5-2021-recoit-de-nouvelles-munitions.jpg")
                            .tankSize(50F)
                            .model("Serie 5")
                            .build(),
                    Car.builder()
                            .brand("BMW")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("BMW Serie X6")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://www.leguideauto.ma/contents/cars/pictures/2021/12/large/REOudgPUEpnpJTuTdfJcev6ksTCHv8C98IS7Fgs6.webp")
                            .tankSize(64F)
                            .model("Serie X6")
                            .build(),
                    Car.builder()
                            .brand("BMW")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("BMW Serie 7")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://images.prismic.io/carwow/ba438023-ca35-4e3b-868e-f92ea6847617_LHD+BMW+Serie+7+PHEV+2022+Exterior-14.jpg")
                            .tankSize(60F)
                            .model("Serie 7")
                            .build(),
                    Car.builder()
                            .brand("Audi")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Audi A4")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://www.motortrend.com/uploads/2022/07/2022-Audi-A4-S-Line-front-three-quarter-2.jpg")
                            .tankSize(50F)
                            .model("A4")
                            .build(),
                    Car.builder()
                            .brand("Audi")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Audi A5")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://www.motortrend.com/uploads/2023/07/2024-Audi-A5-Sportback-S-Tango-Red-front-view-62.jpg?fit=around%7C551:374")
                            .tankSize(50F)
                            .model("A5")
                            .build(),
                    Car.builder()
                            .brand("Audi")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Audi A6")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://media.ed.edmunds-media.com/audi/a6/2022/oem/2022_audi_a6_sedan_prestige_fq_oem_1_1600.jpg")
                            .tankSize(50F)
                            .model("A6")
                            .build(),
                    Car.builder()
                            .brand("Audi")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Audi A7")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://cdn.motor1.com/images/mgl/QlveY/s1/4x3/2019-audi-a7.webp")
                            .tankSize(50F)
                            .model("A7")
                            .build(),
                    Car.builder()
                            .brand("Audi")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Audi A8")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://i.ytimg.com/vi/htHQJ-pzr8Q/sddefault.jpg")
                            .tankSize(50F)
                            .model("A8")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Mercedes Class A")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://www.wandaloo.com/files/Voiture-Neuve/mercedes/Mercedes-Classe-A-2023-Neuve-Maroc-10.jpg")
                            .tankSize(50F)
                            .model("Class A")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Mercedes Class C")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://www.autocar.co.uk/sites/autocar.co.uk/files/mercedes-c-class_0.jpg")
                            .tankSize(50F)
                            .model("Class C")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Mercedes Class E Hybrid")
                            .fuelType(FuelType.HYBRID)
                            .picture("https://msl.lucidcdn.com/assets/1/new-vehicles/mercedes-benz/e-class/e-class-saloon/2024-e-class-in-room.jpg/renditions/ratio/original/width/1200/height/675/2024-e-class-in-room.jpg?3355")
                            .tankSize(50F)
                            .model("Class E Hybrid")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Mercedes CLA")
                            .fuelType(FuelType.DIESEL)
                            .picture("https://upload.wikimedia.org/wikipedia/commons/7/71/Mercedes-Benz_C118_IMG_2673.jpg")
                            .tankSize(50F)
                            .model("Class CLA")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Mercedes A45S")
                            .fuelType(FuelType.ESSENCE)
                            .picture("https://news-site-za.s3.af-south-1.amazonaws.com/images/2020/08/Mercedes-AMG-A45S-2.jpg")
                            .tankSize(50F)
                            .model("A45S")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Mercedes C63S 2016")
                            .fuelType(FuelType.ESSENCE)
                            .picture("https://carsguide-res.cloudinary.com/image/upload/f_auto,fl_lossy,q_auto,t_cg_hero_large/v1/editorial/mercedes-%3Damg-c63-s-coupe-chris-benny-smp-%288%29.jpg")
                            .tankSize(50F)
                            .model("C63S")
                            .build(),
                    Car.builder()
                            .brand("Mercedes")
                            .consumptionPerKm((float) (Math.random()*5+7))
                            .description("Mercedes E63S")
                            .fuelType(FuelType.ESSENCE)
                            .picture("https://hips.hearstapps.com/hmg-prod/images/2023-mercedes-amg-e63-s-4matic-103-1671563913.jpg?crop=0.466xw:0.350xh;0.311xw,0.465xh&resize=1200:*")
                            .tankSize(50F)
                            .model("E63S")
                            .build()
            );

            carRepository.saveAll(cars);
        };
    }

}
