package com.lab.innovation.unam.adoptaunestudiante.Presenters;

import com.lab.innovation.unam.adoptaunestudiante.Interactors.LogInInteractorImpl;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.LogInInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.LogInPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.LogInView;

public class LogInPresenterImpl implements LogInPresenter {

    private LogInView view;
    private LogInInteractor interactor;

    public LogInPresenterImpl(LogInView view){
        this.view = view;
        interactor = new LogInInteractorImpl(this);
    }

    @Override
    public void verifyValidity(String email, String password) {
        if (email.isEmpty() || password.isEmpty())
            view.showInputError(
                    email.isEmpty()? view.EMAIL_ERROR: view.PASSWORD_ERROR,
                    "Favor de introducir todos los campos");
        else {
            view.showProgressBar();
            interactor.logInWithEmailAndPassword(email, password);
        }
    }

    @Override
    public void logInSuccefully() {
        view.hideProgressBar();
        view.showInformation("Se inició sesión exitosamente");
        view.navigateToMainActivity();
    }

    @Override
    public void catchDatabaseError(int error) {
        view.hideProgressBar();
        if (error == interactor.CONNECTION_ERROR)
            view.showError("No hay conexión a internet");
        else if (error == interactor.INCORRECT_PASSWORD)
            view.showInputError(view.PASSWORD_ERROR, "Contraseña incorrecta");
        else if (error == interactor.EMAIL_NOT_REGISTER)
            view.showInputError(view.EMAIL_ERROR, "Éste correo electrónico no ha sido registrado");
        else
            view.showError("Ocurrió un error al intentar iniciar sesión");
    }
}
