package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface SignUpView {

    int NAME=0;
    int EMAIL=1;
    int PASSWORD=2;
    int CONFIRM_PASSWORD=3;

    void showError(String msj);
    void showInputError(int editText, String msj);
    void showInformation(String msj);
    void showProgressBar();
    void hideProgressBar();
    void navigateToMainActivity();
    void navigateToLogInActivity();

}
