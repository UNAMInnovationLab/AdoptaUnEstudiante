package com.lab.innovation.unam.adoptaunestudiante.Views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SplashScreenPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SplashScreenView;
import com.lab.innovation.unam.adoptaunestudiante.Presenters.SplashScreenPresenterImpl;
import com.lab.innovation.unam.adoptaunestudiante.R;

public class SplashScreenActivity extends AppCompatActivity implements SplashScreenView {

    private SplashScreenPresenter presenter;
    private final int TIME_TO_SHOW = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        presenter = new SplashScreenPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.didFinishLoading();
            }
        }, TIME_TO_SHOW);

    }

    @Override
    public void navigateToInformationActivity() {
        startActivity(new Intent(this, InformationAppActivity.class));
        finish();
    }

    @Override
    public void navigateToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
