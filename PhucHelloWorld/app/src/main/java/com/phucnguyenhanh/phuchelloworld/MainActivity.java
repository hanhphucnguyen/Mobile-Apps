package com.phucnguyenhanh.phuchelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView answer_t;
    CheckBox cb1,cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer_t = findViewById(R.id.answerText);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
    }
    public void OnButtonAction(View view) {
        if (!cb1.isChecked() && !cb2.isChecked()) answer_t.setText("Please select one answer!!!");
        else
        {
            if (cb1.isChecked() && cb2.isChecked()) answer_t.setText("You should select only 1!!!");
            else {
                if (cb2.isChecked()) answer_t.setText("Wrong answer hahaha!!!");
                else answer_t.setText("U chose the correct answer!!");
            }
        }
        answer_t.setVisibility(View.VISIBLE);
    }
    public void PlayagainAction(View view) {
        if(cb1.isChecked()){
            cb1.toggle();
        }
        if(cb2.isChecked()){
            cb2.toggle();
        }
        answer_t.setVisibility(View.INVISIBLE);
    }
}
