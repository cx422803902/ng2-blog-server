package org.goiot.controller.beans.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by chenxing on 2017/5/30.
 */
public class LogoutRequest {
    @NotEmpty()
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
