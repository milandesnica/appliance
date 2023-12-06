package se.midlogic.appliances.model;

public class Appliance {
    private String applianceId;
    private String factoryNumber;
    private int connections;


    public Appliance(String applianceId, String factoryNumber) {
        this.applianceId = applianceId;
        this.factoryNumber = factoryNumber;
        this.connections = 0;
    }

    public Appliance(String applianceId, String factoryNumber, int connections) {
        this.applianceId = applianceId;
        this.factoryNumber = factoryNumber;
        this.connections = connections;
    }

    public String getApplianceId() {
        return applianceId;
    }

    public String getFactoryNumber() {
        return factoryNumber;
    }


    public int getConnections() {
        return connections;
    }

    public void setConnections(int connections) {
        this.connections = connections;
    }
}
