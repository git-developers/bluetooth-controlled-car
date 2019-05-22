package com.tianos.car.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.tianos.car.R;

public class BaseActivity extends AppCompatActivity {

    //Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);

        /*
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_dehaze_black_24dp);
        setSupportActionBar(toolbar);
        */
    }

    /*
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        View content = getLayoutInflater().inflate(layoutResID, null);
        ((FrameLayout)findViewById(R.id.content_layout)).addView(content);
    }
    */

}
