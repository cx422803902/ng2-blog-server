package org.goiot.controller.beans.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by chenxing on 2017/5/30.
 */
public class LoginRequest {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
