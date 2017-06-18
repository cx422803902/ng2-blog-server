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
public class SummaryBean {
    private Long id;
    private String title;
    private String info;
    private String infoImg;
    private List<String> tags;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public static class SummaryBeanBuilder extends Builder<SummaryBean>{
        public SummaryBeanBuilder appendPostDetailEntity(BlogDetailEntity detailEntity) {
            SummaryBean summaryBean = super.getInstance();
            summaryBean.setId(detailEntity.getId());
            summaryBean.setTitle(detailEntity.getTitle());
            summaryBean.setInfo(detailEntity.getInfo());
            summaryBean.setInfoImg(detailEntity.getInfoImg());
            summaryBean.setPostDate(detailEntity.getPostDate());
            return this;
        }

        public SummaryBeanBuilder appendTagEntities(BlogTagEntity ...tagEntities) {
            SummaryBean summaryBean = super.getInstance();
            List<String> tags = summaryBean.getTags();
            if(tags == null) {
                tags = new ArrayList<>();
            }
            for (BlogTagEntity tagEntity : tagEntities) {
                tags.add(tagEntity.getName());
            }
            summaryBean.setTags(tags);
            return this;
        }
    }
}
