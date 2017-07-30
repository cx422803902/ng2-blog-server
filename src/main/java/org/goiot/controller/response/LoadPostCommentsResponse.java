package org.goiot.controller.response;

import org.goiot.controller.base.WebResponse;
import org.goiot.controller.model.Comment;

import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadPostCommentsResponse extends WebResponse {
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
