package com.vandroid.sampleivanads;



import static com.vandroid.sampleivanads.SettingAds.BACKUP_ADS;
import static com.vandroid.sampleivanads.SettingAds.INITIALIZE_SDK;
import static com.vandroid.sampleivanads.SettingAds.INITIALIZE_SDK_BACKUPADS;
import static com.vandroid.sampleivanads.SettingAds.SELECT_ADS;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

import com.vandroid.ivanads.IvanOpenAds;
import com.vandroid.ivanads.IvanInitialize;


public class SplashActivity extends AppCompatActivity {
    private static final int REQUEST = 112;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        switch (SELECT_ADS) {
            case "ADMOB":
                IvanInitialize.SelectAdsAdmob(SplashActivity.this, BACKUP_ADS, INITIALIZE_SDK);
                break;
            case "GOOGLE-ADS":
                IvanInitialize.SelectAdsAdmob(SplashActivity.this, BACKUP_ADS, INITIALIZE_SDK);
                break;
            case "APPLOVIN-D":
                IvanInitialize.SelectAdsApplovinDis(SplashActivity.this, BACKUP_ADS, INITIALIZE_SDK);
                break;
            case "APPLOVIN-M":
                IvanInitialize.SelectAdsApplovinMax(SplashActivity.this, BACKUP_ADS, INITIALIZE_SDK);
                break;
            case "MOPUB":
                IvanInitialize.SelectAdsMopub(SplashActivity.this, BACKUP_ADS, INITIALIZE_SDK, INITIALIZE_SDK_BACKUPADS);
                break;
            case "IRON":
                IvanInitialize.SelectAdsIron(SplashActivity.this, BACKUP_ADS, INITIALIZE_SDK, INITIALIZE_SDK_BACKUPADS);
                break;
            case "STARTAPP":
                IvanInitialize.SelectAdsStartApp(SplashActivity.this, BACKUP_ADS, INITIALIZE_SDK,INITIALIZE_SDK_BACKUPADS);
                break;
            case "UNITY":
                IvanInitialize.SelectAdsUnity(SplashActivity.this,BACKUP_ADS,INITIALIZE_SDK,INITIALIZE_SDK_BACKUPADS);

                break;
        }
        IvanOpenAds.LoadOpenAds(SettingAds.OPEN_ADS_ADMOB);

        new CountDownTimer(10000, 1000) {
                @Override
                public void onFinish() {

                        Intent intent = new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent);
                        finish();


                }
                @Override
                public void onTick(long millisUntilFinished) {

                }
            }.start();

    }


}
