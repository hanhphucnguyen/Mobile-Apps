package com.example.lwong.datapersistance3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    TextView textViewReportName;
    TextView textViewReportSpinner;
    RatingBar ratingBarReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        // get the values from the bundle
        textViewReportName = findViewById(R.id.textViewReportName);
        textViewReportSpinner = findViewById(R.id.textViewReportSpinner);
        ratingBarReport = findViewById(R.id.ratingBarReport);
        // set the widgets to the data from the bundle
        textViewReportName.setText(getIntent().getExtras().getString("name"));
        textViewReportSpinner.setText(getIntent().getExtras().getString("spinner"));
        ratingBarReport.setRating(getIntent().getExtras().getFloat("rating"));
    }
    // close the current activity
    public void onButtonClose(View view) {
        finish();
    }
}
