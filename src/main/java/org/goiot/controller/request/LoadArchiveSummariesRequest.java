package org.goiot.controller.request;

import org.goiot.controller.base.WebRequest;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadArchiveSummariesRequest extends WebRequest {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
