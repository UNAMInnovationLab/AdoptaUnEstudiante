package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface LogInView {

    int EMAIL_ERROR = 0;
    int PASSWORD_ERROR = 1;

    void showProgressBar();
    void hideProgressBar();
    void showError(String msj);
    void showInformation(String msj);
    void showInputError(int editText, String msj);
    void navigateToMainActivity();
    void navigateToSignUpActivity();
}
