package com.lab.innovation.unam.adoptaunestudiante.Interfaces;

import android.support.v4.app.Fragment;

public interface MainView {

    // Options
    int USER = 0;
    int MAP = 1;
    int MSJ = 2;
    int PUBLICATIONS = 3;
    int FORUM = 4;
    int SETTINGS = 5;

    void setUserImage(String userImage);
    void setUserName(String userName);
    void setUserCourse(String userCourse);
    void setStarsFragment(float ranking);
    void showProgressDialog(String title, String msj);
    void dismissProgressDialog();

    void changeFragment(Fragment fragment);

}
