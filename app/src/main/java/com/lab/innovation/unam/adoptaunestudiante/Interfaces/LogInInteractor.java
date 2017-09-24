package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

import com.lab.innovation.unam.adoptaunestudiante.Model.User;

public interface LogInInteractor {

    int SOME_ERROR=0;
    int EMAIL_NOT_REGISTER=1;
    int INCORRECT_PASSWORD=2;
    int CONNECTION_ERROR=3;

    void logInWithEmailAndPassword(String email, String password);

}
