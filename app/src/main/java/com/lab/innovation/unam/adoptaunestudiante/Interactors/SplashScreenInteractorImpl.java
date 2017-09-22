package com.lab.innovation.unam.adoptaunestudiante.Interactors;

import com.google.firebase.auth.FirebaseAuth;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SplashScreenInteractor;

public class SplashScreenInteractorImpl implements SplashScreenInteractor {

    @Override
    public boolean isUserLogged() {
        return FirebaseAuth.getInstance().getCurrentUser() != null;
    }
}
