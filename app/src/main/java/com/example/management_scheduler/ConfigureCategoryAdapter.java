package com.example.management_scheduler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class ConfigureCategoryAdapter extends RecyclerView.Adapter<ConfigureCategoryAdapter.ViewHolder> {
    public List<ConfigureCategoryModule> categoryModuleList;
    public ClientModule clientModule;
    public ConfigureCategoryAdapter(List<ConfigureCategoryModule> categoryModuleList, ClientModule clientModule) {
        this.categoryModuleList = categoryModuleList;
        this.clientModule = clientModule;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.configure_category_card, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.presetText.setText(this.categoryModuleList.get(position).GetDataPreset().GetPresetName());
        holder.nameInput.setHint("Hello");
        //holder.shiftInput.setHint(this.clientModule.GetClientInformationList().clientDataList.get(0).GetClientInformation());

    }
    @Override
    public int getItemCount() {
        return this.categoryModuleList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardBackground, headerBackground, nameTextBackground, shiftTextBackground, editTextNameBackground, editTextShiftBackground;;
        public TextView headerText, presetText, nameText, shiftText;
        public ImageButton presetButton;
        public EditText nameInput, shiftInput;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.cardBackground = itemView.findViewById(R.id.configure_category_card_background);
            this.headerBackground = itemView.findViewById(R.id.configure_category_card_header_image);
            this.headerText = itemView.findViewById(R.id.configure_category_card_header_text);
            this.presetText = itemView.findViewById(R.id.configure_category_preset_text);
            this.presetButton = itemView.findViewById(R.id.configure_category_preset_button);
            this.nameText = itemView.findViewById(R.id.configure_category_input_name_header_text);
            this.shiftText = itemView.findViewById(R.id.configure_category_input_information_header_text);
            this.nameTextBackground = itemView.findViewById(R.id.configure_category_input_name_header_image);
            this.shiftTextBackground = itemView.findViewById(R.id.configure_category_input_information_header_image);
            this.editTextNameBackground = itemView.findViewById(R.id.configure_category_input_name_background);
            this.editTextShiftBackground = itemView.findViewById(R.id.configure_category_input_information_background);
            this.nameInput = itemView.findViewById(R.id.configure_category_input_name);
            this.shiftInput = itemView.findViewById(R.id.configure_category_input_information);
        }
    }
}
