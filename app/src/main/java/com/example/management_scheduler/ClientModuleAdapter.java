package com.example.management_scheduler;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ListView;
public class ClientModuleAdapter extends ArrayAdapter<ClientModule> {
    public ArrayList<ClientModule> clientModuleList;
    public Context applicationContext;
    public ClientModuleAdapter(ArrayList<ClientModule> clientModuleList, Context applicationContext) {
        super(applicationContext, R.layout.main_layout_information, clientModuleList);
        this.clientModuleList = clientModuleList;
        this.applicationContext = applicationContext;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.applicationContext);
            convertView = inflater.inflate(R.layout.main_layout_information, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.listImageHeader = (ImageView)convertView.findViewById(R.id.list_information_header);
            viewHolder.listImageMain = (ImageView)convertView.findViewById(R.id.list_information_main);
            viewHolder.listData = (ListView)convertView.findViewById(R.id.list_information_list);

            // experimental
           /* ArrayList<ClientModule> clientModuleList = new ArrayList<ClientModule>();
            clientModuleList.add(new ClientModule());
            clientModuleList.add(new ClientModule());
            clientModuleList.add(new ClientModule());
            ClientModuleListAdapter moduleListAdapter = new ClientModuleListAdapter(clientModuleList, this.applicationContext);
            viewHolder.listData.setAdapter(moduleListAdapter);*/

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        return convertView;
    }
    private static class ViewHolder {
        public ImageView listImageHeader;
        public ImageView listImageMain;
        public ListView listData;
    }
}

        // look into this

        /*ViewGroup.LayoutParams layoutParams = innerListView.getLayoutParams();
        layoutParams.height = (int) context.getResources().getDimension(R.dimen.rowheight) * innerListView.getCount();
        innerListView.setLayoutParams(layoutParams);
        CustomAdapter adapter = new CustomAdapter(context, blabla..);
        innerListView.setAdapter(adapter);

        rowListView.invalidate();*/
