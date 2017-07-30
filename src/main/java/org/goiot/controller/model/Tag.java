package org.goiot.controller.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogTagEntity;

/**
 * Created by chenxing on 2017/7/30.
 */
public class Tag {
    private Long id;
    private String name;
    private Integer count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class TagBuilder extends Builder<Tag> {
        public TagBuilder appendTagEntity(BlogTagEntity tagEntity) {
            Tag tag = super.getInstance();
            tag.setId(tagEntity.getId());
            tag.setName(tagEntity.getName());
            tag.setCount(tagEntity.getBlogCount());
            return this;
        }
    }
}
