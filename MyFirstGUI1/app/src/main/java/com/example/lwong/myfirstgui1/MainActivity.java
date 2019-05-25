package com.example.lwong.myfirstgui1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewColor = findViewById(R.id.textViewColor);
    }

    public void onRadioClick(View view) {
        switch (view.getId())
        {
            case R.id.radioButtonRed:
                textViewColor.setText(R.string.red);
                break;
            case R.id.radioButtonGreen:
                break;
            case R.id.radioButtonBlue:
                break;
        }
    }
}
