package com.example.traveljournal;

import android.widget.TextView;

import java.io.Serializable;

public class travelExp implements Serializable {
    String title;
    String description;
    String date;

    String info;
    public travelExp(String travelTitle, String travelDescription, String travelDate) {
        title = travelTitle;
        description = travelDescription;
        date = travelDate;
        info = travelTitle + "\n" + travelDescription + "\n" + travelDate;
    }

    public void show(TextView textView) {
        String travelInfo = title + "\n" + description + "\n" + date;
        textView.setText(travelInfo);
        //Toast.makeText(v.getContext(), travelInfo, Toast.LENGTH_SHORT).show();
    }
}
