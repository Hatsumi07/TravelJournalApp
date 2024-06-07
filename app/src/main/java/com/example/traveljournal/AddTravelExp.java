package com.example.traveljournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddTravelExp extends AppCompatActivity {

    private Button add_trip;

    Intent i = getIntent();
    ArrayList<travelExp> tripsList = new ArrayList<>();
    //StringBuilder tripsInfo = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel_exp);
        //tripsList = (ArrayList<travelExp>) getIntent().getSerializableExtra("trips_array");
    }
    public void postTravelExp(View v) {
        EditText tripTitle = (EditText)findViewById(R.id.tripTitle);
        EditText tripDesc = (EditText)findViewById(R.id.tripDesc);
        EditText tripDate = (EditText)findViewById(R.id.tripDate);
        travelExp newTrip = new travelExp(tripTitle.getText().toString(), tripDesc.getText().toString(), tripDate.getText().toString());
        //tripsList.add(newTrip);
        //tripsInfo.append("NEW TRIP!\n").append(newTrip.info).append("\n");

        Intent i = new Intent(this, MainActivity.class);
        //String travelTitle = ((Button)v).getText().toString();
        //i.putExtra("trip_added", true);
        Bundle mBundle = new Bundle();
        mBundle.putString("tripInfo", newTrip.info);
        mBundle.putString("tripAdded", String.valueOf(true));
        i.putExtras(mBundle);
        startActivity(i);
    }
}