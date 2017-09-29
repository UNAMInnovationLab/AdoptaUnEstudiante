package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

import android.app.Activity;

public interface InformationAppView {

    void navigateToSignUpActivity();
    void navigateToLogInActivity();
    void navigateToMainActivity();
    void showInformation(String msj);
    void showError(String msj);
    Activity getActivity();

}
