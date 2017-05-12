package com.github.tonytanganadroid.precisefragment.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.tonytanganadroid.precise.fragment.callback.PreciseFragmentDelegate;

import hugo.weaving.DebugLog;

/**
 * A placeholder fragment containing a simple view.
 */
public class UsherCodeFragment extends Fragment implements PreciseFragmentDelegate.PreciseFragmentDelegateCallback {


    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_BADGE_ID = "badge_id";
    PreciseFragmentDelegate preciseFragmentDelegate = null;
    private int badgeId;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static UsherCodeFragment newInstance(int sectionNumber) {
        UsherCodeFragment fragment = new UsherCodeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_BADGE_ID, sectionNumber);
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
        badgeId = getArguments().getInt(ARG_BADGE_ID);
    }

    @DebugLog
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_usher_code, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.tv_usher_code);
        textView.setText(getString(R.string.usher_code_for_badge, badgeId));
        return rootView;
    }


    @DebugLog
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @DebugLog
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @DebugLog
    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    //@DebugLog
    @Override
    public void onFragmentVisible(boolean triggeredByOnResume) {
//        Log.d("onFragmentVisibility", "visible badge id :" + badgeId + ", triggeredByOnResume:" + triggeredByOnResume);
    }

    //@DebugLog
    @Override
    public void onFragmentInvisible(boolean triggeredByOnPause) {
//        Log.d("onFragmentVisibility", "invisible badge id:" + badgeId + ", triggeredByOnPause:" + triggeredByOnPause);
    }
}
