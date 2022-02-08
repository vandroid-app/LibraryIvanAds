package com.vandroid.sampleivanads;

import static com.vandroid.sampleivanads.SettingAds.BACKUP_ADS;
import static com.vandroid.sampleivanads.SettingAds.BACKUP_ADS_BANNER;
import static com.vandroid.sampleivanads.SettingAds.BACKUP_ADS_INTERTITIAL;
import static com.vandroid.sampleivanads.SettingAds.BACKUP_ADS_REWARDS;
import static com.vandroid.sampleivanads.SettingAds.HIGH_PAYING_KEYWORD1;
import static com.vandroid.sampleivanads.SettingAds.HIGH_PAYING_KEYWORD2;
import static com.vandroid.sampleivanads.SettingAds.HIGH_PAYING_KEYWORD3;
import static com.vandroid.sampleivanads.SettingAds.HIGH_PAYING_KEYWORD4;
import static com.vandroid.sampleivanads.SettingAds.HIGH_PAYING_KEYWORD5;
import static com.vandroid.sampleivanads.SettingAds.INITIALIZE_SDK;
import static com.vandroid.sampleivanads.SettingAds.INITIALIZE_SDK_BACKUPADS;
import static com.vandroid.sampleivanads.SettingAds.INTERVAL;
import static com.vandroid.sampleivanads.SettingAds.MAIN_ADS_BANNER;
import static com.vandroid.sampleivanads.SettingAds.MAIN_ADS_INTERTITIAL;
import static com.vandroid.sampleivanads.SettingAds.MAIN_ADS_REWARDS;
import static com.vandroid.sampleivanads.SettingAds.NATIVE_ADS_ADMOB;
import static com.vandroid.sampleivanads.SettingAds.SELECT_ADS;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vandroid.ivanads.IvanGDPR;
import com.vandroid.ivanads.IvanBanner;
import com.vandroid.ivanads.IvanInitialize;
import com.vandroid.ivanads.IvanIntertitial;
import com.vandroid.ivanads.IvanNative;
import com.vandroid.ivanads.IvanReward;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layAds = findViewById(R.id.layAds);
        FrameLayout nativeads = findViewById(R.id.laynative);
        RelativeLayout layAdsmall = findViewById(R.id.laysAdsmall);
        IvanGDPR.loadGdpr(MainActivity.this,SELECT_ADS,true);

        /*IvanBanner.MediumBanner(MainActivity.this, layAds,SettingAds.SELECT_ADS, SettingAds.MAIN_ADS_BANNER,HIGH_PAYING_KEYWORD1
        ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5);
        IvanBanner.SmallBanner(MainActivity.this, layAdsmall,SettingAds.SELECT_ADS, SettingAds.MAIN_ADS_BANNER,HIGH_PAYING_KEYWORD1
                ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5);
        IvanIntertitial.LoadIntertitial(MainActivity.this, SettingAds.SELECT_ADS, SettingAds.MAIN_ADS_INTERTITIAL,HIGH_PAYING_KEYWORD1
                ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5 );
        IvanNative.SmallNativeAdmob(MainActivity.this,SELECT_ADS, SettingAds.BACKUP_ADS, nativeads, NATIVE_ADS_ADMOB,MAIN_ADS_BANNER, HIGH_PAYING_KEYWORD1
                ,HIGH_PAYING_KEYWORD2,HIGH_PAYING_KEYWORD3,HIGH_PAYING_KEYWORD4,HIGH_PAYING_KEYWORD5);
        IvanReward.LoadReward(MainActivity.this, SELECT_ADS, MAIN_ADS_REWARDS );
        IvanOpenAds.ShowOpen(MainActivity.this);
         */

        switch (SELECT_ADS) {
            case "ADMOB":
                IvanInitialize.SelectAdsAdmob(MainActivity.this,BACKUP_ADS,INITIALIZE_SDK_BACKUPADS);
                  IvanIntertitial.LoadIntertitialAdmob(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, HIGH_PAYING_KEYWORD1,
                        HIGH_PAYING_KEYWORD2, HIGH_PAYING_KEYWORD3, HIGH_PAYING_KEYWORD4, HIGH_PAYING_KEYWORD5);
                IvanReward.LoadRewardAdmob(MainActivity.this,BACKUP_ADS,MAIN_ADS_REWARDS,BACKUP_ADS_REWARDS);
                IvanNative.SmallNativeAdmob(MainActivity.this, layAds,BACKUP_ADS,NATIVE_ADS_ADMOB,BACKUP_ADS_BANNER,HIGH_PAYING_KEYWORD1,
                        HIGH_PAYING_KEYWORD2, HIGH_PAYING_KEYWORD3, HIGH_PAYING_KEYWORD4, HIGH_PAYING_KEYWORD5);

                break;
            case "APPLOVIN-M":
                IvanInitialize.SelectAdsApplovinMax(MainActivity.this,BACKUP_ADS,INITIALIZE_SDK_BACKUPADS);
                IvanNative.SmallNativeMax(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                IvanReward.LoadRewardApplovinMax(MainActivity.this,BACKUP_ADS,MAIN_ADS_REWARDS,BACKUP_ADS_REWARDS);
                IvanIntertitial.LoadIntertitialApplovinMax(MainActivity.this, BACKUP_ADS,MAIN_ADS_INTERTITIAL,BACKUP_ADS_INTERTITIAL);
                break;
            case "APPLOVIN-D":
                IvanBanner.SmallBannerApplovinDis(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                IvanIntertitial.LoadIntertitialApplovinDis(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                break;
            case "MOPUB" :
                IvanBanner.SmallBannerMopub(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
               IvanIntertitial.LoadIntertitialMopub(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL,BACKUP_ADS_INTERTITIAL);
               IvanInitialize.SelectAdsMopub(MainActivity.this,BACKUP_ADS,INITIALIZE_SDK,INITIALIZE_SDK_BACKUPADS);
                IvanReward.LoadRewardMopub(MainActivity.this,BACKUP_ADS,MAIN_ADS_REWARDS,BACKUP_ADS_REWARDS);

                break;
            case "STARTAPP":
                IvanBanner.SmallBannerStartApp(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                IvanIntertitial.LoadIntertitialStartApp(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                break;
            case "IRON":
                IvanInitialize.SelectAdsIron(MainActivity.this,BACKUP_ADS,INITIALIZE_SDK,INITIALIZE_SDK_BACKUPADS);
                IvanBanner.SmallBannerIron(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
               IvanIntertitial.LoadIntertitialIron(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                break;
            case  "FACEBOOK":
                IvanInitialize.SelectAdsFAN(MainActivity.this,SELECT_ADS,INITIALIZE_SDK_BACKUPADS);
                IvanBanner.SmallBannerFAN(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                IvanIntertitial.LoadIntertitialFAN(MainActivity.this,BACKUP_ADS,MAIN_ADS_INTERTITIAL,BACKUP_ADS_INTERTITIAL);
                break;
            case "GOOGLE-ADS":
                IvanInitialize.SelectAdsGoogleAds(MainActivity.this,BACKUP_ADS,INITIALIZE_SDK_BACKUPADS);
                IvanBanner.SmallBannerGoogleAds(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                IvanIntertitial.LoadIntertitialGoogleAds(MainActivity.this,BACKUP_ADS,MAIN_ADS_INTERTITIAL,BACKUP_ADS_INTERTITIAL);
                IvanReward.LoadRewardGoogleAds(MainActivity.this,BACKUP_ADS,MAIN_ADS_REWARDS,BACKUP_ADS_REWARDS);

                break;
            case "UNITY":
                IvanInitialize.SelectAdsUnity(MainActivity.this,BACKUP_ADS,INITIALIZE_SDK,INITIALIZE_SDK_BACKUPADS);
                IvanBanner.SmallBannerUnity(MainActivity.this, layAds, BACKUP_ADS, MAIN_ADS_BANNER, BACKUP_ADS_BANNER);
                IvanIntertitial.LoadIntertitialUnity(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL);
                IvanReward.LoadRewardUnity(MainActivity.this,BACKUP_ADS,MAIN_ADS_REWARDS,BACKUP_ADS_REWARDS);
                break;

        }

    }

    public void munculiklan(View view){
        switch (SELECT_ADS) {
            case "ADMOB":
                IvanIntertitial.ShowIntertitialAdmob(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL,
                        HIGH_PAYING_KEYWORD1, HIGH_PAYING_KEYWORD2, HIGH_PAYING_KEYWORD3, HIGH_PAYING_KEYWORD4, HIGH_PAYING_KEYWORD5);
                break;
            case "APPLOVIN-D":
                IvanIntertitial.ShowIntertitialApplovinDis(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
            case "APPLOVIN-M":
                IvanIntertitial.ShowIntertitialApplovinMax(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
            case "IRON" :
                IvanIntertitial.ShowIntertitialIron(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
            case "MOPUB" :
                IvanIntertitial.ShowIntertitialMopub(MainActivity.this,BACKUP_ADS,MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
            case "STARTAPP" :
                IvanIntertitial.ShowIntertitialSartApp(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
            case "FACEBOOK" :
                IvanIntertitial.ShowIntertitialFAN(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);

                break;
            case "GOOGLE-ADS" :
                IvanIntertitial.ShowIntertitialGoogleAds(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
            case "UNITY" :
                IvanIntertitial.ShowIntertitialUnity(MainActivity.this, BACKUP_ADS, MAIN_ADS_INTERTITIAL, BACKUP_ADS_INTERTITIAL, INTERVAL);
                break;
        }


    }

    public void munculreward(View view){
        switch (SELECT_ADS) {
            case "ADMOB":
                IvanReward.ShowRewardAdmob(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;
            case "APPLOVIN-M":
                IvanReward.ShowRewardApplovinMax(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;
            case "MOPUB":
                IvanReward.ShowRewardMopub(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;
            case "GOOGLE-ADS":
                IvanReward.ShowRewardGoogleAds(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;
            case "UNITY":
                IvanReward.ShowRewardUnity(MainActivity.this, BACKUP_ADS, MAIN_ADS_REWARDS, BACKUP_ADS_REWARDS);
                break;


        }
    }

    public void onResume(){
        super.onResume();
        if (IvanReward.unlockreward){
            Toast.makeText(getApplicationContext(), "OK Berhasil", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
        super.onBackPressed();
    }
}