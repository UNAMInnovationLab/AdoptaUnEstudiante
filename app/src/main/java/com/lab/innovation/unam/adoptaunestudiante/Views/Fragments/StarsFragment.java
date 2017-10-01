package com.lab.innovation.unam.adoptaunestudiante.Views.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lab.innovation.unam.adoptaunestudiante.Interfaces.StarsPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.StarsView;
import com.lab.innovation.unam.adoptaunestudiante.Model.User;
import com.lab.innovation.unam.adoptaunestudiante.Presenters.StarsPresenterImpl;
import com.lab.innovation.unam.adoptaunestudiante.R;
import com.squareup.picasso.Picasso;

public class StarsFragment extends Fragment implements StarsView {

    private StarsPresenter presenter;
    private ImageView one, two, three, four, five;
    private TextView tvRanking;

    public StarsFragment() {}

    public static StarsFragment newInstance(float ranking){
        StarsFragment fragment = new StarsFragment();
        fragment.presenter = new StarsPresenterImpl(fragment, ranking);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_stars, container, false);
        one = (ImageView) root.findViewById(R.id.fragment_stars_one);
        two = (ImageView) root.findViewById(R.id.fragment_stars_two);
        three = (ImageView) root.findViewById(R.id.fragment_stars_three);
        four = (ImageView) root.findViewById(R.id.fragment_stars_four);
        five = (ImageView) root.findViewById(R.id.fragment_stars_five);
        tvRanking = (TextView) root.findViewById(R.id.fragment_stars_number);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.workStars();
    }

    @Override
    public void workStar(String action, int starNumber) {
        int resource = action.equals(ACTION_CLEAR_STAR)? R.drawable.star_empty:
                        action.equals(ACTION_FILL_HALF_STAR)? R.drawable.star_half: R.drawable.star_full;

        ((starNumber == STAR_FIVE)? five:
                (starNumber == STAR_FOUR)? four:
                        (starNumber == STAR_TRHEE)? three:
                                (starNumber == STAR_TWO)? two: one).setImageResource(resource);
    }

    @Override
    public void setRanking(String ranking) {
        tvRanking.setText(ranking);
    }
}
