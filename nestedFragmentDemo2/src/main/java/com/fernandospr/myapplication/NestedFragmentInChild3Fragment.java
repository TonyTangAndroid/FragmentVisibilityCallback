package com.fernandospr.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hugo.weaving.DebugLog;
@DebugLog
public class NestedFragmentInChild3Fragment extends Fragment {

    public NestedFragmentInChild3Fragment() {
        // Required empty public constructor
    }

    public static NestedFragmentInChild3Fragment newInstance() {
        return new NestedFragmentInChild3Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nested_child, container, false);
    }

    @DebugLog
    @Override
    public void onResume() {
        super.onResume();
    }

    @DebugLog
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
