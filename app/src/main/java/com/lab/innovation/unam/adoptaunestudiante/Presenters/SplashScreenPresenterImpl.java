package com.lab.innovation.unam.adoptaunestudiante.Presenters;

import com.lab.innovation.unam.adoptaunestudiante.Interactors.SplashScreenInteractorImpl;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SplashScreenInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SplashScreenPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SplashScreenView;

public class SplashScreenPresenterImpl implements SplashScreenPresenter {

    private SplashScreenView view;
    private SplashScreenInteractor interactor;

    public SplashScreenPresenterImpl(SplashScreenView view){
        this.view = view;
        this.interactor = new SplashScreenInteractorImpl();
    }

    @Override
    public void didFinishLoading() {
        if (interactor.isUserLogged())
            view.navigateToMainActivity();
        else
            view.navigateToInformationActivity();
    }

}
