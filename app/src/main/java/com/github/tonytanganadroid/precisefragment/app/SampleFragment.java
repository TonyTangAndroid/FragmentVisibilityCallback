package com.github.tonytanganadroid.precisefragment.app;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.tonytanganadroid.precisefragment.PreciseFragmentDelegate;

import hugo.weaving.DebugLog;

/**
 * A placeholder fragment containing a simple view.
 */
public class SampleFragment extends Fragment implements PreciseFragmentDelegate.PreciseFragmentDelegateCallback {


    PreciseFragmentDelegate preciseFragmentDelegate = new PreciseFragmentDelegate(this);
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
    public static SampleFragment newInstance(int sectionNumber) {
        SampleFragment fragment = new SampleFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        preciseFragmentDelegate.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        preciseFragmentDelegate.onPause();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        preciseFragmentDelegate.setUserVisibleHint(isVisibleToUser);
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
