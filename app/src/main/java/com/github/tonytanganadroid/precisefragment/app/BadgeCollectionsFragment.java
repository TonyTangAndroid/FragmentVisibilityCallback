package com.github.tonytanganadroid.precisefragment.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//@DebugLog
public class BadgeCollectionsFragment extends Fragment {


    public static BadgeCollectionsFragment newInstance() {

        return new BadgeCollectionsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.container);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    //@DebugLog
    @Override
    public void onResume() {
        super.onResume();
    }

    //@DebugLog
    @Override
    public void onPause() {
        super.onPause();
    }

    //@DebugLog
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //@DebugLog
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //@DebugLog
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
