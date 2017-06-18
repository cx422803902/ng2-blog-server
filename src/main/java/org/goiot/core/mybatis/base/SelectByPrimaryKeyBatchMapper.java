package org.goiot.core.mybatis.base;

import org.apache.ibatis.annotations.SelectProvider;
import org.goiot.core.mybatis.provider.ExtendSelectProvider;

import java.util.List;

/**
 * Created by chenxing on 2017/6/18.
 */
public interface SelectByPrimaryKeyBatchMapper<T> {

    @SelectProvider(type = ExtendSelectProvider.class, method = "dynamicSQL")
    List<T> selectByPrimaryKeyBatch(Object[] keys);
}
