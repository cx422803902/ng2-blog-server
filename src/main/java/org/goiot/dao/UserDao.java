package org.goiot.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.goiot.entity.UserEntity;
import org.goiot.core.mybatis.IDAutoDao;

/**
 * Created by chenxing on 2017/5/29.
 */
public interface UserDao extends IDAutoDao<UserEntity>{
    @Select("select * from User where ID=#{id}")
    UserEntity selectById(@Param("id") Long id);

    @Select("select * from User where UserName=#{userName}")
    UserEntity selectByUserName(@Param("userName") String userName);
}
