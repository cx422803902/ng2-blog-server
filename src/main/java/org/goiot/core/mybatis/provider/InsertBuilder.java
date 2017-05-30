package org.goiot.core.mybatis.provider;

import org.apache.ibatis.jdbc.SQL;
import org.goiot.core.mybatis.jpa.Column;
import org.goiot.core.mybatis.jpa.Table;
import org.springframework.util.Assert;

import java.lang.reflect.Field;

/**
 * Created by chenxing on 2017/5/29.
 */
public class InsertBuilder {

    public String buildInsertSql(Object entity) {
        Class<?> entityClass = entity.getClass();
        Table insertTable = entityClass.getAnnotation(Table.class);
        Assert.notNull(insertTable, "insert entity must annotation with @InsertTable");
        SQL sql = new SQL().INSERT_INTO(insertTable.name());
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            Column insertColumn = field.getAnnotation(Column.class);
            if(insertColumn == null) {
                continue;
            }
            sql.VALUES(insertColumn.name(), "#{"+field.getName()+"}");
        }
        return sql.toString();
    }
}
