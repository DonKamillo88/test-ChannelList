package com.kkk.campusposts.ui.presenter;

import android.content.Context;

import com.kkk.campusposts.ui.activity.LoginView;


/**
 * Created by DonKamillo on 07.09.2016.
 */

public interface LoginPresenter {
    void attachView(Context context, LoginView loginView);

    void onStop();
}
