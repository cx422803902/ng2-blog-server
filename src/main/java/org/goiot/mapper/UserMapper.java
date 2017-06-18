package org.goiot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.goiot.core.mybatis.ExtendMapper;
import org.goiot.entity.UserEntity;

/**
 * Created by chenxing on 2017/5/29.
 */
public interface UserMapper extends ExtendMapper<UserEntity> {

    @Select("select * from User where UserName=#{userName}")
    UserEntity selectByUserName(@Param("userName") String userName);
}
