package com.rdseducation.english.grammer;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Count {


    SharedData sharedData;
    private Context context;
    InterstitialAd mInterstitialAd;
    String android_id, deviceId;

    public Count(Context context) {

        this.context=context;
        sharedData = new SharedData(context);


        if (sharedData !=null){
            deviceId = sharedData.getValue("deviceId");
        }
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(context.getString(R.string.interstitial_full_screen));

    }

    public void countt() {
        MainActivity.ClickCount = MainActivity.ClickCount +1;

        Log.d("counterCal", String.valueOf(MainActivity.ClickCount));


        if (MainActivity.ClickCount == 4){
            //counter = 0;
            MainActivity.ClickCount = 0;
            Log.d("MainActivity.ClickCount","4");


            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(deviceId)
                    .build();

            // Load ads into Interstitial Ads
            mInterstitialAd.loadAd(adRequest);

            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    showInterstitial();
                }
            });
        }

    }

    private void showInterstitial() {

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

}
