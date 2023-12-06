package se.midlogic.appliances.model;

import java.util.List;

public class Customer {
    private String name;
    private String address;
    private List<String> applianceIds;

    public Customer(String name, String address, List<String> applianceIds) {
        this.name = name;
        this.address = address;
        this.applianceIds = applianceIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getApplianceIds() {
        return applianceIds;
    }

    public void setApplianceIds(List<String> applianceIds) {
        this.applianceIds = applianceIds;
    }
}

