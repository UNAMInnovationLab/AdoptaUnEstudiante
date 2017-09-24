package com.lab.innovation.unam.adoptaunestudiante.Interactors;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
                    else
                        try {
                            throw task.getException();
                        }catch (FirebaseAuthInvalidUserException e){
                            presenter.catchDatabaseError(EMAIL_NOT_REGISTER);
                        } catch (FirebaseAuthInvalidCredentialsException e) {
                            presenter.catchDatabaseError(INCORRECT_PASSWORD);
                        } catch (Exception e){
                            presenter.catchDatabaseError(SOME_ERROR);
                        }
            }
        });
    }
}
