package se.midlogic.appliances.service;

import org.springframework.stereotype.Service;
import se.midlogic.appliances.model.Customer;
import se.midlogic.appliances.repository.ApplianceRepository;

import java.util.List;

@Service
public class CustomerService {


    private final ApplianceRepository applianceRepository;

    public CustomerService(ApplianceRepository applianceRepository) {
        this.applianceRepository = applianceRepository;
    }

    public void saveCustomers(List<Customer> appliances) {
        appliances.forEach(applianceRepository::saveCustomer);
    }




}
