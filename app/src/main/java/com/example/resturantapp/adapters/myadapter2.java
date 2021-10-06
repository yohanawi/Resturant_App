package com.example.resturantapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model2;

import java.util.ArrayList;

public class myadapter2 extends RecyclerView.Adapter<myadapter2.myviewholder> {
    ArrayList<model2> dataholder;

    public myadapter2(ArrayList<model2> dataholder) {
        this.dataholder = dataholder;
    }


    @Override
    public myadapter2.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow2, parent, false);
        return new myadapter2.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter2.myviewholder holder, int position) {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dphone.setText(dataholder.get(position).getPhone());
        holder.did.setText(dataholder.get(position).getId());
        holder.location.setText(dataholder.get(position).getLocation());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView dname;
        TextView did;
        TextView dphone;
        TextView location;
        Button edit, delete;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dname = (TextView) itemView.findViewById(R.id.name_text);
            dphone = (TextView) itemView.findViewById(R.id.phone_text);
            did = (TextView) itemView.findViewById(R.id.id_text);
            location = (TextView) itemView.findViewById(R.id.location_text);
            edit = (Button) itemView.findViewById(R.id.edit_icon);
            delete = (Button) itemView.findViewById(R.id.delete_icon);
        }
    }
}


