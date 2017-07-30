package org.goiot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.goiot.core.mybatis.ExtendMapper;
import org.goiot.entity.BlogCategoryRelationEntity;

import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public interface BlogCategoryRelationMapper extends ExtendMapper<BlogCategoryRelationEntity> {
    @Select("select * from BlogCategoryRelation where PostId=#{postId}")
    List<BlogCategoryRelationEntity> selectByPostId(@Param("postId") Long postId);

    @Select("select CategoryId from BlogCategoryRelation where PostId=#{postId}")
    List<Long> selectCategoryIdsByPostId(@Param("postId") Long postId);

    @Select("select * from BlogCategoryRelation where CategoryId=#{categoryId}")
    List<BlogCategoryRelationEntity> selectByCategoryId(@Param("categoryId") Long categoryId);

    @Select("select PostId from BlogCategoryRelation where CategoryId=#{categoryId}")
    List<Long> selectPostIdsByCategoryId(@Param("categoryId") Long categoryId);
}
