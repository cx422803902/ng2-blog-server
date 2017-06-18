package org.goiot.core.mybatis;

/**
 * Created by chenxing on 2017/6/18.
 */
public interface ExtendMapper<T> extends tk.mybatis.mapper.common.Mapper<T>, ExtendSelectMapper<T>{
}
