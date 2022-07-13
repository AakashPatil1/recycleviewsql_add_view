package com.aakash.recycleviewsql;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList name_id,add_id,phone_id, bg_id;

/*
    public MyAdapter(Context context, ArrayList name_id, ArrayList email_id, ArrayList age_id) {
        this.context = context;
        this.name_id = name_id;
        this.email_id = email_id;
        this.age_id = age_id;
    }

 */

    public MyAdapter(Context context, ArrayList name_id, ArrayList add_id, ArrayList phone_id, ArrayList bg_id) {
        this.context = context;
        this.name_id = name_id;
        this.add_id = add_id;
        this.phone_id = phone_id;
        this.bg_id = bg_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.add_id.setText(String.valueOf(add_id.get(position)));
        holder.phone_id.setText(String.valueOf(phone_id.get(position)));
        holder.bg_id.setText(String.valueOf(bg_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name_id,add_id , phone_id, bg_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id = itemView.findViewById(R.id.name);
            add_id = itemView.findViewById(R.id.add);
            phone_id = itemView.findViewById(R.id.parentno);
            bg_id = itemView.findViewById(R.id.bg);
        }
    }
}
