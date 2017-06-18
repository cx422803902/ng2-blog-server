package org.goiot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.goiot.core.mybatis.ExtendMapper;
import org.goiot.entity.BlogDetailEntity;

/**
 * Created by chenxing on 2017/6/11.
 */
public interface BlogDetailMapper extends ExtendMapper<BlogDetailEntity> {

    @Select("select ID from BlogDetail where ID=#{id}")
    Long selectIdForCheck(@Param("id") Long id);
}
