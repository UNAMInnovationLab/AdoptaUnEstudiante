package com.lab.innovation.unam.adoptaunestudiante.Views.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpView;
import com.lab.innovation.unam.adoptaunestudiante.Presenters.SignUpPresenterImpl;
import com.lab.innovation.unam.adoptaunestudiante.R;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    private SignUpPresenter presenter;
    // Root Layout
    private View v;
    private ProgressBar progressBar;
    private TextInputEditText etEmail, etPassword, etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        presenter = new SignUpPresenterImpl(this);

        v = findViewById(R.id.sign_up_layout);
        progressBar = (ProgressBar) findViewById(R.id.sign_up_progressbar);
        etEmail = (TextInputEditText) findViewById(R.id.sign_up_tiet_email);
        etPassword = (TextInputEditText) findViewById(R.id.sign_up_tiet_password);
        etConfirmPassword = (TextInputEditText) findViewById(R.id.sign_up_tiet_confirm_password);

        findViewById(R.id.sign_up_btn_enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.verifyValidity(
                        etEmail.getText().toString(),
                        etPassword.getText().toString(),
                        etConfirmPassword.getText().toString());
            }
        });

    }

    @Override
    public void showError(String msj) {
        // Falta cambiar a color rojo
        Snackbar.make(v, msj, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showInformation(String msj) {
        Snackbar.make(v, msj, Snackbar.LENGTH_SHORT).show();
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
    public void navigateToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
