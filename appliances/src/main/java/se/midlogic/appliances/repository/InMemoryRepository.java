package se.midlogic.appliances.repository;

import org.springframework.stereotype.Repository;
import se.midlogic.appliances.model.Appliance;
import se.midlogic.appliances.model.Customer;

import java.util.*;

@Repository
public class InMemoryRepository implements ApplianceRepository{

    private final Map<String, Customer> customers = new HashMap<>();
    private final Map<String, Appliance> appliances = new HashMap<>();

    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    @Override
    public void saveAppliance(Appliance appliance) {
        appliances.put(appliance.getApplianceId(), appliance);
    }

    @Override
    public List<Appliance> findAllAppliancesSortedByConnectionsAsc() {
        return appliances.values()
                .stream()
                .sorted(Comparator.comparing(Appliance::getConnections))
                .toList();
    }
    public List<Appliance> findAllAppliancesSortedByConnectionsDesc() {
        return appliances.values().stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Appliance::getConnections, Comparator.nullsLast(Comparator.naturalOrder())).reversed())
                .toList();
    }

    @Override
    public void addConnection(String applianceId) {
        Appliance appliance = appliances.get(applianceId);
        appliance.setConnections(appliance.getConnections() + 1);
    }

}
