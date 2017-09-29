package com.lab.innovation.unam.adoptaunestudiante.Interactors;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppPresenter;

public class InformationAppInteractorImpl implements InformationAppInteractor {

    private InformationAppPresenter presenter;
    private CallbackManager callbackManager;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private DatabaseReference databaseReference;
    private FirebaseAuth.AuthStateListener listener;

    public InformationAppInteractorImpl(final InformationAppPresenter presenter){
        this.presenter = presenter;
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null)
                    checkDatabase();
            }
        };
    }


    @Override
    public CallbackManager createCallbackManager() {
        callbackManager = CallbackManager.Factory.create();
        return callbackManager;
    }

    @Override
    public FacebookCallback<LoginResult> createFbCallback() {
        return new FbCallback();
    }

    @Override
    public void onActivityResultCallback(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void logInFirebase(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(presenter.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful())
                                presenter.onErrorLoginFacebook();
                    }
                });
    }

    private void checkDatabase(){
        firebaseUser = firebaseAuth.getCurrentUser();
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshotUsers) {
                // Si es la primera vez que inicia sesión con Fb introducimos sus datos a la Database
                if (!dataSnapshotUsers.hasChild(firebaseUser.getUid())){
                    databaseReference.child("users")
                            .child(firebaseUser.getUid())
                            .setValue(
                                    presenter.createUser(firebaseUser.getDisplayName(), firebaseUser.getEmail())
                            );
                }
                presenter.onSuccessLoginFacebook();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                presenter.onErrorLoginFacebook();
            }
        });
    }

    @Override
    public void startListenerAuth() {
        firebaseAuth.addAuthStateListener(listener);
    }

    @Override
    public void stopListenerAuth() {
        firebaseAuth.removeAuthStateListener(listener);
    }


    public class FbCallback implements FacebookCallback<LoginResult> {

        @Override
        public void onSuccess(LoginResult loginResult) {
            logInFirebase(loginResult.getAccessToken());
        }

        @Override
        public void onCancel() {
            presenter.onCancellLoginFacebook();
        }

        @Override
        public void onError(FacebookException error) {
            presenter.onErrorLoginFacebook();
        }
    }
}
