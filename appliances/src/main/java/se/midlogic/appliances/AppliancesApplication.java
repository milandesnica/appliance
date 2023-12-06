package se.midlogic.appliances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppliancesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppliancesApplication.class, args);
    }

}
