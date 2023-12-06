package se.midlogic.appliances.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.midlogic.appliances.model.Customer;
import se.midlogic.appliances.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/customer")
public class CustomerAdminController {

    private final CustomerService customerService;

    public CustomerAdminController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/load")
    public void processCustomers(@RequestBody List<CustomerRequest> customerRequests) {
        List<Customer> customers = customerRequests.stream()
                .map(record -> new Customer(record.customerName(), record.customerAddress(), record.appliances())).toList();
        customerService.saveCustomers(customers);
    }
}
record CustomerRequest(String customerName, String customerAddress, List<String> appliances) {
}