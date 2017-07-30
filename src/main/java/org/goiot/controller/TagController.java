package org.goiot.controller;

import org.goiot.controller.model.Tag;
import org.goiot.controller.request.LoadAllTagsRequest;
import org.goiot.controller.response.LoadAllTagsResponse;
import org.goiot.entity.BlogTagEntity;
import org.goiot.mapper.BlogTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
@Controller
@RequestMapping("tag")
public class TagController {
    @Autowired
    private BlogTagMapper blogTagMapper;

    @RequestMapping("loadAllTags.do")
    @ResponseBody
    public LoadAllTagsResponse loadAllTags(LoadAllTagsRequest request) {
        List<BlogTagEntity> tagEntities = blogTagMapper.selectAll();
        List<Tag> tags = new ArrayList<>(tagEntities.size());
        for(BlogTagEntity tagEntity : tagEntities) {
            Tag tag = new Tag.TagBuilder()
                    .appendTagEntity(tagEntity)
                    .build();
            tags.add(tag);
        }
        LoadAllTagsResponse response = new LoadAllTagsResponse();
        response.setTags(tags);
        return response;
    }
}
