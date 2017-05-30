package org.goiot.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.goiot.mybatis.provider.InsertBuilder;

import java.io.Serializable;

/**
 * Created by chenxing on 2017/5/29.
 */
public interface BaseDao<T> {

    @InsertProvider(type = InsertBuilder.class, method = "buildInsertSql")
    Integer insert(T entity);

}
