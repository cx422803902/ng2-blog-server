package org.goiot.controller.request;

import org.goiot.controller.base.WebRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by chenxing on 2017/7/30.
 */
public class SubmitNewCommentRequest extends WebRequest {
    @NotNull
    private Long postId;
    private Long parentId;
    private String author;
    @NotNull
    private String content;

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
}
