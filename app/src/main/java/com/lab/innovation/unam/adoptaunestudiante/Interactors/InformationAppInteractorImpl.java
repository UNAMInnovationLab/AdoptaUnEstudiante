package com.lab.innovation.unam.adoptaunestudiante.Interactors;

import android.content.Intent;
import android.telecom.Call;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppPresenter;

public class InformationAppInteractorImpl implements InformationAppInteractor {

    private InformationAppPresenter presenter;
    private CallbackManager callbackManager;

    public InformationAppInteractorImpl(InformationAppPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public CallbackManager createCallbackManager() {
        callbackManager = CallbackManager.Factory.create();
        return callbackManager;
    }

    @Override
    public FacebookCallback<LoginResult> createFbCallback() {
        return new FbCallback();
    }

    @Override
    public void onActivityResultCallback(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public class FbCallback implements FacebookCallback<LoginResult> {

        @Override
        public void onSuccess(LoginResult loginResult) {
            presenter.onSuccessLoginFacebook();
        }

        @Override
        public void onCancel() {
            presenter.onCancellLoginFacebook();
        }

        @Override
        public void onError(FacebookException error) {
            presenter.onErrorLoginFacebook();
        }
    }
}
