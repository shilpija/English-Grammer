package com.rdseducation.english.grammer;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentDrawer.FragmentDrawerListener {

    LinearLayout llBad, llTableTenn, ll1, ll2, ll3, ll4, ll5, llPractice, llQuesBank, llAbout;
    Toolbar mToolbar;
    DrawerLayout drawerLayout;
    String android_id, deviceId;
    private AdView mAdView;
    ImageView edit_profile;
    SharedData sharedData;
    //    InterstitialAd mInterstitialAd;
    Count count;
    public static int ClickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.admob_app_id));

        init();
    }

    private void init() {

        count = new Count(this);

        sharedData = new SharedData(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END);
        setSupportActionBar(mToolbar);

        FragmentDrawer drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, drawerLayout, mToolbar);
        drawerFragment.setDrawerListener(this);

        android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        deviceId = md5(android_id).toUpperCase();
        sharedData.AddData("deviceId", deviceId);
        Log.i("deviceid=", deviceId);

        llBad = (LinearLayout) findViewById(R.id.llBad);
        llQuesBank = (LinearLayout) findViewById(R.id.llQuesBank);
        llTableTenn = (LinearLayout) findViewById(R.id.llTableTenn);
        llPractice = (LinearLayout) findViewById(R.id.llPractice);
        llAbout = (LinearLayout) findViewById(R.id.llAbout);
        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);
        ll4 = (LinearLayout) findViewById(R.id.ll4);
        ll5 = (LinearLayout) findViewById(R.id.ll5);
        edit_profile = (ImageView) findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(this);
        llBad.setOnClickListener(this);
        llTableTenn.setOnClickListener(this);
        ll1.setOnClickListener(this);
        ll2.setOnClickListener(this);
        ll3.setOnClickListener(this);
        ll4.setOnClickListener(this);
        ll5.setOnClickListener(this);
        llPractice.setOnClickListener(this);
        llQuesBank.setOnClickListener(this);
        llAbout.setOnClickListener(this);

        mAdView = (AdView) findViewById(R.id.adView);
//        mInterstitialAd = new InterstitialAd(this);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(deviceId)
                .build();

        // Start loading the ad in the background.
//        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

//                Toast.makeText(MainActivity.this, "Ad loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClosed() {
//                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
//                Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
//                Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);

        // set the ad unit ID
//        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
//
//
//        // Load ads into Interstitial Ads
//        mInterstitialAd.loadAd(adRequest);
//
//        mInterstitialAd.setAdListener(new AdListener() {
//            public void onAdLoaded() {
//                showInterstitial();
//            }
//        });
    }

//    private void showInterstitial() {
//
//        if (mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//        }
//    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.edit_profile:

                count.countt();

                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    String sAux = "English Grammer पाने के लिए यहां क्लिक करें ";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName();
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }

                break;

            case R.id.llBad:

                count.countt();

                Intent intent = new Intent(MainActivity.this, Activity_pdf.class);
                intent.putExtra("EXTRA_SESSION_ID", "ant.pdf");
                startActivity(intent);
                break;

            case R.id.llTableTenn:

                count.countt();

                Intent intent1 = new Intent(MainActivity.this, Activity_Idoms.class);
                startActivity(intent1);

                break;

            case R.id.ll1:

                count.countt();

                Intent intent11 = new Intent(MainActivity.this, Activity_OneWord.class);
                startActivity(intent11);

                break;

            case R.id.ll2:

                count.countt();

                Intent intent6 = new Intent(MainActivity.this, Activity_pdf.class);
                intent6.putExtra("EXTRA_SESSION_ID", "phrasal.pdf");
                startActivity(intent6);
                break;

            case R.id.ll3:

                count.countt();

                Intent intent7 = new Intent(MainActivity.this, Activity_pdf.class);
                intent7.putExtra("EXTRA_SESSION_ID", "root.pdf");
                startActivity(intent7);
                break;

            case R.id.ll4:
                count.countt();

                Intent intent8 = new Intent(MainActivity.this, Activity_pdf.class);
                intent8.putExtra("EXTRA_SESSION_ID", "syn.pdf");
                startActivity(intent8);
                break;

            case R.id.ll5:
                count.countt();

                Intent intent9 = new Intent(MainActivity.this, Activity_pdf.class);
                intent9.putExtra("EXTRA_SESSION_ID", "voc.pdf");
                startActivity(intent9);
                break;

            case R.id.llPractice:
                count.countt();
                Intent intent10 = new Intent(MainActivity.this, Activity_pdf.class);
                intent10.putExtra("EXTRA_SESSION_ID", "practiceset.pdf");
                startActivity(intent10);
                break;

            case R.id.llQuesBank:
                count.countt();
                Intent intent31 = new Intent(MainActivity.this, Activity_pdf.class);
                intent31.putExtra("EXTRA_SESSION_ID", "questionbank.pdf");
                startActivity(intent31);
                break;

            case R.id.llAbout:
                count.countt();
                Intent intent2 = new Intent(MainActivity.this, Activity_AboutUs.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {

        switch (position) {
            case 0:
                count.countt();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;

            case 1:
                count.countt();
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    String sAux = "English Grammer पाने के लिए यहां क्लिक करें ";
                    sAux = sAux + "https://play.google.com/store/apps/details?id=" + MainActivity.this.getPackageName();
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }

                break;

            case 2:
                count.countt();
                Intent intent3 = new Intent(MainActivity.this, Activity_AboutUs.class);
                startActivity(intent3);
                intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;

            case 3:
                count.countt();
                Intent intent1 = new Intent(MainActivity.this, Activity_Rateus.class);
                startActivity(intent1);
                break;

            case 4:
                count.countt();
                Intent intent12 = new Intent(MainActivity.this, Activity_Website.class);
                startActivity(intent12);
                break;

            case 5:
                count.countt();
                Uri uri1 = Uri.parse("https://play.google.com/store/search?q=rds%20education");
                Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uri1);
                goToMarket1.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket1);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/search?q=rds%20education")));
                }
                break;


            case 6:
                count.countt();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/rdseducation/videos")));
                break;

            case 7:
                count.countt();
                Uri uri11 = Uri.parse("https://play.google.com/store/apps/details?id=com.rdseducation.english.grammer");
                Intent goToMarket11 = new Intent(Intent.ACTION_VIEW, uri11);
                goToMarket11.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket11);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.rdseducation.english.grammer")));
                }

                break;


        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //Handle the back button
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //Ask the user if they want to quit
            new AlertDialog.Builder(this)
                    .setTitle("English Grammer")
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            //Stop the activity
                            MainActivity.this.finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();

            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }


}
