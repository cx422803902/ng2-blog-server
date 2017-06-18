package org.goiot.controller.beans.request;

import javax.validation.constraints.NotNull;

/**
 * Created by chenxing on 2017/6/12.
 */
public class PostCommentsRequest {
    @NotNull
    private Long postId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
