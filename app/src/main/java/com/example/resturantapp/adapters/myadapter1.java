package com.example.resturantapp.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model1;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class myadapter1 extends FirebaseRecyclerAdapter<model1, myadapter1.myviewholder> {
    public myadapter1(@NonNull FirebaseRecyclerOptions<model1> options) {

        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull final myadapter1.myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull  final model1 model1)
    {
        holder.name.setText(model1.getName());
        holder.price.setText(model1.getName());
        Glide.with(holder.img.getContext()).load(model1.getPurl()).into(holder.img);

        holder.delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Item")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
    }
    @NonNull
    @Override
    public myadapter1.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerrow1,parent,false);
        return new myadapter1.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        Button edit, delete;
        TextView name, price;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img1);
            name=(TextView) itemView.findViewById(R.id.nametext);
            price=(TextView) itemView.findViewById(R.id.pricetext);
            edit=(Button) itemView.findViewById(R.id.editicon);
            delete=(Button) itemView.findViewById(R.id.deleteicon);
        }
    }
}

