package com.lab.innovation.unam.adoptaunestudiante.Views.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.lab.innovation.unam.adoptaunestudiante.Interfaces.MainView;
import com.lab.innovation.unam.adoptaunestudiante.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setUserImage(String userImage) {
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.main_user_image);
        if (userImage.equals("default"))
            circleImageView.setImageResource(R.drawable.user_default);
        else
            circleImageView.setImageURI(Uri.parse(userImage));
    }

    @Override
    public void setUserName(String userName) {
        ((TextView) findViewById(R.id.main_user_name)).setText(userName);
    }

    @Override
    public void setUserCourse(String userCourse) {
        ((TextView) findViewById(R.id.main_user_course)).setText(userCourse);
    }

    public void cerrar_sesion(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, InformationAppActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
