package com.example.lwong.myjoke3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // may define textViewJoke in function but do it here if you
    // want to use it in several callback functions
    TextView textViewJoke;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // sets the id from xml to the textViewJoke
        textViewJoke =findViewById(R.id.textviewjoke);
    }

    public void OnButtonJoke(View view) {
        // toggle the visibility of the textViewJoke
        if(textViewJoke.getVisibility() == View.VISIBLE)
            textViewJoke.setVisibility(View.INVISIBLE);
        else
            textViewJoke.setVisibility(View.VISIBLE);
    }
}
