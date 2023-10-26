package com.example.management_scheduler;
import android.widget.TextView;
import android.widget.ImageView;
public class EmployeeModule {
    private String employeeName;
    private String employeeShift;
    private int moduleBackground;
    public EmployeeModule(String employeeName, String employeeShift, int moduleBackground) {
        this.employeeName = employeeName;
        this.employeeShift = employeeShift;
        this.moduleBackground = moduleBackground;
    }
    public void SetEmployeeName(String newName) { this.employeeName = newName; }
    public String GetEmployeeName() { return this.employeeName; }
    public void SetEmployeeShift(String newShift) { this.employeeShift = newShift; }
    public String GetEmployeeShift() { return this.employeeShift; }
    public void SetModuleBackground(int newBackground) { this.moduleBackground = newBackground; }
    public int GetModuleBackground() { return this.moduleBackground; }
}
