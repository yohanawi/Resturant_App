package com.example.resturantapp.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resturantapp.R;
import com.example.resturantapp.ViewHolder.model2;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class myadapter2 extends FirebaseRecyclerAdapter<model2, myadapter2.myviewholder> {
    public myadapter2(@NonNull FirebaseRecyclerOptions<model2> options) {

        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull final myadapter2.myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull  final model2 model2)
    {
        holder.name.setText(model2.getName());
        holder.phone.setText(model2.getPhone());
        holder.id.setText(model2.getId());
        holder.location.setText(model2.getLocation());

        holder.delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("Shipper")
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
    public myadapter2.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow2,parent,false);
        return new myadapter2.myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        Button edit, delete;
        TextView name, phone, id, location;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name_text);
            phone=(TextView) itemView.findViewById(R.id.phone_text);
            id=(TextView) itemView.findViewById(R.id.id_text);
            location=(TextView) itemView.findViewById(R.id.location_text);
            edit=(Button) itemView.findViewById(R.id.edit_icon);
            delete=(Button) itemView.findViewById(R.id.delete_icon);
        }
    }
}


