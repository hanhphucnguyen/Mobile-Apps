package com.example.phucinclass1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textAnswer;
    RadioButton setDefault;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textAnswer = findViewById(R.id.textAnswer);
        setDefault = findViewById(R.id.radioButton4);
        setDefault.setChecked(true);
        textAnswer.setText("None, I do not have phone");
    }

    public void onRadioClick(View view) {
        switch (view.getId())
        {
            case R.id.radioButton1:
                textAnswer.setText("Android, the icon are cool");
                break;
            case R.id.radioButton2:
                textAnswer.setText("Apple, I like Steve Jobs");
                break;
            case R.id.radioButton3:
                textAnswer.setText("Blackberry, I still have one");
                break;
            case R.id.radioButton4:
                textAnswer.setText("None, I do not have phone");
                break;

        }
    }
}
