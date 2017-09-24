package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface SignUpView {

    int EMAIL=0;
    int PASSWORD=1;
    int CONFIRM_PASSWORD=2;

    void showError(String msj);
    void showInputError(int editText, String msj);
    void showInformation(String msj);
    void showProgressBar();
    void hideProgressBar();
    void navigateToMainActivity();

}
