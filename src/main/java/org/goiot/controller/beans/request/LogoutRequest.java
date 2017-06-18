package org.goiot.controller.beans.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by chenxing on 2017/5/30.
 */
public class LogoutRequest {
    @NotBlank
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
