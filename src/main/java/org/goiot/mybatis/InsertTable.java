package org.goiot.mybatis;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chenxing on 2017/5/29.
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface InsertTable {
    /**
     * table's name
     * @return
     */
    String name();
}
