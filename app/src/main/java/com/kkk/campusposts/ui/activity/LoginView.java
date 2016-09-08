package com.kkk.campusposts.ui.activity;

/**
 * Created by DonKamillo on 08.09.2016.
 */

public interface LoginView {
    void logIn(String token);

    void showError(String errorMessage);
}
