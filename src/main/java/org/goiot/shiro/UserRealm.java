package org.goiot.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.goiot.dao.UserDao;
import org.goiot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenxing on 2017/5/30.
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String)principals.getPrimaryPrincipal();
        UserEntity userEntity = userDao.selectByUserName(userName);
        if(userEntity == null) {
            return null;
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if(userEntity.getRole() != null) {
            authorizationInfo.addRole(userEntity.getRole().name());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        AuthenticationInfo authenticationInfo = null;
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        String userName = passwordToken.getUsername();
        UserEntity userEntity = userDao.selectByUserName(userName);
        if(userEntity != null) {
            authenticationInfo = new SimpleAuthenticationInfo(userEntity.getUserName(), userEntity.getPassword().toCharArray(), getName());
        }
        return authenticationInfo;
    }
}
