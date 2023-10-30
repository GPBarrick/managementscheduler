package com.example.management_scheduler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Button;
import java.util.ArrayList;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeViews();
        InitializeCategoryModule();
        CreateOrganizerButton(this.clientModuleList);
    }
    public ImageView mainInformationHeader, mainInformationMain;
    public RecyclerView mainLayoutList;
    public Button createOrganizerButton;
    public TextView mainLayoutHeaderText;
    private void InitializeViews() {
        this.mainInformationHeader = findViewById(R.id.main_layout_information_header);
        this.mainInformationMain = findViewById(R.id.main_layout_information_main);
        this.mainLayoutList = findViewById(R.id.main_layout_list);
        this.createOrganizerButton = findViewById(R.id.main_layout_addition_button);
        this.mainLayoutHeaderText = findViewById(R.id.main_layout_information_header_text);
    }
    public static ArrayList<ClientModule> clientModuleList;
    public LinearLayoutManager layoutManager;
    public CategoryModuleAdapter categoryModuleAdapter;
    /*public ArrayList<ClientData> clientDataList;
    public ArrayList<ClientData> clientDataList2;*/
    private void InitializeCategoryModule() {
        /*this.clientDataList2 = new ArrayList<>();
        this.clientDataList = new ArrayList<>();
        this.clientDataList.add(new ClientData("Alexander R", "8:00AM-12:00AM"));
        this.clientModuleList.add(new ClientModule(new ModuleDataAdapter(this.clientDataList)));
        this.clientDataList2.add(new ClientData("Alex", "DSP"));
        this.clientDataList2.add(new ClientData("Alex", "DSP"));
        this.clientDataList2.add(new ClientData("Alex", "DSP"));
        this.clientModuleList.add(new ClientModule(new ModuleDataAdapter(this.clientDataList2)));*/

        /* Create the components responsible for initializing the adapters and apply data from intent */
        if (this.clientModuleList == null) {
            this.clientModuleList = new ArrayList<ClientModule>();
        }
        Log.v("ma.cml.size() ", "= "+this.clientModuleList.size());
        SetIntentData();
        this.categoryModuleAdapter = new CategoryModuleAdapter(this.clientModuleList, getApplicationContext());
        this.layoutManager = new LinearLayoutManager(this);
        this.mainLayoutList.setLayoutManager(this.layoutManager);
        this.mainLayoutList.setAdapter(this.categoryModuleAdapter);
    }
    private void CreateOrganizerButton(ArrayList<ClientModule> clientModuleList) {
        this.createOrganizerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchIntent = new Intent(MainActivity.this, CreateOrganizer.class);
                startActivity(switchIntent);
            }
        });
    }
    private void SetIntentData() {
        int returnAddress = getIntent().getIntExtra("returning_from", 0);
        Log.v("returning_from", "= "+returnAddress);
        if (returnAddress == 0) {
        } else if (returnAddress == 10) {
            Log.v("name_input", "= "+getIntent().getStringExtra("name_input"));
            this.clientModuleList.add(new ClientModule(new ModuleDataAdapter(new ArrayList<ClientData>())));
            Log.v("(after)ma.cml.size() ", "= "+this.clientModuleList.size());
        }
    }
}