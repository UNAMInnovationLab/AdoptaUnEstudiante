package com.lab.innovation.unam.adoptaunestudiante.Views.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lab.innovation.unam.adoptaunestudiante.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class InformationAppImagesFragment extends Fragment {

    private int drawableId;
    private int stringId;

    public InformationAppImagesFragment() {}

    public static InformationAppImagesFragment getInstance(int drawableId, int stringId){
        InformationAppImagesFragment imagenesBienvenidaFragment = new InformationAppImagesFragment();
        imagenesBienvenidaFragment.drawableId = drawableId;
        imagenesBienvenidaFragment.stringId = stringId;
        return imagenesBienvenidaFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.adapter_information_app_images_fragment, container, false);
        ((CircleImageView) rootView.findViewById(R.id.adapter_information_app_images_circleimagen)).setImageResource(drawableId);
        ((TextView) rootView.findViewById(R.id.adapter_information_app_images_tv_information)).setText(getResources().getString(stringId));
        return rootView;
    }
}
