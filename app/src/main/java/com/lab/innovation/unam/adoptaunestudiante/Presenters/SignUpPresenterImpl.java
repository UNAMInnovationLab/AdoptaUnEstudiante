package com.lab.innovation.unam.adoptaunestudiante.Presenters;

import com.lab.innovation.unam.adoptaunestudiante.Interactors.SignUpInteractorImpl;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpInteractor;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpPresenter;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.SignUpView;
import com.lab.innovation.unam.adoptaunestudiante.Model.User;

public class SignUpPresenterImpl implements SignUpPresenter {

    private SignUpView view;
    private SignUpInteractor interactor;

    public SignUpPresenterImpl(SignUpView view){
        this.view = view;
        this.interactor = new SignUpInteractorImpl(this);
    }

    @Override
    public void verifyValidity(String email, String password, String confirmPassword) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            int error = email.isEmpty()?
                    view.EMAIL:
                    password.isEmpty()? view.PASSWORD: view.CONFIRM_PASSWORD;
            view.showInputError(error, "Favor de introducir todos los campos");
        } else if (password.contains(" "))
            view.showInputError(view.PASSWORD, "Tu contraseña no puede tener espacios en blanco");
        else if (password.length() < 6)
            view.showInputError(view.PASSWORD, "Tu contraseña debe tener al menos 6 caracteres");
        else if (!password.equals(confirmPassword))
            view.showInputError(view.CONFIRM_PASSWORD, "Las contraseñas no coinciden");
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
        if (error == interactor.INVALID_EMAIL_ERROR)
            view.showInputError(view.EMAIL, "Correo electrónico inválido");
        else if (error == interactor.EMAIL_COLLISION_ERROR)
            view.showInputError(view.EMAIL, "Éste correo ya ha sido registrado anteriormente");
        else if(error == interactor.CONNECTION_ERROR)
            view.showError("No hay conexión a internet");
        else
            view.showError("Ocurrió un error al intentar crear tu cuenta");

        view.hideProgressBar();
    }

}
