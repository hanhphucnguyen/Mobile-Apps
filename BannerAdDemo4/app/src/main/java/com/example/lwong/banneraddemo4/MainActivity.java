package com.example.lwong.banneraddemo4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/*
Note: Banner adds updated to
 */

public class MainActivity extends AppCompatActivity {

    private AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        // Initialize MobileAds onCreate
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        // Setup the Banner Ad
        adView = findViewById(R.id.adView);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        adRequestBuilder.addKeyword("fitness");
        adRequestBuilder.addKeyword("workout");
        adView.loadAd(adRequestBuilder.build());
    }

    @Override
    protected void onPause() {
        if(adView != null)
            adView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(adView != null)
            adView.resume();
    }

    @Override
    protected void onDestroy() {
        if(adView != null)
            adView.destroy();
        super.onDestroy();
    }
}
