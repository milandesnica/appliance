package se.midlogic.appliances.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.midlogic.appliances.repository.ApplianceRepository;
import se.midlogic.appliances.repository.InMemoryRepository;
import se.midlogic.appliances.service.ConnectionStatusService;
import se.midlogic.appliances.service.ConnectionStatusServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public ApplianceRepository applianceRepository() {
        return new InMemoryRepository();
    }

    @Bean
    public ConnectionStatusService connectionStatusService() {
        return new ConnectionStatusServiceImpl();
    }
}
