package se.midlogic.appliances.service;

import org.springframework.stereotype.Service;
import se.midlogic.appliances.model.Appliance;

import java.util.List;

@Service
public interface ConnectionStatusService {
    List<ConnectionStatus> getConnectionsStatus(List<Appliance> appliances);
}
