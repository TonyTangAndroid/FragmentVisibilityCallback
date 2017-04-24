package com.github.tonytanganadroid.precisefragment.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hugo.weaving.DebugLog;

public class SingleFragmentActivity extends AppCompatActivity {

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fl_frame_layout, PlaceholderFragment.newInstance(0)).commit();
        }
    }


}
