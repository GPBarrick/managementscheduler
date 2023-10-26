package com.example.management_scheduler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.TextView;
import android.widget.ImageView;
public class ModuleAdapter extends ArrayAdapter<EmployeeModule> {
    private ArrayList<EmployeeModule> employeeModuleList;
    private Context applicationContext;
    public ModuleAdapter(ArrayList<EmployeeModule> employeeModuleList, Context applicationContext) {
        super(applicationContext, R.layout.schedule_information_layout, employeeModuleList);
        this.employeeModuleList = employeeModuleList;
        this.applicationContext = applicationContext;
    }
    public void SetEmployeeModuleList(ArrayList<EmployeeModule> newList) { this.employeeModuleList = newList; }
    public ArrayList<EmployeeModule> GetEmployeeModuleList() { return this.employeeModuleList; }
    public void SetApplicationContext(Context newContext) {this.applicationContext = newContext; }
    public Context GetApplicationContext() { return this.applicationContext; }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(GetApplicationContext());
            convertView = inflater.inflate(R.layout.schedule_information_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.employeeName = (TextView)convertView.findViewById(R.id.schedule_output_employee_name);
            viewHolder.employeeHours = (TextView)convertView.findViewById(R.id.schedule_output_employee_hours);
            viewHolder.moduleBackground = (ImageView)convertView.findViewById(R.id.schedule_output_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.employeeName.setText(GetEmployeeModuleList().get(position).GetEmployeeName());
        viewHolder.employeeHours.setText(GetEmployeeModuleList().get(position).GetEmployeeShift());
        // uncomment line below when colors for module background have been created
        /*viewHolder.moduleBackground.setImageResource(GetEmployeeModuleList().get(position).GetModuleBackground());*/
        return convertView;
    }
    private static class ViewHolder {
        public TextView employeeName;
        public TextView employeeHours;
        public ImageView moduleBackground;
    }
}
