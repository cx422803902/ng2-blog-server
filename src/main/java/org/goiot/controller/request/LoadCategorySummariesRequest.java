package org.goiot.controller.request;

import org.goiot.controller.base.WebRequest;

import javax.validation.constraints.NotNull;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadCategorySummariesRequest extends WebRequest {
    @NotNull
    private Long key;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }
}
