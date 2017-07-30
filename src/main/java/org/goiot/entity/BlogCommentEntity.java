package org.goiot.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chenxing on 2017/6/11.
 */
@Table(name = "BlogComment")
public class BlogCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PostId")
    private Long postId;

    @Column(name = "Author")
    private String author;

    @Column(name = "Content")
    private String content;

    @Column(name = "CreateTime")
    private Date createTime;

    @Column(name = "ParentId")
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
