package org.goiot.controller;

import org.goiot.controller.beans.model.UserBean;
import org.goiot.controller.beans.request.LoginRequest;
import org.goiot.controller.beans.request.LogoutRequest;
import org.goiot.mapper.UserMapper;
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
    private UserMapper userDao;

    @ResponseBody
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody @Valid LoginRequest request) {
        UserEntity userEntity = userDao.selectByUserName(request.getUserName());
        Assert.notNull(userEntity, String.format("user [%s] is not exist", request.getUserName()));
        Assert.isTrue(userEntity.getPassword().equals(request.getPassword()), "password is wrong!");
        UserBean userBean = new UserBean.UserBeanBuilder()
                .appendUserEntity(userEntity)
                .build();
        return JSONUtils.toJSONResponse(userBean);
    }

    @ResponseBody
    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    public String logout(@RequestBody LogoutRequest request) {
        UserEntity userEntity = userDao.selectByUserName(request.getUserName());
        Assert.notNull(userEntity, String.format("user [%s] is not exist", request.getUserName()));
        return JSONUtils.toJSONResponse(true);
    }

}
