package org.goiot.controller.model;

import java.util.Date;

/**
 * Created by chenxing on 2017/7/30.
 */
public class Archive {
    private Date date;
    private Integer count;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
