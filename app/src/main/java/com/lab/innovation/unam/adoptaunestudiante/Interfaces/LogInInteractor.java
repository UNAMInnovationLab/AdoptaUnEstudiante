package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface LogInInteractor {

    int SOME_ERROR=0;
    int EMAIL_NOT_REGISTER=1;
    int INCORRECT_PASSWORD=2;
    int CONNECTION_ERROR=3;
    int INVALID_EMAIL=4;

    void logInWithEmailAndPassword(String email, String password);

}
