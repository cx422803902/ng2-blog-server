package org.goiot.controller.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogCommentEntity;

import java.util.Date;

/**
 * Created by chenxing on 2017/7/30.
 */
public class Comment {
    private Long id;
    private Long postId;
    private Long parentId;
    private String author;
    private String content;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public static class CommentBuilder extends Builder<Comment> {
        public CommentBuilder appendCommentEntity(BlogCommentEntity commentEntity) {
            Comment comment = super.getInstance();
            comment.setId(commentEntity.getId());
            comment.setPostId(commentEntity.getPostId());
            comment.setParentId(commentEntity.getParentId());
            comment.setAuthor(commentEntity.getAuthor());
            comment.setContent(commentEntity.getContent());
            comment.setCreateTime(commentEntity.getCreateTime());
            return this;
        }

    }
}
