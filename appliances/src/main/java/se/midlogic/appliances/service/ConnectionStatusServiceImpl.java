package se.midlogic.appliances.service;

import se.midlogic.appliances.model.Appliance;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ConnectionStatusServiceImpl implements ConnectionStatusService {
    @Override
    public List<ConnectionStatus> getConnectionsStatus(List<Appliance> appliances) {
        Random random = new Random();
        return appliances.stream()
                .map(appliance -> new ConnectionStatus(appliance.getApplianceId(), random.nextDouble() < 0.9))
                .collect(Collectors.toList());
    }
}

