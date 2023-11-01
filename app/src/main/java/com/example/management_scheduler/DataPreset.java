package com.example.management_scheduler;
import java.io.Serializable;
public class DataPreset implements Serializable {
    private String presetName;
    public DataPreset(String presetName) {
        this.presetName = presetName;
    }
    public void SetPresetName(String newName) { this.presetName = newName; }
    public String GetPresetName() { return this.presetName; }
}
