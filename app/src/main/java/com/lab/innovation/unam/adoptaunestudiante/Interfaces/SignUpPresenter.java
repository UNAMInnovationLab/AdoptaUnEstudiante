package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface SignUpPresenter {

    void verifyValidity(String name, String email, String password, String confirmPassword);
    void signUpSuccefully(String email);
    void catchDatabaseError(int error);

}
