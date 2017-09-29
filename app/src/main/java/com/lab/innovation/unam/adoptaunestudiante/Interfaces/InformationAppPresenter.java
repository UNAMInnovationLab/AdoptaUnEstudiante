package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

import android.content.Intent;

import com.facebook.login.widget.LoginButton;

public interface InformationAppPresenter {

    void registerCallback(LoginButton loginButton);
    void onSuccessLoginFacebook();
    void onCancellLoginFacebook();
    void onErrorLoginFacebook();
    void onActivityResultCallback(int requestCode, int resultCode, Intent data);

}
