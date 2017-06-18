package org.goiot.controller.beans.request;

import javax.validation.constraints.NotNull;

/**
 * Created by chenxing on 2017/6/11.
 */
public class BlogDetailRequest {
    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
