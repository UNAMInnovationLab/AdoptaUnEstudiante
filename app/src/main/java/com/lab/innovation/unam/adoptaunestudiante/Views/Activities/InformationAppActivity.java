package com.lab.innovation.unam.adoptaunestudiante.Views.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppView;
import com.lab.innovation.unam.adoptaunestudiante.Presenters.InformationAppPresenterImpl;
import com.lab.innovation.unam.adoptaunestudiante.R;
import com.lab.innovation.unam.adoptaunestudiante.Views.Adapters.FragmentPagerAdapterInformation;

public class InformationAppActivity extends AppCompatActivity
        implements InformationAppView, View.OnClickListener {

    private InformationAppPresenter presenter;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_app);

        presenter = new InformationAppPresenterImpl(this);

        layout = findViewById(R.id.information_app_layout);
        findViewById(R.id.information_app_btn_login).setOnClickListener(this);
        findViewById(R.id.information_app_btn_signup).setOnClickListener(this);
        presenter.registerCallback((LoginButton) findViewById(R.id.information_app_login_fb));

        ViewPager viewPager = (ViewPager) findViewById(R.id.information_app_view_pager);
        PagerAdapter adapter = new FragmentPagerAdapterInformation(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        ((TabLayout) findViewById(R.id.information_app_tab_layout)).setupWithViewPager(viewPager, true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResultCallback(requestCode, resultCode, data);
    }

    @Override
    public void navigateToSignUpActivity() {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    @Override
    public void navigateToLogInActivity() {
        startActivity(new Intent(this, LogInActivity.class));
    }

    @Override
    public void navigateToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void showInformation(String msj) {
        Snackbar.make(layout, msj, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msj) {
        Snackbar snackbar = Snackbar.make(layout, msj, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(Color.parseColor("#cc5959"));
        snackbar.show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.information_app_btn_login:
                navigateToLogInActivity();
                break;
            case R.id.information_app_btn_signup:
                navigateToSignUpActivity();
                break;
        }
    }

}
