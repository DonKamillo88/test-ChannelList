package com.kkk.campusposts.services;

/**
 * Created by DonKamillo on 07.09.2016.
 */

public class LoginRequest {
    private String email;
    private String password;
    private String device;
    private String hash;

    public LoginRequest(String email, String password, String device, String hash) {
        this.email = email;
        this.password = password;
        this.device = device;
        this.hash = hash;
    }
}
