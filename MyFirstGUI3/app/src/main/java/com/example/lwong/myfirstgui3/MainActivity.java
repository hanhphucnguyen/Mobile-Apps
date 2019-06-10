package com.example.lwong.myfirstgui3;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewColor;
    CheckBox checkBoxBold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewColor = findViewById(R.id.textViewColor);
        checkBoxBold = findViewById(R.id.checkBoxBold);
    }

    public void onRadioClick(View view) {
        // view is the widget that initiated the callback
        // getId translate the view to the resource id set in layout
        switch(view.getId())
        {   // sets the text and background of the textview to the
            // color of the radio button clicked
            case R.id.radioButtonRed:
                textViewColor.setText(R.string.red);
                textViewColor.setBackgroundColor(Color.RED);
                break;
            case R.id.radioButtonGreen:
                textViewColor.setText(R.string.green);
                textViewColor.setBackgroundColor(Color.GREEN);
                break;
            case R.id.radioButtonBlue:
                textViewColor.setText(R.string.blue);
                textViewColor.setBackgroundColor(Color.BLUE);
                break;
        }
    }
    // sets the textView to bold if the bold checkbox is checked
    public void onCheckBoxClicked(View view) {
        if(checkBoxBold.isChecked()== true)
            textViewColor.setTypeface(Typeface.DEFAULT_BOLD);
        else
            textViewColor.setTypeface(Typeface.DEFAULT);

    }
}
