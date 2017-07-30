package org.goiot.controller;

import org.goiot.controller.model.Category;
import org.goiot.controller.model.Post;
import org.goiot.controller.model.Summary;
import org.goiot.controller.model.Tag;
import org.goiot.controller.request.*;
import org.goiot.controller.response.*;
import org.goiot.entity.*;
import org.goiot.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenxing on 2017/7/30.
 */
@Controller
@RequestMapping("post")
public class PostController {

    @Autowired
    private BlogDetailMapper blogDetailMapper;

    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;
    @Autowired
    private BlogCategoryRelationMapper blogCategoryRelationMapper;

    @RequestMapping("loadAllSummaries.do")
    @ResponseBody
    public LoadAllSummariesResponse loadAllSummaries(LoadAllSummariesRequest request) {
        List<BlogDetailEntity> blogSummaries = blogDetailMapper.selectAllSummary();
        List<BlogTagEntity> tagEntities = blogTagMapper.selectAll();
        Map<Long, Tag> tagEntityMap = new HashMap<>(tagEntities.size());
        for(BlogTagEntity tagEntity : tagEntities) {
            Tag tag = new Tag.TagBuilder()
                    .appendTagEntity(tagEntity)
                    .build();
            tagEntityMap.put(tagEntity.getId(), tag);
        }
        List<BlogTagRelationEntity> tagRelationEntities = blogTagRelationMapper.selectAll();
        Map<Long, List<Long>> blogToTags = new HashMap<>(blogSummaries.size());
        for(BlogTagRelationEntity tagRelationEntity : tagRelationEntities) {
            List<Long> tagIds = blogToTags.get(tagRelationEntity.getPostId());
            if(tagIds == null) {
                tagIds = new ArrayList<>();
                blogToTags.put(tagRelationEntity.getPostId(), tagIds);
            }
            tagIds.add(tagRelationEntity.getTagId());
        }

        List<BlogCategoryEntity> categoryEntities = blogCategoryMapper.selectAll();
        Map<Long, Category> categoryEntityMap = new HashMap<>(categoryEntities.size());
        for(BlogCategoryEntity categoryEntity : categoryEntities) {
            Category category = new Category.CategoryBuilder()
                    .appendCategoryEntity(categoryEntity)
                    .build();
            categoryEntityMap.put(categoryEntity.getId(), category);
        }
        List<BlogCategoryRelationEntity> categoryRelationEntities = blogCategoryRelationMapper.selectAll();
        Map<Long, List<Long>> blogToCategories = new HashMap<>(blogSummaries.size());
        for(BlogCategoryRelationEntity categoryRelationEntity : categoryRelationEntities) {
            List<Long> categoryIds = blogToCategories.get(categoryRelationEntity.getPostId());
            if(categoryIds == null) {
                categoryIds = new ArrayList<>();
                blogToCategories.put(categoryRelationEntity.getPostId(), categoryIds);
            }
            categoryIds.add(categoryRelationEntity.getCategoryId());
        }
        List<Summary> summaries = new ArrayList<>(blogSummaries.size());
        for(BlogDetailEntity summary : blogSummaries) {
            Summary.SummaryBuilder builder = new Summary.SummaryBuilder()
                    .appendDefault()
                    .appendBlogDetailEntity(summary);
            List<Long> tagIds = blogToTags.get(summary.getId());
            if(!CollectionUtils.isEmpty(tagIds)) {
                for(Long tagId : tagIds) {
                    Tag tag = tagEntityMap.get(tagId);
                    builder.appendTag(tag);
                }
            }
            List<Long> categoryIds = blogToCategories.get(summary.getId());
            if(!CollectionUtils.isEmpty(categoryIds)) {
                for(Long categoryId : categoryIds) {
                    Category category = categoryEntityMap.get(categoryId);
                    builder.appendCategory(category);
                }
            }
            summaries.add(builder.build());
        }
        LoadAllSummariesResponse response = new LoadAllSummariesResponse();
        response.setSummaries(summaries);
        return response;
    }

    @RequestMapping("loadCategorySummaries.do")
    @ResponseBody
    public LoadCategorySummariesResponse loadCategorySummaries(@RequestBody @Valid LoadCategorySummariesRequest request) {
        List<Long> postIds =  blogCategoryRelationMapper.selectPostIdsByCategoryId(request.getKey());

        List<BlogDetailEntity> blogSummaries = blogDetailMapper.selectSummariesByIds(postIds);
        List<BlogTagEntity> tagEntities = blogTagMapper.selectAll();
        Map<Long, Tag> tagEntityMap = new HashMap<>(tagEntities.size());
        for(BlogTagEntity tagEntity : tagEntities) {
            Tag tag = new Tag.TagBuilder()
                    .appendTagEntity(tagEntity)
                    .build();
            tagEntityMap.put(tagEntity.getId(), tag);
        }
        List<BlogTagRelationEntity> tagRelationEntities = blogTagRelationMapper.selectAll();
        Map<Long, List<Long>> blogToTags = new HashMap<>(blogSummaries.size());
        for(BlogTagRelationEntity tagRelationEntity : tagRelationEntities) {
            List<Long> tagIds = blogToTags.get(tagRelationEntity.getPostId());
            if(tagIds == null) {
                tagIds = new ArrayList<>();
                blogToTags.put(tagRelationEntity.getPostId(), tagIds);
            }
            tagIds.add(tagRelationEntity.getTagId());
        }

        List<BlogCategoryEntity> categoryEntities = blogCategoryMapper.selectAll();
        Map<Long, Category> categoryEntityMap = new HashMap<>(categoryEntities.size());
        for(BlogCategoryEntity categoryEntity : categoryEntities) {
            Category category = new Category.CategoryBuilder()
                    .appendCategoryEntity(categoryEntity)
                    .build();
            categoryEntityMap.put(categoryEntity.getId(), category);
        }
        List<BlogCategoryRelationEntity> categoryRelationEntities = blogCategoryRelationMapper.selectAll();
        Map<Long, List<Long>> blogToCategories = new HashMap<>(blogSummaries.size());
        for(BlogCategoryRelationEntity categoryRelationEntity : categoryRelationEntities) {
            List<Long> categoryIds = blogToCategories.get(categoryRelationEntity.getPostId());
            if(categoryIds == null) {
                categoryIds = new ArrayList<>();
                blogToCategories.put(categoryRelationEntity.getPostId(), categoryIds);
            }
            categoryIds.add(categoryRelationEntity.getCategoryId());
        }
        List<Summary> summaries = new ArrayList<>(blogSummaries.size());
        for(BlogDetailEntity summary : blogSummaries) {
            Summary.SummaryBuilder builder = new Summary.SummaryBuilder()
                    .appendDefault()
                    .appendBlogDetailEntity(summary);
            List<Long> tagIds = blogToTags.get(summary.getId());
            if(!CollectionUtils.isEmpty(tagIds)) {
                for(Long tagId : tagIds) {
                    Tag tag = tagEntityMap.get(tagId);
                    builder.appendTag(tag);
                }
            }
            List<Long> categoryIds = blogToCategories.get(summary.getId());
            if(!CollectionUtils.isEmpty(categoryIds)) {
                for(Long categoryId : categoryIds) {
                    Category category = categoryEntityMap.get(categoryId);
                    builder.appendCategory(category);
                }
            }
            summaries.add(builder.build());
        }
        LoadCategorySummariesResponse response = new LoadCategorySummariesResponse();
        response.setSummaries(summaries);
        return response;
    }

    @RequestMapping("loadTagSummaries.do")
    @ResponseBody
    public LoadTagSummariesResponse loadTagSummaries(@RequestBody @Valid LoadTagSummariesRequest request) {
        List<Long> postIds =  blogTagRelationMapper.selectPostIdsByTagId(request.getKey());

        List<BlogDetailEntity> blogSummaries = blogDetailMapper.selectSummariesByIds(postIds);
        List<BlogTagEntity> tagEntities = blogTagMapper.selectAll();
        Map<Long, Tag> tagEntityMap = new HashMap<>(tagEntities.size());
        for(BlogTagEntity tagEntity : tagEntities) {
            Tag tag = new Tag.TagBuilder()
                    .appendTagEntity(tagEntity)
                    .build();
            tagEntityMap.put(tagEntity.getId(), tag);
        }
        List<BlogTagRelationEntity> tagRelationEntities = blogTagRelationMapper.selectAll();
        Map<Long, List<Long>> blogToTags = new HashMap<>(blogSummaries.size());
        for(BlogTagRelationEntity tagRelationEntity : tagRelationEntities) {
            List<Long> tagIds = blogToTags.get(tagRelationEntity.getPostId());
            if(tagIds == null) {
                tagIds = new ArrayList<>();
                blogToTags.put(tagRelationEntity.getPostId(), tagIds);
            }
            tagIds.add(tagRelationEntity.getTagId());
        }

        List<BlogCategoryEntity> categoryEntities = blogCategoryMapper.selectAll();
        Map<Long, Category> categoryEntityMap = new HashMap<>(categoryEntities.size());
        for(BlogCategoryEntity categoryEntity : categoryEntities) {
            Category category = new Category.CategoryBuilder()
                    .appendCategoryEntity(categoryEntity)
                    .build();
            categoryEntityMap.put(categoryEntity.getId(), category);
        }
        List<BlogCategoryRelationEntity> categoryRelationEntities = blogCategoryRelationMapper.selectAll();
        Map<Long, List<Long>> blogToCategories = new HashMap<>(blogSummaries.size());
        for(BlogCategoryRelationEntity categoryRelationEntity : categoryRelationEntities) {
            List<Long> categoryIds = blogToCategories.get(categoryRelationEntity.getPostId());
            if(categoryIds == null) {
                categoryIds = new ArrayList<>();
                blogToCategories.put(categoryRelationEntity.getPostId(), categoryIds);
            }
            categoryIds.add(categoryRelationEntity.getCategoryId());
        }
        List<Summary> summaries = new ArrayList<>(blogSummaries.size());
        for(BlogDetailEntity summary : blogSummaries) {
            Summary.SummaryBuilder builder = new Summary.SummaryBuilder()
                    .appendDefault()
                    .appendBlogDetailEntity(summary);
            List<Long> tagIds = blogToTags.get(summary.getId());
            if(!CollectionUtils.isEmpty(tagIds)) {
                for(Long tagId : tagIds) {
                    Tag tag = tagEntityMap.get(tagId);
                    builder.appendTag(tag);
                }
            }
            List<Long> categoryIds = blogToCategories.get(summary.getId());
            if(!CollectionUtils.isEmpty(categoryIds)) {
                for(Long categoryId : categoryIds) {
                    Category category = categoryEntityMap.get(categoryId);
                    builder.appendCategory(category);
                }
            }
            summaries.add(builder.build());
        }
        LoadTagSummariesResponse response = new LoadTagSummariesResponse();
        response.setSummaries(summaries);
        return response;
    }

    @RequestMapping("loadArchiveSummaries.do")
    @ResponseBody
    public LoadArchiveSummariesResponse loadArchiveSummaries(@RequestBody @Valid LoadArchiveSummariesRequest request) {
        List<BlogDetailEntity> blogSummaries = blogDetailMapper.selectSummariesByDateFormat(request.getKey());
        List<BlogTagEntity> tagEntities = blogTagMapper.selectAll();
        Map<Long, Tag> tagEntityMap = new HashMap<>(tagEntities.size());
        for(BlogTagEntity tagEntity : tagEntities) {
            Tag tag = new Tag.TagBuilder()

                    .appendTagEntity(tagEntity)
                    .build();
            tagEntityMap.put(tagEntity.getId(), tag);
        }
        List<BlogTagRelationEntity> tagRelationEntities = blogTagRelationMapper.selectAll();
        Map<Long, List<Long>> blogToTags = new HashMap<>(blogSummaries.size());
        for(BlogTagRelationEntity tagRelationEntity : tagRelationEntities) {
            List<Long> tagIds = blogToTags.get(tagRelationEntity.getPostId());
            if(tagIds == null) {
                tagIds = new ArrayList<>();
                blogToTags.put(tagRelationEntity.getPostId(), tagIds);
            }
            tagIds.add(tagRelationEntity.getTagId());
        }

        List<BlogCategoryEntity> categoryEntities = blogCategoryMapper.selectAll();
        Map<Long, Category> categoryEntityMap = new HashMap<>(categoryEntities.size());
        for(BlogCategoryEntity categoryEntity : categoryEntities) {
            Category category = new Category.CategoryBuilder()
                    .appendCategoryEntity(categoryEntity)
                    .build();
            categoryEntityMap.put(categoryEntity.getId(), category);
        }
        List<BlogCategoryRelationEntity> categoryRelationEntities = blogCategoryRelationMapper.selectAll();
        Map<Long, List<Long>> blogToCategories = new HashMap<>(blogSummaries.size());
        for(BlogCategoryRelationEntity categoryRelationEntity : categoryRelationEntities) {
            List<Long> categoryIds = blogToCategories.get(categoryRelationEntity.getPostId());
            if(categoryIds == null) {
                categoryIds = new ArrayList<>();
                blogToCategories.put(categoryRelationEntity.getPostId(), categoryIds);
            }
            categoryIds.add(categoryRelationEntity.getCategoryId());
        }
        List<Summary> summaries = new ArrayList<>(blogSummaries.size());
        for(BlogDetailEntity summary : blogSummaries) {
            Summary.SummaryBuilder builder = new Summary.SummaryBuilder()
                    .appendDefault()
                    .appendBlogDetailEntity(summary);
            List<Long> tagIds = blogToTags.get(summary.getId());
            if(!CollectionUtils.isEmpty(tagIds)) {
                for(Long tagId : tagIds) {
                    Tag tag = tagEntityMap.get(tagId);
                    builder.appendTag(tag);
                }
            }
            List<Long> categoryIds = blogToCategories.get(summary.getId());
            if(!CollectionUtils.isEmpty(categoryIds)) {
                for(Long categoryId : categoryIds) {
                    Category category = categoryEntityMap.get(categoryId);
                    builder.appendCategory(category);
                }
            }
            summaries.add(builder.build());
        }
        LoadArchiveSummariesResponse response = new LoadArchiveSummariesResponse();
        response.setSummaries(summaries);
        return response;
    }

    @RequestMapping("loadPost.do")
    @ResponseBody
    public LoadPostResponse loadPost(@RequestBody @Valid LoadPostRequest request) {
        BlogDetailEntity blogDetailEntity = blogDetailMapper.selectByPrimaryKey(request.getPostId());
        if(blogDetailEntity == null) {
            return new LoadPostResponse();
        }
        List<Long> tagIds = blogTagRelationMapper.selectTagIdsByPostId(request.getPostId());
        List<BlogTagEntity> tagEntities = CollectionUtils.isEmpty(tagIds) ? new ArrayList<BlogTagEntity>() : blogTagMapper.selectByPrimaryKeyBatch(tagIds.toArray());
        List<Long> categoryIds = blogCategoryRelationMapper.selectCategoryIdsByPostId(request.getPostId());
        List<BlogCategoryEntity> categoryEntities = CollectionUtils.isEmpty(categoryIds) ? new ArrayList<BlogCategoryEntity>() : blogCategoryMapper.selectByPrimaryKeyBatch(categoryIds.toArray());
        Post.PostBuilder builder = new Post.PostBuilder()
                .appendBlogDetailEntity(blogDetailEntity);
        for(BlogTagEntity tagEntity : tagEntities) {
            Tag tag = new Tag.TagBuilder()
                    .appendTagEntity(tagEntity)
                    .build();
            builder.appendTag(tag);
        }
        for(BlogCategoryEntity categoryEntity : categoryEntities) {
            Category category = new Category.CategoryBuilder()
                    .appendCategoryEntity(categoryEntity)
                    .build();
            builder.appendCategory(category);
        }
        blogDetailMapper.increaseViewCount(request.getPostId());
        LoadPostResponse response = new LoadPostResponse();
        response.setPost(builder.build());
        return response;
    }
}
