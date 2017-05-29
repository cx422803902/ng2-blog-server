package org.goiot.mybatis;

import org.apache.ibatis.annotations.InsertProvider;

/**
 * Created by chenxing on 2017/5/29.
 */
public interface BaseDao<T> {

    @InsertProvider(type = org.goiot.mybatis.InsertProvider.class, method = "createInsertSql")
    Integer insert(T entity);
}
