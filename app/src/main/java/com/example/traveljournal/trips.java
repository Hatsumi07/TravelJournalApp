package com.example.traveljournal;

import java.util.ArrayList;

public class trips {
    ArrayList<travelExp> tripsList = new ArrayList<travelExp>();
    StringBuilder tripsInfo = new StringBuilder();
    public trips(){
    }
    public void addToTrips(travelExp trip) {
        tripsList.add(trip);
    }
    public void addToTripsString(travelExp trip){
        tripsInfo.append(trip.info);
    }
}
