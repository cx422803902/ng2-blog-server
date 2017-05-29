package org.goiot.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

/**
 * Created by chenxing on 2017/5/29.
 * auto generator and return id
 */
public interface IDAutoDao<T> extends BaseDao<T> {

    @InsertProvider(type = org.goiot.mybatis.InsertProvider.class, method = "createInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "ID", keyProperty = "id")
    Integer insert(T entity);
}
