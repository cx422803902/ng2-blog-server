package org.goiot.entity;

import javax.persistence.*;

/**
 * Created by chenxing on 2017/7/30.
 */
@Table(name = "BlogCategoryRelation")
public class BlogCategoryRelationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostId")
    private Long postId;

    @Column(name = "CategoryId")
    private Long categoryId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
