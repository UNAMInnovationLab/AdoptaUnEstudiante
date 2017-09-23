package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface SignUpView {

    void showError(String msj);
    void showInformation(String msj);
    void showProgressBar();
    void hideProgressBar();
    void navigateToMainActivity();

}
