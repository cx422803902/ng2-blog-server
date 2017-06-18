package org.goiot.controller.beans.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by chenxing on 2017/6/18.
 */
public class CommitPostRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String info;
    private String infoImg;
    private String[] tags;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInfoImg() {
        return infoImg;
    }

    public void setInfoImg(String infoImg) {
        this.infoImg = infoImg;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
