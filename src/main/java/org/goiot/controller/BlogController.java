package org.goiot.controller;

import org.goiot.controller.beans.model.BlogDetailBean;
import org.goiot.controller.beans.model.CommentBean;
import org.goiot.controller.beans.model.SummaryBean;
import org.goiot.controller.beans.model.TagBean;
import org.goiot.controller.beans.request.BlogDetailRequest;
import org.goiot.controller.beans.request.PostCommentsRequest;
import org.goiot.controller.beans.request.TagSummariesRequest;
import org.goiot.entity.BlogCommentEntity;
import org.goiot.entity.BlogDetailEntity;
import org.goiot.entity.BlogTagEntity;
import org.goiot.mapper.BlogCommentMapper;
import org.goiot.mapper.BlogDetailMapper;
import org.goiot.mapper.BlogTagMapper;
import org.goiot.mapper.BlogTagRelationMapper;
import org.goiot.utils.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxing on 2017/5/30.
 */
@Controller
public class BlogController {

    @Autowired
    private BlogCommentMapper commentDao;
    @Autowired
    private BlogDetailMapper detailDao;
    @Autowired
    private BlogTagMapper tagDao;
    @Autowired
    private BlogTagRelationMapper tagRelationDao;

    /**
     * 返回所有标签
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/tags", method = RequestMethod.POST)
    public String tags() {
        List<BlogTagEntity> tagEntities = tagDao.selectAll();
        List<TagBean> tagBeans = new ArrayList<>(tagEntities.size());
        tagEntities.forEach(tagEntity -> tagBeans.add(
                new TagBean.TagBeanBuilder()
                        .appendTagEntity(tagEntity)
                        .build()));
        return JSONUtils.toJSONResponse(tagBeans);
    }

    /**
     * 返回所有摘要
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/summaries", method = RequestMethod.POST)
    public String summaries() {
        List<BlogDetailEntity> detailEntities = detailDao.selectAll();
        List<SummaryBean> summaryBeans = new ArrayList<>(detailEntities.size());
        detailEntities.forEach(detailEntity -> {
            List<Long> tagIds = tagRelationDao.selectTagIdsByPostId(detailEntity.getId());
            List<BlogTagEntity> tagEntities = tagDao.selectByPrimaryKeyBatch(tagIds.toArray());
            summaryBeans.add(
                    new SummaryBean.SummaryBeanBuilder()
                            .appendPostDetailEntity(detailEntity)
                            .appendTagEntities(tagEntities.toArray(new BlogTagEntity[tagEntities.size()]))
                            .build());
        });
        return JSONUtils.toJSONResponse(summaryBeans);
    }

    /**
     * 返回指定标签的摘要
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/tagSummaries", method = RequestMethod.POST)
    public String tagSummaries(@RequestBody @Valid TagSummariesRequest request) {
        List<Long> postIds = tagRelationDao.selectPostIdsByTagId(request.getId());
        List<BlogDetailEntity> detailEntities = detailDao.selectByPrimaryKeyBatch(postIds.toArray());
        List<SummaryBean> summaryBeans = new ArrayList<>(detailEntities.size());
        detailEntities.forEach(detailEntity -> {
            List<Long> tagIds = tagRelationDao.selectTagIdsByPostId(detailEntity.getId());
            List<BlogTagEntity> tagEntities = tagDao.selectByPrimaryKeyBatch(tagIds.toArray());
            summaryBeans.add(
                    new SummaryBean.SummaryBeanBuilder()
                            .appendPostDetailEntity(detailEntity)
                            .appendTagEntities(tagEntities.toArray(new BlogTagEntity[tagEntities.size()]))
                            .build());
        });
        return JSONUtils.toJSONResponse(summaryBeans);
    }

    /**
     * 返回博客具体信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/detail", method = RequestMethod.POST)
    public String blogDetail(@RequestBody @Valid BlogDetailRequest request) {
        BlogDetailEntity detailEntity = detailDao.selectByPrimaryKey(request.getId());
        if (detailEntity == null) {
            return null;
        }
        List<Long> tagIds = tagRelationDao.selectTagIdsByPostId(detailEntity.getId());
        List<BlogTagEntity> tagEntities = tagDao.selectByPrimaryKeyBatch(tagIds.toArray());
        BlogDetailBean detailBean = new BlogDetailBean.BlogDetailBeanBuilder()
                .appendPostDetailEntity(detailEntity)
                .appendTagEntities(tagEntities.toArray(new BlogTagEntity[tagEntities.size()]))
                .build();
        return JSONUtils.toJSONResponse(detailBean);
    }

    /**
     * 返回博客的所有评论
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/postComments", method = RequestMethod.POST)
    public String postComments(@RequestBody @Valid PostCommentsRequest request) {
        List<BlogCommentEntity> commentEntities = commentDao.selectByPostId(request.getPostId());
        List<CommentBean> commentBeans = new ArrayList<>();
        commentEntities.forEach(commentEntity -> commentBeans.add(
                new CommentBean.CommentBeanBuilder()
                        .appendCommentEntity(commentEntity)
                        .build()
        ));
        return JSONUtils.toJSONResponse(commentBeans);
    }

}
