package com.example.management_scheduler;
import java.io.Serializable;
public class ClientData implements Serializable {
    private String clientName;
    private String clientInformation;
    public ClientData(String clientName, String clientInformation) {
        this.clientName = clientName;
        this.clientInformation = clientInformation;
    }
    public void SetClientName(String newName) { this.clientName = newName; }
    public String GetClientName() { return this.clientName; }
    public void SetClientInformation(String newInformation) { this.clientInformation = newInformation; }
    public String GetClientInformation() { return this.clientInformation; }
}
