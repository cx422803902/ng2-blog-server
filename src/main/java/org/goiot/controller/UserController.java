package org.goiot.controller;

import com.alibaba.fastjson.JSON;
import org.goiot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenxing on 2017/5/30.
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @ResponseBody
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, Object> param) {
        Map<String, Object> response = new HashMap();
        Map<String, Object> user = new HashMap<>();
        user.put("id", 1);
        user.put("userName", "goiot");
        user.put("nickName", "chenxing");
        user.put("rememberMe", true);
        response.put("data", user);
        return JSON.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    public String logout(@RequestBody String body) {
        Map<String, Object> response = new HashMap();
        response.put("data", true);
        return JSON.toJSONString(response);
    }

}
