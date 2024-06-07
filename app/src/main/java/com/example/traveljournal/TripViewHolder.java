package com.example.traveljournal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class TripViewHolder extends RecyclerView.ViewHolder {

    public TextView tripTitleTv, tripDateTv, tripDescTv;
    public TripViewHolder(@NonNull View itemView) {
        super(itemView);
        tripTitleTv = itemView.findViewById(R.id.trip_title_tv);
        tripDateTv = itemView.findViewById(R.id.trip_date_tv);
        tripDescTv = itemView.findViewById(R.id.trip_desc_tv);

    }
}
