package com.example.jeffbelford.emailandsms3;

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

import static java.lang.Enum.valueOf;
import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {

        switch(view.getId())
        {
            case R.id.email:
                String [] to = {""};

                //enter your email above

                String subject = "email from section 3";
                composeEmail(to, subject);
                break;
            case R.id.sms:
                String message= "yo whatsup";
                composeMmsMessage(message);
                break;
            case R.id.smsDirect:
                //String message = "gotcha";
                composeDirectMmsMessage("dang it actually works");
                break;
            case R.id.phone:
                dialPhoneNumber();
                break;
            case R.id.phoneDirect:
                composeDirectPhone("calling");
                break;


        }
    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(intent.EXTRA_TEXT, "this is how to send an email");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeMmsMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"));
        intent.putExtra("address", "");

        //insert your own phone number above

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
            manager.sendTextMessage("9055806540",null,
                    "Direct SMS from Section 1",null,null);
            Log.i(TAG, "composeDirectMmsMessage: message sent ");
        }
    }

    public void dialPhoneNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + ""));

        //insert your own phone number above

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
                String number = "tel:" + "";

                //insert your phone number above

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(number));
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
