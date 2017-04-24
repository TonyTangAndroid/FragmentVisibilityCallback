package com.github.tonytanganadroid.precisefragment.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.tonytanganadroid.precisefragment.SupportPreciseFragment;

import hugo.weaving.DebugLog;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends SupportPreciseFragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private int sectionNumber;


    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        Log.d("onResume", "sectionNumber:" + sectionNumber);
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("onPause", "sectionNumber:" + sectionNumber);
        super.onPause();
    }

    @DebugLog
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
    }

    @DebugLog
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getString(R.string.section_format, sectionNumber));
        return rootView;
    }

    @DebugLog
    @Override
    public void onFragmentVisible(boolean triggeredByOnResume) {
        Log.d("onFragmentVisibility", "visible section number :" + sectionNumber + ", triggeredByOnResume:" + triggeredByOnResume);
    }

    @DebugLog
    @Override
    public void onFragmentInvisible(boolean triggeredByOnPause) {
        Log.d("onFragmentVisibility", "invisible section number :" + sectionNumber + ", triggeredByOnPause:" + triggeredByOnPause);
    }
}
