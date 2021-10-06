package com.example.resturantapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }


    @Override
    public myadapter.myviewholder onCreateViewHolder (@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myadapter.myviewholder(view);
    }
    @Override
    public void onBindViewHolder (@NonNull myadapter.myviewholder holder, int position)
    {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dpurl.setImageURI(dataholder.get(position).getPurl());

    }

    @Override
    public int getItemCount () {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView dname;
        ImageView dpurl;
        Button edit, delete;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dpurl = (ImageView) itemView.findViewById(R.id.img1);
            dname = (TextView) itemView.findViewById(R.id.nametext);
            edit = (Button) itemView.findViewById(R.id.editicon);
            delete = (Button) itemView.findViewById(R.id.deleteicon);
        }
    }
}


