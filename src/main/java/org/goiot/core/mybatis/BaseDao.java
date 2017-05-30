package org.goiot.core.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.goiot.core.mybatis.provider.InsertBuilder;

/**
 * Created by chenxing on 2017/5/29.
 */
public interface BaseDao<T> {

    @InsertProvider(type = InsertBuilder.class, method = "buildInsertSql")
    Integer insert(T entity);

}
