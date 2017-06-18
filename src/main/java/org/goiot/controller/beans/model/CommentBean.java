package org.goiot.controller.beans.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogCommentEntity;

import java.util.Date;

/**
 * Created by chenxing on 2017/6/12.
 */
public class CommentBean {
    private Long id;
    private Long postId;
    private String author;
    private String content;
    private Date postDate;
    private Long parentId;

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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public static class CommentBeanBuilder extends Builder<CommentBean> {
        public CommentBeanBuilder appendCommentEntity(BlogCommentEntity commentEntity) {
            CommentBean commentBean = super.getInstance();
            commentBean.setId(commentEntity.getId());
            commentBean.setPostId(commentEntity.getPostId());
            commentBean.setAuthor(commentEntity.getAuthor());
            commentBean.setContent(commentEntity.getContent());
            commentBean.setPostDate(commentEntity.getPostDate());
            commentBean.setParentId(commentEntity.getParentId());
            return this;
        }
    }
}
