package org.goiot.mybatis;

import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxing on 2017/5/29.
 */
public class InsertProvider {

    public String createInsertSql(Object entity) {
        Class<?> entityClass = entity.getClass();
        InsertTable insertTable = entityClass.getAnnotation(InsertTable.class);
        Assert.notNull(insertTable, "insert entity must annotation with @InsertTable");

        Field[] fields = entityClass.getDeclaredFields();
        List<String> columnNames = new ArrayList<String>(fields.length);
        List<String> fieldNames = new ArrayList<String>(fields.length);
        for (Field field : fields) {
            InsertColumn insertColumn = field.getAnnotation(InsertColumn.class);
            if(insertColumn == null) {
                continue;
            }
            columnNames.add(insertColumn.name());
            fieldNames.add(field.getName());
        }
        StringBuilder sql = new StringBuilder()
                .append("insert into ").append(insertTable.name()).append("(");
        columnNames.forEach(columnName -> sql.append(columnName));
        sql.append(") VALUES(");
        fieldNames.forEach(fieldName ->
                sql.append("#{")
                        .append(fieldName)
                        .append("}")
        );
        sql.append(")");
        return sql.toString();
    }
}
