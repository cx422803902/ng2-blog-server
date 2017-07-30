package org.goiot.mapper;

import org.apache.ibatis.annotations.*;
import org.goiot.controller.model.Archive;
import org.goiot.core.mybatis.ExtendMapper;
import org.goiot.entity.BlogDetailEntity;

import java.util.List;

/**
 * Created by chenxing on 2017/6/11.
 */
public interface BlogDetailMapper extends ExtendMapper<BlogDetailEntity> {

    @Select("select ID from BlogDetail where ID=#{id}")
    Long selectIdForCheck(@Param("id") Long id);

    @Select("select ID, Title, Info, PostDate, ViewCount from BlogDetail")
    List<BlogDetailEntity> selectAllSummary();

    List<BlogDetailEntity> selectSummariesByIds(@Param("ids") List<Long> ids);

    @Select("select ID, Title, Info, PostDate, ViewCount from BlogDetail where DATE_FORMAT(`PostDate`, '%Y%m')=#{dateFormat}")
    List<BlogDetailEntity> selectSummariesByDateFormat(@Param("dateFormat") String dateFormat);

    @Select("select ID, Title, Info, PostDate, ViewCount from BlogDetail")
    List<BlogDetailEntity> selectAllSummariesByCategoryId(@Param("categoryId") Long categoryId);

    @Select("select ID, Title, Info, PostDate, ViewCount from BlogDetail join")
    List<BlogDetailEntity> selectAllSummariesByTagId(@Param("tagId") Long tagId);

    @Select("select count(*) as count, DATE_FORMAT(`PostDate`, '%Y-%m-01 00:00:00') as date from BlogDetail group by date order by date")
    @Results(value = {
            @Result(property = "date", column = "date"),
            @Result(property = "count", column = "count")
    })
    List<Archive> selectAllArchives();

    @Update("update BlogDetail set `ViewCount`=`ViewCount`+1 where ID=#{id}")
    int increaseViewCount(@Param("id") Long id);
}
