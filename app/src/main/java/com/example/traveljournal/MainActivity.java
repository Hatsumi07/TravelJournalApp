package com.example.traveljournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;

StringBuilder trips = new StringBuilder();

public class MainActivity extends AppCompatActivity {

    ArrayList<travelExp> tripsList = new ArrayList<travelExp>();
    TextView tripInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tripInfo = (TextView) findViewById(R.id.tripInfo);
        Intent i = getIntent();
        String newTrip = i.getStringExtra("tripInfo");
        boolean tripAdded = i.getBooleanExtra("tripAdded", true);
        if(newTrip == null){
            tripInfo.setText("No Trips!");
        } else {
            trips.append("NEW TRIP:\n").append(newTrip).append("\n");
            tripInfo.setText(trips);
        }
    }

    public void addTravelExp(View v) {
        Intent i = new Intent(this, AddTravelExp.class);
        i.putExtra("trips_array", (Serializable) tripsList);
        //i.putExtra("trips_string_list", (CharSequence) tripsInfo);
        startActivity(i);
    }

    public void displayTrips() {
        tripInfo.setText(trips);
    }
}