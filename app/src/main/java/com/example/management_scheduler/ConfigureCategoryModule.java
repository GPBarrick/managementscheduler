package com.example.management_scheduler;
import java.util.ArrayList;
public class ConfigureCategoryModule {
    private DataPreset dataPreset;
    public ConfigureCategoryModule(DataPreset dataPreset) {
        this.dataPreset = dataPreset;
    }
    public void SetDataPreset(DataPreset newPreset) { this.dataPreset = newPreset; }
    public DataPreset GetDataPreset() { return this.dataPreset; }
}