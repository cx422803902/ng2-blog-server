package org.goiot.controller;

import org.goiot.controller.model.Comment;
import org.goiot.controller.request.LoadPostCommentsRequest;
import org.goiot.controller.request.SubmitNewCommentRequest;
import org.goiot.controller.response.LoadPostCommentsResponse;
import org.goiot.controller.response.SubmitNewCommentResponse;
import org.goiot.entity.BlogCommentEntity;
import org.goiot.mapper.BlogCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
@Controller
@RequestMapping("comment")
public class CommentController {

    @Autowired
    private BlogCommentMapper blogCommentMapper;

    @RequestMapping("loadPostComments.do")
    @ResponseBody
    public LoadPostCommentsResponse loadPostComments(@RequestBody @Valid LoadPostCommentsRequest request) {
        List<BlogCommentEntity> commentEntities =  blogCommentMapper.selectByPostId(request.getPostId());
        List<Comment> comments = new ArrayList<>(commentEntities.size());
        for(BlogCommentEntity commentEntity : commentEntities) {
            Comment comment = new Comment.CommentBuilder()
                    .appendCommentEntity(commentEntity)
                    .build();
            comments.add(comment);
        }
        LoadPostCommentsResponse response = new LoadPostCommentsResponse();
        response.setComments(comments);
        return response;
    }

    @RequestMapping(value = "submitNewComment.do", method = RequestMethod.POST)
    @ResponseBody
    public SubmitNewCommentResponse submitNewComment(@RequestBody @Valid SubmitNewCommentRequest request) {
        BlogCommentEntity commentEntity = new BlogCommentEntity();
        commentEntity.setPostId(request.getPostId());
        commentEntity.setParentId(request.getParentId());
        commentEntity.setAuthor(request.getAuthor());
        commentEntity.setCreateTime(new Date());
        commentEntity.setContent(request.getContent());
        blogCommentMapper.insert(commentEntity);
        SubmitNewCommentResponse response = new SubmitNewCommentResponse();
        response.setId(commentEntity.getId());
        return response;
    }

}
