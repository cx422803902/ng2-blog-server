package org.goiot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.goiot.controller.beans.request.LoginRequest;
import org.goiot.controller.beans.request.LogoutRequest;
import org.goiot.controller.beans.response.LoginResponse;
import org.goiot.dao.UserDao;
import org.goiot.entity.UserEntity;
import org.goiot.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by chenxing on 2017/5/30.
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody @Valid LoginRequest request) {
        UserEntity userEntity = userDao.selectByUserName(request.getUserName());
        Assert.notNull(userEntity, String.format("user [%s] is not exist", request.getUserName()));
        Assert.isTrue(userEntity.getPassword().equals(request.getPassword()), "password is wrong!");

        AuthenticationToken authenticationToken = new UsernamePasswordToken(userEntity.getUserName(), userEntity.getPassword().toCharArray(), userEntity.getRememberMe());
        Subject subject = SecurityUtils.getSubject();
        subject.login(authenticationToken);
        LoginResponse response = new LoginResponse();
        response.setId(userEntity.getId());
        response.setUserName(userEntity.getUserName());
        response.setNickName(userEntity.getNickName());
        response.setRememberMe(userEntity.getRememberMe());
        return JSONUtils.toJSONResponse(response);
    }

    @ResponseBody
    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    public String logout(@RequestBody LogoutRequest request) {
        UserEntity userEntity = userDao.selectByUserName(request.getUserName());
        Assert.notNull(userEntity, String.format("user [%s] is not exist", request.getUserName()));
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return JSONUtils.toJSONResponse(true);
    }

}
