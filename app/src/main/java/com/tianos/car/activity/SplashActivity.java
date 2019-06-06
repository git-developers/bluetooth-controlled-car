package com.tianos.car.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.tianos.car.R;

import utils.Constant;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(Constant.SPLASH_TIME);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    Intent i = new Intent(SplashActivity.this, BluetoothActivity.class);
                    //i.putExtra(Constant.USER, user);
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
