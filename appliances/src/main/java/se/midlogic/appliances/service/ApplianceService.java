package se.midlogic.appliances.service;

import org.springframework.stereotype.Service;
import se.midlogic.appliances.model.Appliance;
import se.midlogic.appliances.repository.ApplianceRepository;

import java.util.List;

@Service
public class ApplianceService {


    private final ApplianceRepository applianceRepository;

    public ApplianceService(ApplianceRepository applianceRepository) {
        this.applianceRepository = applianceRepository;
    }

    public void saveAppliances(List<Appliance> appliances) {
        appliances.forEach(applianceRepository::saveAppliance);
    }

    public List<Appliance> findAllAppliancesSortedByConnectionsAsc() {
        return applianceRepository.findAllAppliancesSortedByConnectionsAsc();
    }
    public List<Appliance> findAllAppliancesSortedByConnectionsDesc() {
        return applianceRepository.findAllAppliancesSortedByConnectionsDesc();
    }

    public void addConnection(String applianceId) {
        applianceRepository.addConnection(applianceId);
    }

}
