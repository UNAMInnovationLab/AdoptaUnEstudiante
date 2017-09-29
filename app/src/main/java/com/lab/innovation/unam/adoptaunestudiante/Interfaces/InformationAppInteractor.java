package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

import android.content.Intent;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

public interface InformationAppInteractor {

    CallbackManager createCallbackManager();
    FacebookCallback<LoginResult> createFbCallback();
    void onActivityResultCallback(int requestCode, int resultCode, Intent data);
    void logInFirebase(AccessToken accessToken);
    void startListenerAuth();
    void stopListenerAuth();

}
