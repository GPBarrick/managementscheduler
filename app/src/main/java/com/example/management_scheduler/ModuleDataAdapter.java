package com.example.management_scheduler;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
/* This class is responsible for setting the members from within ClientData that you are accessing through this.clientDataList.
* This adapter is set from within the CategoryModuleAdapter and this.clientDataList is set from within the MainActivity. */
public class ModuleDataAdapter extends RecyclerView.Adapter<ModuleDataAdapter.ViewHolder> implements Serializable {
    public List<ClientData> clientDataList;
    public ModuleDataAdapter(List<ClientData> clientDataList) {
        this.clientDataList = clientDataList;
    }
    @NonNull
    @Override
    public ModuleDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /* Create an access point to the layout you will use to get the view object reference id. */
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.client_data_layout, parent, false);
        return new ViewHolder(viewItem);
    }
    @Override
    public void onBindViewHolder(@NonNull ModuleDataAdapter.ViewHolder holder, int position) {
        /* Set the ClientData members. */
        if (this.clientDataList.size() > 0) {
            holder.clientName.setText(this.clientDataList.get(position).GetClientName());
            holder.clientInformation.setText(this.clientDataList.get(position).GetClientInformation());
        }
    }
    @Override
    public int getItemCount() {
        return this.clientDataList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        /* Get a reference to your views from within the inflated layout being used to display this information. */
        public TextView clientName;
        public TextView clientInformation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.clientName = itemView.findViewById(R.id.client_data_name);
            this.clientInformation = itemView.findViewById(R.id.client_data_information);
        }
    }
}
