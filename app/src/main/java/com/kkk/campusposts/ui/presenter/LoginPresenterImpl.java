package com.kkk.campusposts.ui.presenter;

import android.content.Context;

import com.kkk.campusposts.services.CampusSociety;
import com.kkk.campusposts.services.CampusSocietyService;
import com.kkk.campusposts.services.LoginRequest;
import com.kkk.campusposts.services.LoginResponse;
import com.kkk.campusposts.ui.activity.LoginView;
import com.kkk.campusposts.utils.APIError;
import com.kkk.campusposts.utils.ErrorUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public class LoginPresenterImpl implements LoginPresenter, Callback<LoginResponse> {
    public static final String DEVICE = "Android";
    public static final String HASH = "123";

    private Call<LoginResponse> call;
    private CampusSociety campusSociety;
    private LoginView loginView;

    public void callForLogin(String email, String password) {
        call = getCampusSociety().login(new LoginRequest(email, password, DEVICE, HASH));
        call.enqueue(this);
    }

    @Override
    public void attachView(Context context, LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onStop() {
        if (call != null)
            call.cancel();
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if (response.isSuccessful()) {
            loginView.logIn(response.body().getToken());
        } else {
            APIError error = ErrorUtils.parseError(response);
            String errorMessage = error.getMessage();
            if (error.getErrors() != null && error.getErrors().size() > 0 && error.getErrors().get(0) != null)
                errorMessage = error.getErrors().get(0).getMessage();
            loginView.showError(errorMessage);
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        loginView.showError(t.getMessage());
    }

    private CampusSociety getCampusSociety() {
        if (campusSociety == null)
            campusSociety = CampusSocietyService.getService();
        return campusSociety;
    }
}
