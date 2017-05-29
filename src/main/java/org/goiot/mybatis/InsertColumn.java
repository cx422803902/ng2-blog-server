package org.goiot.mybatis;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chenxing on 2017/5/29.
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface InsertColumn {
    /**column name that be set when insert*/
    String name();

}
