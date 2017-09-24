package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface LogInPresenter {

    void verifyValidity(String email, String password);
    void logInSuccefully();
    void catchDatabaseError(int error);

}
