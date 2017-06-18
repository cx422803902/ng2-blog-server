package org.goiot.entity;

import javax.persistence.*;

/**
 * Created by chenxing on 2017/6/11.
 */
@Table(name = "BlogTagRelation")
public class BlogTagRelationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostId")
    private Long postId;

    @Column(name = "TagId")
    private Long tagId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
