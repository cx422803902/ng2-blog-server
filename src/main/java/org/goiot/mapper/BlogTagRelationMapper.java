package org.goiot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.goiot.core.mybatis.ExtendMapper;
import org.goiot.entity.BlogTagRelationEntity;

import java.util.List;

/**
 * Created by chenxing on 2017/6/11.
 */
public interface BlogTagRelationMapper extends ExtendMapper<BlogTagRelationEntity> {

    @Select("select * from BlogTagRelation where PostId=#{postId}")
    List<BlogTagRelationEntity> selectByPostId(@Param("postId") Long postId);

    @Select("select TagId from BlogTagRelation where PostId=#{postId}")
    List<Long> selectTagIdsByPostId(@Param("postId") Long postId);

    @Select("select * from BlogTagRelation where TagId=#{tagId}")
    List<BlogTagRelationEntity> selectByTagId(@Param("tagId") Long tagId);

    @Select("select PostId from BlogTagRelation where TagId=#{tagId}")
    List<Long> selectPostIdsByTagId(@Param("tagId") Long tagId);

}
