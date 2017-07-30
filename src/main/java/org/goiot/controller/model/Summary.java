package org.goiot.controller.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogDetailEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public class Summary {
    private Long id;
    private String title;
    private String summary;
    private Date postDate;
    private Integer viewCount;
    private List<Category> categories;
    private List<Tag> tags;

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public static class SummaryBuilder extends Builder<Summary> {
        public SummaryBuilder appendDefault() {
            Summary summary = super.getInstance();
            if(summary.getCategories() == null) {
                summary.setCategories(new ArrayList<Category>());
            }
            if(summary.getTags() == null) {
                summary.setTags(new ArrayList<Tag>());
            }
            return this;
        }

        public SummaryBuilder appendBlogDetailEntity(BlogDetailEntity detailEntity) {
            Summary summary = super.getInstance();
            summary.setId(detailEntity.getId());
            summary.setTitle(detailEntity.getTitle());
            summary.setSummary(detailEntity.getInfo());
            summary.setPostDate(detailEntity.getPostDate());
            summary.setViewCount(detailEntity.getViewCount());
            return this;
        }

        public SummaryBuilder appendCategory(Category category) {
            if(category != null) {
                Summary summary = super.getInstance();
                List<Category> categories = summary.getCategories();
                if(categories == null) {
                    categories = new ArrayList<>();
                    summary.setCategories(categories);
                }
                categories.add(category);
            }
            return this;
        }

        public SummaryBuilder appendTag(Tag tag) {
            if(tag != null) {
                Summary summary = super.getInstance();
                List<Tag> tags = summary.getTags();
                if(tags == null) {
                    tags = new ArrayList<>();
                    summary.setTags(tags);
                }
                tags.add(tag);
            }
            return this;
        }
    }
}
