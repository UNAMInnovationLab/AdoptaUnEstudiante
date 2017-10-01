package com.lab.innovation.unam.adoptaunestudiante.Views.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainView;
import com.lab.innovation.unam.adoptaunestudiante.Model.Util;
import com.lab.innovation.unam.adoptaunestudiante.Presenters.MainPresenterImpl;
import com.lab.innovation.unam.adoptaunestudiante.R;
import com.lab.innovation.unam.adoptaunestudiante.Views.Fragments.StarsFragment;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenterImpl(this);
    }

    @Override
    public void setUserImage(String userImage) {
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.main_user_image);
        if (userImage.equals("default"))
            circleImageView.setImageResource(R.drawable.user_default);
        else
            Picasso.with(this).load(userImage).into(circleImageView);
    }

    @Override
    public void setUserName(String userName) {
        ((TextView) findViewById(R.id.main_user_name)).setText(userName);
    }

    @Override
    public void setUserCourse(String userCourse) {
        ((TextView) findViewById(R.id.main_user_course)).setText(userCourse);
    }

    @Override
    public void setStarsFragment(float ranking) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment_stars_place, StarsFragment.newInstance(ranking));
        transaction.commit();
    }

    @Override
    public void showProgressDialog(String title, String msj) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(title);
        progressDialog.setMessage(msj);
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }

    public void cerrar_sesion(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, InformationAppActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
