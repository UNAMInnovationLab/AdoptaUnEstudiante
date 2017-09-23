package com.lab.innovation.unam.adoptaunestudiante.Presenters;

import com.lab.innovation.unam.adoptaunestudiante.Interactors.SignUpInteractorImpl;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpView;
import com.lab.innovation.unam.adoptaunestudiante.Model.User;

public class SignUpPresenterImpl implements SignUpPresenter {

    private SignUpView view;
    private SignUpInteractor interactor;
    private final int SOME_ERROR=-1, INVALID_EMAIL_ERROR=0, EMAIL_COLLISION_ERROR=1, CONNECTION_ERROR=2;

    public SignUpPresenterImpl(SignUpView view){
        this.view = view;
        this.interactor = new SignUpInteractorImpl(this);
    }

    @Override
    public void verifyValidity(String email, String password, String confirmPassword) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty())
            view.showError("Favor de introducir todos los campos");
        else if (password.contains(" "))
            view.showError("Tu contraseña no puede tener espacios en blanco");
        else if (password.length() < 6)
            view.showError("Tu contraseña debe tener al menos 6 caracteres");
        else if (!password.equals(confirmPassword))
            view.showError("Las contraseñas no coinciden");
        else{
            view.showProgressBar();
            interactor.signUpWithEmailAndPassword(email, password);
        }
    }

    @Override
    public void signUpSuccefully(String email) {
        User user = new User("", email);
        interactor.signUpToDatabaseUser(user);
        view.hideProgressBar();
        view.showInformation("Cuenta creada exitosamente");
        view.navigateToMainActivity();
    }

    @Override
    public void catchDatabaseError(int error) {
        switch (error){
            case SOME_ERROR:
                view.showError("Ocurrió un error al intentar crear tu cuenta");
                break;
            case INVALID_EMAIL_ERROR:
                view.showError("Correo electrónico inválido");
                break;
            case EMAIL_COLLISION_ERROR:
                view.showError("Éste correo ya ha sido registrado anteriormente");
                break;
            case CONNECTION_ERROR:
                view.showError("No hay conexión a internet");
                break;
        }
        view.hideProgressBar();
    }

}
