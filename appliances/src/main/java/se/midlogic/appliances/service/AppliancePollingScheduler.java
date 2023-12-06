package se.midlogic.appliances.service;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import se.midlogic.appliances.model.Appliance;

import java.util.List;

@Component
public class AppliancePollingScheduler {

    private final ApplianceService applianceService;
    private final ConnectionStatusService connectionStatusService;

    public AppliancePollingScheduler(ApplianceService applianceService, ConnectionStatusService connectionStatusService) {
        this.applianceService = applianceService;
        this.connectionStatusService = connectionStatusService;
    }

    @Scheduled(fixedRate = 60000) // Polls the API every second (in milliseconds)
    public void pollAppliances() {
        List<Appliance> applianceIdsToPoll = applianceService.findAllAppliancesSortedByConnectionsAsc();
        List<ConnectionStatus> response = connectionStatusService.getConnectionsStatus(applianceIdsToPoll);
        response.forEach(connectionStatus -> {
            if (connectionStatus.isConnected()) {
                applianceService.addConnection(connectionStatus.applianceId());
            }
        });

        System.out.println("Response: " + response);
    }
}
