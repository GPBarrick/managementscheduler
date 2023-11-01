package com.example.management_scheduler;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;
public class CreateOrganizer extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_organizer);
        InitializeViews();
        SetButtonListener();
    }
    /* Create public members of the objects that will be associated with the XML widgets */
    public ImageView headerTextBackground, nameTextBackground, backgroundAccentBack, backgroundAccentFront,
    inputNameBackground;
    public TextView headerText, nameText;
    public EditText nameInput;
    public Button createButton;
    /* Create a function that will initialize the object members to the XML widgets */
    private void InitializeViews() {
        backgroundAccentBack = findViewById(R.id.activity_create_information_main);
        headerTextBackground = findViewById(R.id.activity_create_information_header);
        headerText = findViewById(R.id.activity_create_information_header_text);
        backgroundAccentFront = findViewById(R.id.activity_create_information_main_front);
        nameTextBackground = findViewById(R.id.activity_create_name_header);
        nameText = findViewById(R.id.activity_create_credentials_title);
        inputNameBackground = findViewById(R.id.activity_create_credentials_input_background);
        nameInput = findViewById(R.id.activity_create_credentials_input);
        createButton = findViewById(R.id.activity_create_create_button);
    }
    /* Create a function that handles the click listener for the button object */
    private void SetButtonListener() {
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchIntent = new Intent(CreateOrganizer.this, MainActivity.class);
                switchIntent.putExtra("name_input", nameInput.getText().toString());
                switchIntent.putExtra("returning_from", 10);
                startActivity(switchIntent);
            }
        });
    }
}