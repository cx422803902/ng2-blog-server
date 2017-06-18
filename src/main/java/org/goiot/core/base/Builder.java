package org.goiot.core.base;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by chenxing on 2017/6/11.
 */
abstract public class Builder<T> {
    private T instance;

    public Builder() {
        final Class<?> clazz = this.getClass();
        final ParameterizedType genericSuperclass = (ParameterizedType) clazz.getGenericSuperclass();
        final Type genernicArgs0 = genericSuperclass.getActualTypeArguments()[0];
        if (genernicArgs0 instanceof Class) {
            Class<T> beanClass = (Class<T>) genernicArgs0;

            this.instance = (T) BeanUtils.instantiate(beanClass);
        } else if (genernicArgs0 instanceof ParameterizedType) {
            ParameterizedType typ2 = (ParameterizedType) genernicArgs0;
            final Type rawType = typ2.getRawType();
            Class<T> beanClass = (Class<T>) rawType;
            this.instance = (T) BeanUtils.instantiate(beanClass);
        } else {
            throw new UnsupportedOperationException("不支持的类型, genernicArgs0=" + genernicArgs0);
        }
    }

    public T build() {
        return this.instance;
    }

    public T getInstance() {
        return this.instance;
    }
}
