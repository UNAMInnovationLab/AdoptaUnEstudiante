package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

public interface MainView {

    void setUserImage(String userImage);
    void setUserName(String userName);
    void setUserCourse(String userCourse);
    void setStarsFragment(float ranking);
    void showProgressDialog(String title, String msj);
    void dismissProgressDialog();


}
