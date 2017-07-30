package org.goiot.controller.response;

import org.goiot.controller.base.WebResponse;
import org.goiot.controller.model.Tag;

import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadAllTagsResponse extends WebResponse{
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
