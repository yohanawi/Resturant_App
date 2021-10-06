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
import com.example.resturantapp.ViewHolder.model1;

import java.util.ArrayList;

public class myadapter1 extends RecyclerView.Adapter<myadapter1.myviewholder> {

    ArrayList<model1> dataholder;

    public myadapter1(ArrayList<model1> dataholder) {
        this.dataholder = dataholder;
    }


    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerrow1, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dname.setText(dataholder.get(position).getName());
        holder.dprice.setText(dataholder.get(position).getPrice());
        holder.dpurl.setImageURI(dataholder.get(position).getPurl());

    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView dname;
        TextView dprice;
        ImageView dpurl;
        Button edit, delete;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dpurl = (ImageView) itemView.findViewById(R.id.img1);
            dname = (TextView) itemView.findViewById(R.id.nametext);
            dprice = (TextView) itemView.findViewById(R.id.pricetext);
            edit = (Button) itemView.findViewById(R.id.editicon);
            delete = (Button) itemView.findViewById(R.id.deleteicon);
        }
    }
}

