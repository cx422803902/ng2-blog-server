package org.goiot.controller.model;

import org.goiot.core.base.Builder;
import org.goiot.entity.BlogDetailEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public class Post {
    private Long id;
    private String title;
    private String content;
    private Date postDate;
    private List<Category> categories;
    private List<Tag> tags;
    private Integer viewCount;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
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

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public static class PostBuilder extends Builder<Post> {
        public PostBuilder appendDefault() {
            Post post = super.getInstance();
            if(post.getCategories() == null) {
                post.setCategories(new ArrayList<Category>());
            }
            if(post.getTags() == null) {
                post.setTags(new ArrayList<Tag>());
            }
            return this;
        }

        public PostBuilder appendBlogDetailEntity(BlogDetailEntity detailEntity) {
            Post post = super.getInstance();
            post.setId(detailEntity.getId());
            post.setTitle(detailEntity.getTitle());
            post.setContent(detailEntity.getContent());
            post.setPostDate(detailEntity.getPostDate());
            post.setViewCount(detailEntity.getViewCount());
            return this;
        }

        public PostBuilder appendCategory(Category category) {
            if(category != null) {
                Post post = super.getInstance();
                List<Category> categories = post.getCategories();
                if(categories == null) {
                    categories = new ArrayList<>();
                    post.setCategories(categories);
                }
                categories.add(category);
            }
            return this;
        }

        public PostBuilder appendTag(Tag tag) {
            if(tag != null) {
                Post post = super.getInstance();
                List<Tag> tags = post.getTags();
                if(tags == null) {
                    tags = new ArrayList<>();
                    post.setTags(tags);
                }
                tags.add(tag);
            }
            return this;
        }
    }
}
