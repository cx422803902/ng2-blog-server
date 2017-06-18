package org.goiot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.goiot.core.mybatis.ExtendMapper;
import org.goiot.entity.BlogCommentEntity;

import java.util.List;

/**
 * Created by chenxing on 2017/6/11.
 */
public interface BlogCommentMapper extends ExtendMapper<BlogCommentEntity> {

    @Select("select * from BlogComment where PostId=#{postId}")
    List<BlogCommentEntity> selectByPostId(@Param("postId") Long postId);
}
