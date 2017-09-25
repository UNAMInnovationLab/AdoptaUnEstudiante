package com.lab.innovation.unam.adoptaunestudiante.Views.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.lab.innovation.unam.adoptaunestudiante.Interfaces.LogInPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.LogInView;
import com.lab.innovation.unam.adoptaunestudiante.Presenters.LogInPresenterImpl;
import com.lab.innovation.unam.adoptaunestudiante.R;

public class LogInActivity extends AppCompatActivity implements LogInView {

    private LogInPresenter presenter;
    private ProgressBar progressBar;
    private View v;
    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        presenter = new LogInPresenterImpl(this);
        progressBar = (ProgressBar) findViewById(R.id.log_in_progressbar);
        v = findViewById(R.id.log_in_layout);
        etEmail = (EditText) findViewById(R.id.log_in_et_email);
        etPassword = (EditText) findViewById(R.id.log_in_et_password);

        findViewById(R.id.log_in_btn_enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.verifyValidity(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String msj) {
        Snackbar snackbar = Snackbar.make(v, msj, Snackbar.LENGTH_SHORT);
        snackbar.getView().setBackgroundColor(Color.parseColor("#cc5959"));
        snackbar.show();
    }

    @Override
    public void showInformation(String msj) {
        Snackbar.make(v, msj, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError(int editText, String msj) {
        if (editText == EMAIL_ERROR) {
            etEmail.setError(msj);
            etEmail.requestFocus();
        } else if (editText == PASSWORD_ERROR){
            etPassword.setError(msj);
            etPassword.requestFocus();
        } else
            showError(msj);
    }

    @Override
    public void navigateToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
