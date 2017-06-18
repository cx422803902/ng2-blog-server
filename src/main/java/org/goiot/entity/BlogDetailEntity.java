package org.goiot.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by chenxing on 2017/6/11.
 */
@Table(name = "BlogDetail")
public class BlogDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Info")
    private String info;

    @Column(name = "InfoImg")
    private String infoImg;

    @Column(name = "Content")
    private String content;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Column(name = "PostDate")
    private Date postDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoImg() {
        return infoImg;
    }

    public void setInfoImg(String infoImg) {
        this.infoImg = infoImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
