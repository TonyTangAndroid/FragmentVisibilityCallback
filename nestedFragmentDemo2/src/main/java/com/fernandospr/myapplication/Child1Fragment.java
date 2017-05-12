package com.fernandospr.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Child1Fragment extends Fragment {

    public Child1Fragment() {
        // Required empty public constructor
    }

    public static Child1Fragment newInstance() {
        return new Child1Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child1, container, false);
    }

}
