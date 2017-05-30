package org.goiot.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by chenxing on 2017/5/30.
 */
@Controller
public class BlogController {

    /**
     * 返回所有标签
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/tags", method = RequestMethod.POST)
    public String tags() {
        List<Map<String, Object>> tags = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            Map<String, Object> tag = new HashMap();
            tag.put("tagId", i);
            tag.put("tagContent", "标签"+i);
            tag.put("tagCount", i);
            tags.add(tag);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("data", tags);
        return JSON.toJSONString(response);
    }

    /**
     * 返回所有摘要
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/summaries", method = RequestMethod.POST)
    public String summaries() {
        List<Map<String, Object>>  tags = new ArrayList<>();
        for(int i = 1; i <= 20; i++) {
            Map<String, Object> tag = new HashMap();
            tag.put("postId", i);
            tag.put("title", "this is title "+i);
            tag.put("info", "ldsfkejkfjsdaflkjsadflkejflkjlsakfj");
            tag.put("tags", Arrays.asList("a1", "b1", "c1"));
            tag.put("infoImg", "http://fun.youth.cn/yl24xs/201702/W020170217493133403781.jpg");
            tag.put("postDate", new Date());
            tags.add(tag);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("data", tags);
        return JSON.toJSONString(response);
    }

    /**
     * 返回指定标签的摘要
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/tagSummaries", method = RequestMethod.POST)
    public String tagSummaries(@RequestBody String body) {
        return "";
    }

    /**
     * 返回博客具体信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/detail", method = RequestMethod.POST)
    public String blogDetail(@RequestBody String body) {
        return "";
    }

    /**
     * 返回博客的所有评论
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/api/blog/postComments", method = RequestMethod.POST)
    public String postComments(@RequestBody String body) {
        return "";
    }

}
