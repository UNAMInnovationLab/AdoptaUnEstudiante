package com.lab.innovation.unam.adoptaunestudiante.Views.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lab.innovation.unam.adoptaunestudiante.Interfaces.InformationAppView;
import com.lab.innovation.unam.adoptaunestudiante.R;
import com.lab.innovation.unam.adoptaunestudiante.Views.Adapters.FragmentPagerAdapterInformation;

public class InformationAppActivity extends AppCompatActivity
        implements InformationAppView, View.OnClickListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_app);

        findViewById(R.id.information_app_btn_login).setOnClickListener(this);
        findViewById(R.id.information_app_btn_signup).setOnClickListener(this);

        viewPager = (ViewPager) findViewById(R.id.information_app_view_pager);
        PagerAdapter adapter = new FragmentPagerAdapterInformation(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        ((TabLayout) findViewById(R.id.information_app_tab_layout)).setupWithViewPager(viewPager, true);
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
