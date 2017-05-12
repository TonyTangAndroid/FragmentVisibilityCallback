package com.github.tonytanganadroid.precisefragment.app.fragment.visibility;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.github.tonytanganadroid.precisefragment.app.R;
import com.github.tonytanganadroid.precisefragment.app.SectionsPagerAdapter;

import hugo.weaving.DebugLog;

public class ViewPagerActivity extends AppCompatActivity {

    //@DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);
//        viewPager.setOffscreenPageLimit(SectionsPagerAdapter.COUNT - 1);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
