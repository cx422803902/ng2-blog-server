package org.goiot.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.goiot.mybatis.provider.InsertBuilder;

/**
 * Created by chenxing on 2017/5/29.
 * auto generator and return id
 */
public interface IDAutoDao<T> extends BaseDao<T> {

    @InsertProvider(type = InsertBuilder.class, method = "buildInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "ID", keyProperty = "id")
    Integer insert(T entity);
}
