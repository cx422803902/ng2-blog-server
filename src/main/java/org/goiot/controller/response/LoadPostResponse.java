package org.goiot.controller.response;

import org.goiot.controller.base.WebResponse;
import org.goiot.controller.model.Post;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadPostResponse extends WebResponse{
    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
