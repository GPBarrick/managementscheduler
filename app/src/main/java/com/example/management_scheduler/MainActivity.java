package com.example.management_scheduler;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import android.content.Context;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize application context
        InitializeApplicationContext(getApplicationContext());
        // initializing member instances of xml elements
        InitializeViews();
        // initializing a data structure that has employee names as elements (testing)
        InitializeEmployeeNameStructure();
        // initializing a data structure that has employee shifts as elements (testing)
        InitializeEmployeeShiftStructure();
        // initialize a data structure of employee modules
        InitializeEmployeeModuleList();
        // initialize the adapter that will link data structures to the element
        InitializeModuleAdapter();
        // set the correct adapter giving data and xml object linkage
        SetListViewAdapter();
        // image button listener (add new module)
        ImageButtonListener();
    }
    // get the application context
    public Context applicationContext;
    private void InitializeApplicationContext(Context newContext) { this.applicationContext = newContext; }
    // xml element object members
    public ImageView scheduleHeaderImage, scheduleMainImage, mainPageTopBanner;
    public TextView scheduleHeaderText, imageButtonText;
    public ListView scheduleInformationView;
    public ImageButton mainAddModuleButton;
    private void InitializeViews() {
        // connecting the xml elements to their objects
        this.scheduleHeaderImage = findViewById(R.id.schedule_information_header_image);
        this.scheduleMainImage = findViewById(R.id.schedule_information_main_image);
        this.scheduleHeaderText = findViewById(R.id.schedule_information_header_text);
        this.scheduleInformationView = findViewById(R.id.schedule_information_list_view);
        this.mainAddModuleButton = findViewById(R.id.main_page_add_button);
        this.imageButtonText = findViewById(R.id.main_page_add_button_text);
        this.mainPageTopBanner = findViewById(R.id.main_page_top_banner);
    }
    // create data structure of employee names (testing)
    public ArrayList<String> employeeNameStructure;
    private void InitializeEmployeeNameStructure() {
        employeeNameStructure = new ArrayList<>();
        this.employeeNameStructure.add("Alex");
        this.employeeNameStructure.add("Michelle");
        this.employeeNameStructure.add("Steve");
        this.employeeNameStructure.add("Madelyn");
    }
    // create data structure of employee shifts (testing)
    public ArrayList<String> employeeShiftStructure;
    private void InitializeEmployeeShiftStructure() {
        employeeShiftStructure = new ArrayList<>();
        this.employeeShiftStructure.add("8:00AM-4:00PM");
        this.employeeShiftStructure.add("8:00AM-4:00PM");
        this.employeeShiftStructure.add("4:00PM-12:00AM");
        this.employeeShiftStructure.add("4:00PM-12:00AM");
    }
    // create the data structure of employee module objects
    public ArrayList<EmployeeModule> employeeModuleList;
    private void InitializeEmployeeModuleList() {
        this.employeeModuleList = new ArrayList<>();
        for (int ndx = 0; ndx < employeeNameStructure.size(); ++ndx) {
            this.employeeModuleList.add(new EmployeeModule(this.employeeNameStructure.get(ndx), this.employeeShiftStructure.get(ndx), 0));
        }
    }
    // create the adapter that will be used to connect the data structures to the inflated xml layout within R.layout.activity_main
    public ModuleAdapter moduleAdapter;
    private void InitializeModuleAdapter() {
        this.moduleAdapter = new ModuleAdapter(this.employeeModuleList, this.applicationContext);
    }
    // set the adapter that connects the data structures to the <ListView/> element object
    private void SetListViewAdapter() {
        this.scheduleInformationView.setAdapter(this.moduleAdapter);
    }
    // create a listener for the image button (add module) => for now it is employee module
    private void ImageButtonListener() {
        this.mainAddModuleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Adding Service", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddModule.class);
                startActivity(intent);
            }
        });
    }
}