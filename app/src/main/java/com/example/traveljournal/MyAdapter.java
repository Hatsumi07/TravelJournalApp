package com.example.traveljournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.Trip;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Trip> list;

    public MyAdapter(Context context, ArrayList<Trip> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.trip_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Trip trip = list.get(position);
        holder.tripTitle.setText(trip.getTitle());
        holder.tripDate.setText(trip.getDate());
        holder.tripDesc.setText(trip.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tripTitle, tripDate, tripDesc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tripTitle = itemView.findViewById(R.id.tripTitleTv);
            tripDate = itemView.findViewById(R.id.tripDateTv);
            tripDesc = itemView.findViewById(R.id.tripDescTv);

        }
    }

}
