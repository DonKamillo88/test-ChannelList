package com.kkk.campusposts.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kkk.campusposts.R;
import com.kkk.campusposts.services.CampusSociety;
import com.kkk.campusposts.ui.presenter.LoginPresenterImpl;


public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText passwordET;
    private EditText emailET;
    private Button loginBtn;
    private LoginPresenterImpl loginPresenter;

    private CampusSociety campusSociety;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = (EditText) findViewById(R.id.email);
        passwordET = (EditText) findViewById(R.id.password);

        loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(this);

        initPresenter();
    }

    @Override
    public void onClick(View view) {
        loginPresenter.callForLogin(emailET.getText().toString(), passwordET.getText().toString());
    }

    private void initPresenter() {
        loginPresenter = new LoginPresenterImpl();
        loginPresenter.attachView(this, this);
    }

    private void openChannelsActivity(String token) {
        Intent intent = new Intent(this, ChannelsActivity.class);
        intent.putExtra(ChannelsActivity.TOKEN_ARG, "Token " + token);
        startActivity(intent);
    }

    @Override
    public void logIn(String token) {
        openChannelsActivity(token);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
