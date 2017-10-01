package com.lab.innovation.unam.adoptaunestudiante.Views.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lab.innovation.unam.adoptaunestudiante.R;

public class MainUserFragment extends Fragment {

    private static MainUserFragment instance;

    public MainUserFragment() {}

    public static MainUserFragment getInstance(){
        return instance == null? new MainUserFragment(): instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_user, container, false);
    }

}
