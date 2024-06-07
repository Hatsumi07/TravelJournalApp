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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

//StringBuilder trips = new StringBuilder();

public class MainActivity extends AppCompatActivity {

    Button addTravel;
    TextView tripInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        tripInfo = (TextView) findViewById(R.id.tripInfo);
        //if(newTrip == null){
          //  tripInfo.setText("No Trips!");
        //} else {
          //  trips.append("NEW TRIP:\n").append(newTrip).append("\n");
            //tripInfo.setText(trips);
        //}
    }

    public void addTravelExp(View v) {
        Intent i = new Intent(this, AddTravelExp.class);
        //i.putExtra("trips_array", (Serializable) tripsList);
        //i.putExtra("trips_string_list", (CharSequence) tripsInfo);
        startActivity(i);
    }

}