package com.example.lwong.datapersistance3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Spinner spinnerNum;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        spinnerNum = findViewById(R.id.spinner);
        ratingBar = findViewById(R.id.ratingBar);
    }

    public void onButtonReport(View view) {
        // launch the ReportActivity through the intent
        // bundling data to the intent to send it over to the other activity
        Intent intent = new Intent(this,ReportActivity.class);
        intent.putExtra("name",editTextName.getText().toString());
        intent.putExtra("spinner",spinnerNum.getSelectedItem().toString());
        intent.putExtra("rating",ratingBar.getRating());
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // save shared_pref
        SharedPreferences settings = getSharedPreferences("datapersistance",
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name",editTextName.getText().toString());
        editor.putInt("spinner",spinnerNum.getSelectedItemPosition());
        editor.putFloat("rating",ratingBar.getRating());
        // write shared pref to file
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //restore our shared_pref
        SharedPreferences settings = getSharedPreferences("datapersistance",
                Context.MODE_PRIVATE);
        editTextName.setText(settings.getString("name",""));
        spinnerNum.setSelection(settings.getInt("spinner",0));
        ratingBar.setRating(settings.getFloat("rating",0.0f));
    }
    // Save the name to file
    public void onButtonSave(View view) {
        try
        {
            // to save to file "test.txt" in data/data/packagename/File
            FileOutputStream ofile = openFileOutput("test.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(ofile);
            osw.write(editTextName.getText().toString());
            osw.flush();
            osw.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    // Read the name from file
    public void onButtonRead(View view) {
        // read the file from the data/data/packagename
        try
        {
            // reading from data/data/packagename/File
            FileInputStream fin = openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(fin);
            char [] inputBuffer = new char[100];
            String str="";
            int charRead;
            while((charRead = isr.read(inputBuffer)) > 0)
            {
                String readString =String.copyValueOf(inputBuffer,0,charRead);
                str += readString;
            }
            editTextName.setText(str);
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}
