package com.lab.innovation.unam.adoptaunestudiante.Interactors;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Model.User;

public class MainInteractorImpl implements MainInteractor {

    private MainPresenter presenter;
    private User user;

    public MainInteractorImpl(MainPresenter presenter){
        this.presenter = presenter;
        initializeUser();
    }

    @Override
    public void initializeUser() {
        FirebaseDatabase.getInstance().getReference().child("users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshotUser) {
                user = dataSnapshotUser.getValue(User.class);
                presenter.initializeViews();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }

    @Override
    public String getUserImageURL() {
        return user.getImageURL();
    }

    @Override
    public String getUserName() {
        return user.getName();
    }

    @Override
    public String getUserEmail() {
        return user.getEmail();
    }

    @Override
    public float getUserRanking() {
        return user.getRanking();
    }
}
