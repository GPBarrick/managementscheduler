package com.example.management_scheduler;
import java.io.Serializable;
public class ClientModule implements Serializable {
    private ModuleDataAdapter clientInformationList;
    public ClientModule(ModuleDataAdapter clientInformationList) {
        this.clientInformationList = clientInformationList;
    }
    public void SetClientInformationList(ModuleDataAdapter newView) { this.clientInformationList = newView; }
    public ModuleDataAdapter GetClientInformationList() { return this.clientInformationList; }

}