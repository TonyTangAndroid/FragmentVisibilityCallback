package com.github.tonytanganadroid.precisefragment.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.tonytanganadroid.precise.fragment.callback.PreciseFragmentDelegate;

import hugo.weaving.DebugLog;

/**
 * A placeholder fragment containing a simple view.
 */
public class BadgeFragment extends Fragment implements PreciseFragmentDelegate.PreciseFragmentDelegateCallback {


    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    PreciseFragmentDelegate preciseFragmentDelegate = null;
    private int sectionNumber;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BadgeFragment newInstance(int sectionNumber) {
        BadgeFragment fragment = new BadgeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ensurePreciseFragmentDelegate();
    }


    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            ensurePreciseFragmentDelegate();
        }
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
        ensurePreciseFragmentDelegate();
        preciseFragmentDelegate.setUserVisibleHint(isVisibleToUser);

    }

    private void ensurePreciseFragmentDelegate() {
        if (preciseFragmentDelegate == null) {
            preciseFragmentDelegate = new PreciseFragmentDelegate(this);
        }
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
