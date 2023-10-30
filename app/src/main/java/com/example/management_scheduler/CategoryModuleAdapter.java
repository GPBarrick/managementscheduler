package com.example.management_scheduler;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;
/* This class is responsible for linking the ClientModule and RecyclerView from within the activity_main.
* Within this class you must have a list of the client modules so you have a data structure to reference.
* This class will set the adapter of main_layout_information RecyclerView to ModuleDataAdapter.
* ModuleDataAdapter is responsible for inflating a separate layout that will display the ClientData. */
public class CategoryModuleAdapter extends RecyclerView.Adapter<CategoryModuleAdapter.ViewHolder> implements Serializable {
    /* Create a member data structure that is responsible for holding the modules.
    *  Create a member reference to the context. */
    public List<ClientModule> categoryModuleList;
    public Context applicationContext;
    public CategoryModuleAdapter(List<ClientModule> categoryModuleList, Context applicationContext) {
        this.categoryModuleList = categoryModuleList;
        this.applicationContext = applicationContext;
    }
    @NonNull
    @Override
    public CategoryModuleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /* Get the items from the 'blueprint' xml file so you can assign value to them. */
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_layout_information, parent, false);
        return new ViewHolder(viewItem);
    }
    @Override
    public void onBindViewHolder(@NonNull CategoryModuleAdapter.ViewHolder holder, int position) {
        /* Set the adapter and layout manager. */
        holder.clientInformationList.setLayoutManager(new LinearLayoutManager(this.applicationContext));
        /* The adapter responsible for linking the client data client module recycler view is needed
        * for every single client module since each inflated client data needs its own adapter. */
        holder.clientInformationList.setAdapter(this.categoryModuleList.get(position).GetClientInformationList());
        /* Set the size of the ClientModule to a relative size in relation to the CientData modules */
        if (this.categoryModuleList.get(position).GetClientInformationList().clientDataList.size() > 0) {
            ViewGroup.LayoutParams params = holder.categoryModuleBackground.getLayoutParams();
            int clientDataListSize = this.categoryModuleList.get(position).GetClientInformationList().clientDataList.size();
            int baseHeight = 170; /* The base height of the ImageView */
            int incrementPerElement = 110; /* Incremental height per element */
            int size = baseHeight + (clientDataListSize * incrementPerElement);
            params.height = size;
            holder.categoryModuleBackground.setLayoutParams(params);
        }
    }
    @Override
    public int getItemCount() {
        return categoryModuleList.size();
    }
    /* Get a reference to the RecyclerView from within the inflated main_layout_information layout. */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public RecyclerView clientInformationList;
        public ImageView categoryModuleBackground;
        public TextView mainHeaderText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.clientInformationList = itemView.findViewById(R.id.list_information_module);
            this.categoryModuleBackground = itemView.findViewById(R.id.list_information_main);
            this.mainHeaderText = itemView.findViewById(R.id.list_information_header_text);
        }
    }
}