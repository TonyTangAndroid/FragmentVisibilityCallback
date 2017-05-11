package com.github.tonytanganadroid.precisefragment.app.fragment.visibility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.tonytanganadroid.precisefragment.app.BadgeFragment;
import com.github.tonytanganadroid.precisefragment.app.R;

import hugo.weaving.DebugLog;

public class SingleFragmentActivity extends AppCompatActivity {

    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.fl_frame_layout, BadgeFragment.newInstance(0)).commit();
        }
    }


}
