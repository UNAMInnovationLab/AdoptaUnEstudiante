package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

import com.lab.innovation.unam.adoptaunestudiante.Model.User;

public interface SignUpInteractor {

    int SOME_ERROR=-1;
    int INVALID_EMAIL_ERROR=0;
    int EMAIL_COLLISION_ERROR=1;
    int CONNECTION_ERROR=2;

    void signUpWithEmailAndPassword(String email, String password);
    void signUpToDatabaseUser(User user);

}
