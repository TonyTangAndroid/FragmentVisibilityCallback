package com.fernandospr.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hugo.weaving.DebugLog;

public class Child3Fragment extends Fragment {

    public Child3Fragment() {
        // Required empty public constructor
    }

    public static Child3Fragment newInstance() {
        return new Child3Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child3, container, false);
    }

    @DebugLog
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {
            Fragment videoFragment = NestedFragmentInChild3Fragment.newInstance();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.nest_fragment, videoFragment).commit();
        }


    }
}
