package com.example.kunwars.newsheap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SplashActivity extends AppCompatActivity {

    @InjectView(R.id.textViewWelcome)
    TextView textViewWelcome;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.inject(this);

        preferences = getSharedPreferences(Util.PREFS_NAME,MODE_PRIVATE);

        if(preferences.contains(Util.KEY_FNAME)){
            handler.sendEmptyMessageDelayed(101, 2000);
            textViewWelcome.setText("Welcome, "+preferences.getString(Util.KEY_FNAME," "));
        }else{
            handler.sendEmptyMessageDelayed(102, 2000);
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 101){
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(SplashActivity.this,Register.class);
                startActivity(i);
                finish();
            }
        }
    };
}
