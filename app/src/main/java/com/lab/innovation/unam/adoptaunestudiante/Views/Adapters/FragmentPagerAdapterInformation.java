package com.lab.innovation.unam.adoptaunestudiante.Views.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.lab.innovation.unam.adoptaunestudiante.R;
import com.lab.innovation.unam.adoptaunestudiante.Views.Fragments.InformationAppImagesFragment;

public class FragmentPagerAdapterInformation extends FragmentPagerAdapter {

    public FragmentPagerAdapterInformation(FragmentManager fg){
        super(fg);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return InformationAppImagesFragment.getInstance(R.drawable.grupo_de_estudio, R.string.grupo_de_estudio);
            case 1:
                return InformationAppImagesFragment.getInstance(R.drawable.apuntes, R.string.apuntes);
            case 2:
                return InformationAppImagesFragment.getInstance(R.drawable.preguntas_en_grupo, R.string.preguntas_en_grupo);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
