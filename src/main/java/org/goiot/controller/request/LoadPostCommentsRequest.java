package org.goiot.controller.request;

import org.goiot.controller.base.WebRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadPostCommentsRequest extends WebRequest {
    @NotNull
    private Long postId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
