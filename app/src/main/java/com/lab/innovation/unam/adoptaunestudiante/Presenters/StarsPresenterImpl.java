package com.lab.innovation.unam.adoptaunestudiante.Presenters;

import com.lab.innovation.unam.adoptaunestudiante.Interfaces.StarsPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.StarsView;

public class StarsPresenterImpl implements StarsPresenter {

    private StarsView view;
    private float ranking;

    public StarsPresenterImpl(StarsView view, float ranking) {
        this.view = view;
        this.ranking = ranking;
    }

    @Override
    public void workStars() {
        // Siempre tiene al menos una estrella de ranking
        view.workStar(view.ACTION_FILL_STAR, view.STAR_ONE);

        if (ranking >= 1.5f)
            view.workStar(view.ACTION_FILL_HALF_STAR, view.STAR_TWO);
        if (ranking >= 2.0f)
            view.workStar(view.ACTION_FILL_STAR, view.STAR_TWO);
        if (ranking >= 2.5f)
            view.workStar(view.ACTION_FILL_HALF_STAR, view.STAR_TRHEE);
        if (ranking >= 3.0f)
            view.workStar(view.ACTION_FILL_STAR, view.STAR_TRHEE);
        if (ranking >= 3.5f)
            view.workStar(view.ACTION_FILL_HALF_STAR, view.STAR_FOUR);
        if (ranking >= 4.0f)
            view.workStar(view.ACTION_FILL_STAR, view.STAR_FOUR);
        if (ranking >= 4.5f)
            view.workStar(view.ACTION_FILL_HALF_STAR, view.STAR_FIVE);
        if (ranking == 5.0f)
            view.workStar(view.ACTION_FILL_STAR, view.STAR_FIVE);

        view.setRanking(ranking+"");
    }
}
