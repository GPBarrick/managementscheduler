package com.example.management_scheduler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class ConfigureCategory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure_category);
        InitializeViews();
        InitializePresets();
        SetIntentValues();
    }
    public ImageView informationHeaderImage, informationMainBackground;
    public TextView formattingText;
    public RecyclerView recyclerView;
    private void InitializeViews() {
        this.informationHeaderImage = findViewById(R.id.configure_category_information_header);
        this.informationMainBackground= findViewById(R.id.configure_category_information_main);
        this.formattingText = findViewById(R.id.configure_category_information_header_text);
        this.recyclerView = findViewById(R.id.configure_category_recycler);
    }
    public int incomingDataSize;
    public DataPreset incomingDataPreset;
    public ClientModule clientModule;
    private void SetIntentValues() {
        this.formattingText.setText(getIntent().getStringExtra("category_name"));
        Log.v("(after)ma.cml.size() ", "= before");
        this.incomingDataSize = getIntent().getIntExtra("client_module_data_size", 0);
        this.clientModule = (ClientModule)getIntent().getSerializableExtra("client_module");
        Log.v("(after)ma.cml.size() ", "= after");
        if (this.clientModule != null) {
            this.incomingDataPreset = this.clientModule.GetDataPreset();
            Log.v("incoming_data", "= "+this.incomingDataSize);
            for (int i = 0; i < this.incomingDataSize; ++i) {
                this.configureModuleList.add(new ConfigureCategoryModule(this.incomingDataPreset));
            }
        }
    }
    public ArrayList<ConfigureCategoryModule> configureModuleList;
    public LinearLayoutManager layoutManager;
    public ConfigureCategoryAdapter configureCategoryAdapter;
    private void InitializePresets() {
        this.configureModuleList = new ArrayList<>();
        this.layoutManager = new LinearLayoutManager(this);
        this.configureCategoryAdapter = new ConfigureCategoryAdapter(this.configureModuleList, this.clientModule);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.recyclerView.setAdapter(this.configureCategoryAdapter);
    }
}