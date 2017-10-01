package com.lab.innovation.unam.adoptaunestudiante.Presenters;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.facebook.login.widget.LoginButton;
import com.lab.innovation.unam.adoptaunestudiante.Interactors.InformationAppInteractorImpl;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppView;
import com.lab.innovation.unam.adoptaunestudiante.Model.User;

import java.util.Arrays;

public class InformationAppPresenterImpl implements InformationAppPresenter {

    private InformationAppView view;
    private InformationAppInteractor interactor;

    public InformationAppPresenterImpl(InformationAppView view){
        this.view = view;
        this.interactor = new InformationAppInteractorImpl(this);
    }

    @Override
    public void registerCallback(LoginButton loginButton) {
        loginButton.setReadPermissions(Arrays.asList("email"));
        loginButton.registerCallback(interactor.createCallbackManager(), interactor.createFbCallback());
    }

    @Override
    public Activity getActivity() {
        return view.getActivity();
    }

    @Override
    public void onActivityResultCallback(int requestCode, int resultCode, Intent data) {
        interactor.onActivityResultCallback(requestCode, resultCode, data);
    }

    @Override
    public void onSuccessLoginFacebook() {
        view.navigateToMainActivity();
    }

    @Override
    public void onCancellLoginFacebook() {
        view.showInformation("Cancelado el inicio de sesión con Facebook");
    }

    @Override
    public void onErrorLoginFacebook() {
        view.showError("Error al intenter iniciar sesión con Facebook");
    }

    @Override
    public void startListenerAuth() {
        interactor.startListenerAuth();
    }

    @Override
    public void stopListenerAuth() {
        interactor.stopListenerAuth();
    }


    @Override
    public User createUser(String name, String email, String imageURL, float ranking) {
        return new User(name, email, imageURL, ranking);
    }

}
