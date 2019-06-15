package com.example.inclass_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    float i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
    }

    public void onButtonReport(View view) {
        Intent intent = new Intent(this,ReportActivity.class);
        intent.putExtra("name",editTextName.getText().toString());
        intent.putExtra("size",i);
        startActivity(intent);
    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences("inclass2",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name",editTextName.getText().toString());
        editor.putFloat("size",i);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //restore our shared_pref
        SharedPreferences settings = getSharedPreferences("inclass2",
                Context.MODE_PRIVATE);
        editTextName.setText(settings.getString("name",""));
    }
    */

    public void onRadioClick(View view) {

        switch(view.getId())
        {
            case R.id._14:
                i= 14.0f;
                break;
            case R.id._24:
                i= 24.0f;
                break;
            case R.id._48:
                i= 48.0f;
                break;
            case R.id._72:
                i= 72.0f;
                break;
        }
    }
}
