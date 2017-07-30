package org.goiot.controller.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogCategoryEntity;

/**
 * Created by chenxing on 2017/7/30.
 */
public class Category {
    private Long id;
    private String name;
    private Integer count;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static class CategoryBuilder extends Builder<Category> {
        public CategoryBuilder appendCategoryEntity(BlogCategoryEntity categoryEntity) {
            Category category = super.getInstance();
            category.setId(categoryEntity.getId());
            category.setName(categoryEntity.getName());
            category.setCount(categoryEntity.getBlogCount());
            return this;
        }
    }
}
