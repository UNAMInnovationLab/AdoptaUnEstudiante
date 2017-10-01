package com.lab.innovation.unam.adoptaunestudiante.Presenters;

import android.support.v4.app.Fragment;

import com.lab.innovation.unam.adoptaunestudiante.Interactors.MainInteractorImpl;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainView;
import com.lab.innovation.unam.adoptaunestudiante.Views.Fragments.MainUserFragment;

public class MainPresenterImpl implements MainPresenter {

    private MainView view;
    private MainInteractor interactor;

    public MainPresenterImpl(MainView view){
        this.view = view;
        this.view.showProgressDialog("Cargando...", "Cargando información");
        interactor = new MainInteractorImpl(this);
    }

    @Override
    public void initializeViews() {
        view.setUserImage(interactor.getUserImageURL());
        view.setUserName(interactor.getUserName());
        view.setStarsFragment(interactor.getUserRanking());
        view.setUserCourse("Ciencias de la Computación");
        view.dismissProgressDialog();
    }

    @Override
    public void changeFragment(int idFragment) {
        Fragment fragment = null;
        if (idFragment == view.USER)
            fragment = MainUserFragment.getInstance();
        else
            fragment = MainUserFragment.getInstance();
        view.changeFragment(fragment);

    }


}
