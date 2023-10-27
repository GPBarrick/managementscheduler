package com.example.management_scheduler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Button;
import java.util.ArrayList;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set views to an object
        InitializeViews();
        // add listener for mainLayoutAdditionButton
        AdditionButtonListener();
        // initialize the data structure of ClientModule
        InitializeClientModuleList();
        // initialize the adapter to link the data structure to the xml widget object
        InitializeClientModuleAdapter();
        // set the adapter
        SetListViewAdapter();
    }
    // create xml widget object members
    public ImageView mainTopBanner, mainInformationHeader, mainInformationMain;
    public ListView mainLayoutList;
    public Button mainLayoutAdditionButton;
    public TextView mainLayoutHeaderText;
    // initialize objects to their xml widget id
    private void InitializeViews() {
        this.mainTopBanner = findViewById(R.id.main_layout_top_banner);
        this.mainInformationHeader = findViewById(R.id.main_layout_information_header);
        this.mainInformationMain = findViewById(R.id.main_layout_information_main);
        this.mainLayoutList = findViewById(R.id.main_layout_list);
        this.mainLayoutAdditionButton = findViewById(R.id.main_layout_addition_button);
        this.mainLayoutHeaderText = findViewById(R.id.main_layout_information_header_text);
    }
    // create addition button listener
    private void AdditionButtonListener() {
        this.mainLayoutAdditionButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
        });
    }
    // create data structure of ClientModule
    public ArrayList<ClientModule> clientModuleList;
    // initialize data structure of ClientModule
    private void InitializeClientModuleList() {
        this.clientModuleList = new ArrayList<>();
        this.clientModuleList.add(new ClientModule());
        this.clientModuleList.add(new ClientModule());
    }
    // create the adapter to link the data structure and xml layout
    public ClientModuleAdapter clientModuleAdapter;
    private void InitializeClientModuleAdapter() {
        this.clientModuleAdapter = new ClientModuleAdapter(this.clientModuleList, getApplicationContext());
    }
    // set the adapter
    private void SetListViewAdapter() {
        this.mainLayoutList.setAdapter(this.clientModuleAdapter);
    }
}