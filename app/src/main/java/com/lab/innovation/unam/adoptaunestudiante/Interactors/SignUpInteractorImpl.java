package com.lab.innovation.unam.adoptaunestudiante.Interactors;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.FirebaseDatabase;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Model.User;
import com.lab.innovation.unam.adoptaunestudiante.Model.Util;

public class SignUpInteractorImpl implements SignUpInteractor {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private SignUpPresenter presenter;

    public SignUpInteractorImpl(SignUpPresenter presenter){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        this.presenter = presenter;
    }

    @Override
    public void signUpWithEmailAndPassword (final String email, final String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            presenter.signUpSuccefully(email);
                        }
                    });
                }else
                    if (!Util.isNetworkConnectionAvailable())
                        presenter.catchDatabaseError(CONNECTION_ERROR);
                    else {
                        String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();
                        if (errorCode.equals("ERROR_INVALID_EMAIL"))
                            // Correo mal escrito
                            presenter.catchDatabaseError(INVALID_EMAIL_ERROR);
                        else if(errorCode.equals("ERROR_EMAIL_ALREADY_IN_USE"))
                            // Correo ya ingresado
                            presenter.catchDatabaseError(EMAIL_COLLISION_ERROR);
                        else
                            // Cualquier otro error
                            presenter.catchDatabaseError(SOME_ERROR);
                    }

            }
        });
    }

    @Override
    public void signUpToDatabaseUser(User user) {
        firebaseDatabase.getReference().
                child("users").
                child(firebaseAuth.getCurrentUser().getUid())
                .setValue(user);
    }
}
