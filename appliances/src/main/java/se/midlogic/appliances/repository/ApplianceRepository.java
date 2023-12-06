package se.midlogic.appliances.repository;

import org.springframework.stereotype.Repository;
import se.midlogic.appliances.model.Appliance;
import se.midlogic.appliances.model.Customer;

import java.util.List;

@Repository
public interface ApplianceRepository {
    void saveCustomer(Customer customer);

    void saveAppliance(Appliance appliance);

    List<Appliance> findAllAppliancesSortedByConnectionsAsc();
    List<Appliance> findAllAppliancesSortedByConnectionsDesc();

    void addConnection(String applianceId);

}

