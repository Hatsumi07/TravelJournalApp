package com.example.traveljournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class AddTravelExp extends AppCompatActivity {

    private Button add_trip;

    private EditText tripTitle;
    private EditText tripDesc;
    private EditText tripDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel_exp);
    }
    public void postTravelExp(View v) {
        //gets user input
        tripTitle = (EditText)findViewById(R.id.tripTitle);
        tripDesc = (EditText)findViewById(R.id.tripDesc);
        tripDate = (EditText)findViewById(R.id.tripDate);

        String title = tripTitle.getText().toString();
        String desc = tripDesc.getText().toString();
        String date = tripDate.getText().toString();

        //checks that user input is not empty
        if (title.isEmpty()){
            tripTitle.setError("Cannot be empty");
            return;
        }

        if (desc.isEmpty()){
            tripDesc.setError("Cannot be empty");
            return;
        }

        if (date.isEmpty()){
            tripDate.setError("Cannot be empty");
            return;
        }

        //adds trip data to database
        addTripToDB(title, desc, date);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void addTripToDB(String title, String desc, String date) {
        //Creates a hashmap
        HashMap<String, Object> tripHashMap = new HashMap<>();
        tripHashMap.put("title", title);
        tripHashMap.put("desc", desc);
        tripHashMap.put("date", date);

        //instantiates database connection
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference tripsRef = database.getReference("trips");

        String key = tripsRef.push().getKey();
        tripHashMap.put("key", key);

        tripsRef.child(key).setValue(tripHashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(AddTravelExp.this, "Added", Toast.LENGTH_SHORT).show();
                tripTitle.getText().clear();
                tripDesc.getText().clear();
                tripDate.getText().clear();
            }
        });
    }
}