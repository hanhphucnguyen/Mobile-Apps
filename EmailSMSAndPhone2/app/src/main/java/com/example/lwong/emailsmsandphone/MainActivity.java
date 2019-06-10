package com.example.lwong.emailsmsandphone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonEmail:
                String [] to = {"lwong@fanshawec.ca","lwong@fanshaweonline.ca"};
                composeEmail(to, "Sending email from section 2");
                break;
            case R.id.buttonSMS:
                composeMmsMessage("SMS from Section 2");
                break;
            case R.id.buttonSMSDirect:
                composeDirectMmsMessage("SMS from Section 2");
                break;
            case R.id.buttonPhone:
                dialPhoneNumber("5194524291");
                break;
            case R.id.buttonPhoneDirect:
                composeDirectPhone("tel:5196578127");
                break;
        }
    }
    public final String TAG = "EmailAndSMS";
    public void composeEmail(String[] addresses, String subject) {
        Log.i(TAG, "composeEmail: ");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        String[] to = {"lwong@fanshawec.ca","lwong@fanshaweonline.ca"};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "This is how to send an email");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeMmsMessage(String message) {
        Log.i(TAG, "composeMmsMessage: ");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
        intent.setType("text/plain");
        intent.putExtra("address", "5555215554");
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeDirectMmsMessage(String message) {
        Log.i(TAG, "composeDirectMmsMessage: ");
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.READ_PHONE_STATE)
                        != PackageManager.PERMISSION_GRANTED){
            Log.i(TAG, "composeDirectMmsMessage: granting permission");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},1);
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_PHONE_STATE},1);
        }
        else
        {   // Permission already granted
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage("519878936",null,
                    "Direct SMS from Section 2",null,null);
            Log.i(TAG, "composeDirectMmsMessage: message sent ");
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void composeDirectPhone(String message) {
        Log.i(TAG, "composeDirectPhone: ");
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED){
            Log.i(TAG, "composeDirectMmsMessage: granting permission");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},1);
        }
        else
        {   // Permission already granted
            try {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(message));
                startActivity(intent);
            }
            catch (SecurityException e)
            {
                e.printStackTrace();;
            }
            Log.i(TAG, "composeDirectMmsMessage: message sent ");
        }
    }

}
