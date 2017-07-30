package org.goiot.controller.request;

import org.goiot.controller.base.WebRequest;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadAllSummariesRequest extends WebRequest{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
