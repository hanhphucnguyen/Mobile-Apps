package com.example.inclass_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    TextView textViewReportName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        textViewReportName = findViewById(R.id.textViewReportName);
        textViewReportName.setText(getIntent().getExtras().getString("name"));
        textViewReportName.setTextSize(getIntent().getExtras().getFloat("size"));
    }

    public void onButtonClose(View view) {
        finish();
    }
}
