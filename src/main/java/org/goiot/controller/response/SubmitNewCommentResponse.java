package org.goiot.controller.response;

import org.goiot.controller.base.WebResponse;

/**
 * Created by chenxing on 2017/7/30.
 */
public class SubmitNewCommentResponse extends WebResponse {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
