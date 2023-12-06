package se.midlogic.appliances.controller;

import org.springframework.web.bind.annotation.*;
import se.midlogic.appliances.model.Appliance;
import se.midlogic.appliances.service.ApplianceService;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/admin/appliance")

public class ApplianceAdminController {

    private final ApplianceService applianceService;

    public ApplianceAdminController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @PostMapping("/load")
    public void processAppliances(@RequestBody List<ApplianceRecord> applianceRequests,
                                  @RequestParam(name= "testDataConnections", required = false, defaultValue = "false") boolean testDataConnections) {
        List<Appliance> appliances;
        if (testDataConnections) {
            appliances = IntStream.range(0, applianceRequests.size())
                    .mapToObj(index -> {
                        ApplianceRecord record = applianceRequests.get(index);
                        return new Appliance(record.applianceId(), record.factoryId(), index);
                    })
                    .toList();
        }
       else {
            appliances = applianceRequests.stream().map(record -> new Appliance(record.applianceId(), record.factoryId())).toList();
        }
        applianceService.saveAppliances(appliances);
    }
}

record ApplianceRecord(String applianceId, String factoryId) {
}
