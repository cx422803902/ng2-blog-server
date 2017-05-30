package org.goiot.controller.beans.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by chenxing on 2017/5/30.
 */
public class LoginRequest {
    @NotEmpty()
    private String userName;
    @NotEmpty
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
