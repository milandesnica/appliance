package se.midlogic.appliances.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.midlogic.appliances.model.Appliance;
import se.midlogic.appliances.service.ApplianceService;

import java.util.List;

@RestController
@RequestMapping("/api/appliances")
public class ApplianceController {

    private final ApplianceService applianceService;

    @Autowired
    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @GetMapping("/sortedByConnections")
    public List<Appliance> getAllAppliancesSortedByConnections(
            @RequestParam(name = "order", required = false, defaultValue = "asc") String order) {
        if (order.equals("asc")) {
            return applianceService.findAllAppliancesSortedByConnectionsAsc();
        } else {
            return applianceService.findAllAppliancesSortedByConnectionsDesc();
        }
    }

}
