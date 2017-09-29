package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.facebook.login.widget.LoginButton;
import com.lab.innovation.unam.adoptaunestudiante.Model.User;

public interface InformationAppPresenter {

    void registerCallback(LoginButton loginButton);
    void onSuccessLoginFacebook();
    void onCancellLoginFacebook();
    void onErrorLoginFacebook();
    void startListenerAuth();
    void stopListenerAuth();
    Activity getActivity();
    User createUser(String name, String email, String imageURL);
    void onActivityResultCallback(int requestCode, int resultCode, Intent data);

}
