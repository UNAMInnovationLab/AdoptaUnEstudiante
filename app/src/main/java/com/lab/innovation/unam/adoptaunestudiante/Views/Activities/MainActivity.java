package com.lab.innovation.unam.adoptaunestudiante.Views.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private MainPresenter presenter;
    private ProgressDialog progressDialog;

    private ImageView userOption, mapOption, publicationsOption, msjOption, forumOption, settingOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userOption = (ImageView) findViewById(R.id.main_user_option);
        mapOption = (ImageView) findViewById(R.id.main_map_option);
        publicationsOption = (ImageView) findViewById(R.id.main_publications_option);
        msjOption = (ImageView) findViewById(R.id.main_msj_option);
        forumOption = (ImageView) findViewById(R.id.main_forum_option);
        settingOption = (ImageView) findViewById(R.id.main_settings_option);

        userOption.setOnClickListener(this);
        mapOption.setOnClickListener(this);
        publicationsOption.setOnClickListener(this);
        msjOption.setOnClickListener(this);
        forumOption.setOnClickListener(this);
        settingOption.setOnClickListener(this);

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

    @Override
    public void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_fragment_application_place, fragment);
        transaction.commit();
    }

    // TODO
    public void cerrar_sesion(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, InformationAppActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_user_option:
                presenter.changeFragment(USER);
                break;
            case R.id.main_map_option:
                break;
            case R.id.main_publications_option:
                break;
            case R.id.main_msj_option:
                break;
            case R.id.main_forum_option:
                break;
            case R.id.main_settings_option:
                break;
        }
    }
}
