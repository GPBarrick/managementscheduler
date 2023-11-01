package com.example.management_scheduler;
import java.io.Serializable;
public class ClientModule implements Serializable {
    private ModuleDataAdapter clientInformationList;
    private String moduleHeader;
    private DataPreset dataPreset;
    public ClientModule(ModuleDataAdapter clientInformationList, String moduleHeader, DataPreset dataPreset) {
        this.clientInformationList = clientInformationList;
        this.moduleHeader = moduleHeader;
        this.dataPreset = dataPreset;
    }
    public void SetClientInformationList(ModuleDataAdapter newView) { this.clientInformationList = newView; }
    public ModuleDataAdapter GetClientInformationList() { return this.clientInformationList; }
    public void SetModuleHeader(String newHeader) { this.moduleHeader = newHeader; }
    public String GetModuleHeader() { return this.moduleHeader; }
    public void SetDataPreset(DataPreset newPreset) { this.dataPreset = newPreset; }
    public DataPreset GetDataPreset() { return this.dataPreset; }
}