package com.example.management_scheduler;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
public class AddModule extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_module);
        // Assign a reference to the id and object
        InitializeViews();
        // Initialize a button listener to listen to use action
        CreateConfirmButtonListener();
    }
    // create xml widget objects
    public TextView inputHeaderText;
    public ImageView inputHeaderImage, inputMainImage;
    public EditText nameInput, scheduleInput;
    public Button confirmInputButton;
    // assign xml widget id to objects
    private void InitializeViews() {
        this.inputHeaderText = findViewById(R.id.input_information_header_text);
        this.inputHeaderImage = findViewById(R.id.input_information_header_image);
        this.inputMainImage = findViewById(R.id.input_information_main_image);
        this.nameInput = findViewById(R.id.input_information_name);
        this.scheduleInput = findViewById(R.id.input_information_schedule);
        this.confirmInputButton = findViewById(R.id.input_information_confirm_button);
    }
    // create a function to gather input from the edit text elements to store into members
    private String[] GetUserInput() {
        return new String[] { this.nameInput.getText().toString(), this.scheduleInput.getText().toString() };
    }
    // create a listener for the button
    private void CreateConfirmButtonListener() {
        this.confirmInputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetUserInput();
                Intent intentSwitcher = new Intent(AddModule.this, MainActivity.class);
                Intent intentGetter = getIntent();
                ArrayList<EmployeeModule> extraEmployeeModule = (ArrayList<EmployeeModule>)intentGetter.getSerializableExtra("module_list");
                String nameInputStr = GetUserInput()[0];
                String scheduleInputStr = GetUserInput()[1];
                extraEmployeeModule.add(new EmployeeModule(nameInputStr, scheduleInputStr, 0));
                intentSwitcher.putExtra("module_list_send_back", extraEmployeeModule);
                startActivity(intentSwitcher);
            }
        });
    }
}