package com.lab.innovation.unam.adoptaunestudiante.Interactors;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.LogInInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.LogInPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Model.Util;

public class LogInInteractorImpl implements LogInInteractor {

    private LogInPresenter presenter;
    private FirebaseAuth firebaseAuth;

    public LogInInteractorImpl(LogInPresenter presenter){
        this.presenter = presenter;
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void logInWithEmailAndPassword(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                    presenter.logInSuccefully();
                else
                    if (!Util.isNetworkConnectionAvailable())
                        presenter.catchDatabaseError(CONNECTION_ERROR);
                    else {
                        String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                        if (errorCode.equals("ERROR_USER_NOT_FOUND"))
                            presenter.catchDatabaseError(EMAIL_NOT_REGISTER);
                        else if (errorCode.equals("ERROR_INVALID_EMAIL"))
                            presenter.catchDatabaseError(INVALID_EMAIL);
                        else if (errorCode.equals("ERROR_WRONG_PASSWORD"))
                            presenter.catchDatabaseError(INCORRECT_PASSWORD);
                        else
                            presenter.catchDatabaseError(SOME_ERROR);
                    }
            }
        });
    }
}
