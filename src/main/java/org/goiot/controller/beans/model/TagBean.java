package org.goiot.controller.beans.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogTagEntity;

/**
 * Created by chenxing on 2017/6/11.
 */
public class TagBean {
    private Long id;
    private String name;
    private Integer blogCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }

    public static class TagBeanBuilder extends Builder<TagBean> {
        public TagBeanBuilder appendTagEntity(BlogTagEntity tagEntity) {
            TagBean tagBean = super.getInstance();
            tagBean.setId(tagEntity.getId());
            tagBean.setName(tagEntity.getName());
            tagBean.setBlogCount(tagEntity.getBlogCount());
            return this;
        }
    }
}
