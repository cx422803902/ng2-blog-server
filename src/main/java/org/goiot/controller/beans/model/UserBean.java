package org.goiot.controller.beans.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.UserEntity;

/**
 * Created by chenxing on 2017/6/11.
 */
public class UserBean {
    private Long id;
    private String userName;
    private String nickName;
    private Boolean rememberMe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public static class UserBeanBuilder extends Builder<UserBean> {
        public UserBeanBuilder appendUserEntity(UserEntity userEntity) {
            UserBean userBean = super.getInstance();
            userBean.setId(userEntity.getId());
            userBean.setUserName(userEntity.getUserName());
            userBean.setNickName(userEntity.getNickName());
            userBean.setRememberMe(userEntity.getRememberMe());
            return this;
        }
    }
}
