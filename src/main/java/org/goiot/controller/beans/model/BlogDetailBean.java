package org.goiot.controller.beans.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogDetailEntity;
import org.goiot.entity.BlogTagEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxing on 2017/6/11.
 */
public class BlogDetailBean {
    private Long id;
    private String title;
    private String info;
    private String infoImg;
    private String content;
    private List tags;
    private Date postDate;
    private Date updateDate;

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

    public List getTags() {
        return tags;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public static class BlogDetailBeanBuilder extends Builder<BlogDetailBean> {
        public BlogDetailBeanBuilder appendPostDetailEntity(BlogDetailEntity detailEntity) {
            BlogDetailBean blogDetailBean = super.getInstance();
            blogDetailBean.setId(detailEntity.getId());
            blogDetailBean.setTitle(detailEntity.getTitle());
            blogDetailBean.setInfo(detailEntity.getInfo());
            blogDetailBean.setInfoImg(detailEntity.getInfoImg());
            blogDetailBean.setContent(detailEntity.getContent());
            blogDetailBean.setPostDate(detailEntity.getPostDate());
            blogDetailBean.setUpdateDate(detailEntity.getUpdateDate());
            return this;
        }

        public BlogDetailBeanBuilder appendTagEntities(BlogTagEntity... tagEntities) {
            BlogDetailBean blogDetailBean = super.getInstance();
            List<String> tags = blogDetailBean.getTags();
            if (tags == null) {
                tags = new ArrayList<>();
            }
            for (BlogTagEntity tagEntity : tagEntities) {
                tags.add(tagEntity.getName());
            }
            blogDetailBean.setTags(tags);
            return this;
        }
    }
}
