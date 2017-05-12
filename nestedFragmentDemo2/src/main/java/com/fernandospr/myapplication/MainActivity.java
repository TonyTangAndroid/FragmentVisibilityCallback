package com.fernandospr.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import hugo.weaving.DebugLog;

public class MainActivity extends AppCompatActivity {

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.container, ParentFragment.newInstance());

            fragmentTransaction.commit();
        }
    }

    @DebugLog
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
