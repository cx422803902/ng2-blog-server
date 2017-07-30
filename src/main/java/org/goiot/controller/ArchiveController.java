package org.goiot.controller;

import org.goiot.controller.model.Archive;
import org.goiot.controller.request.LoadAllArchivesRequest;
import org.goiot.controller.response.LoadAllArchivesResponse;
import org.goiot.mapper.BlogDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
@Controller
@RequestMapping("archive")
public class ArchiveController {

    @Autowired
    private BlogDetailMapper blogDetailMapper;

    @RequestMapping("loadAllArchives.do")
    @ResponseBody
    public LoadAllArchivesResponse loadAllArchives(LoadAllArchivesRequest request) {
        List<Archive> archives = blogDetailMapper.selectAllArchives();
        LoadAllArchivesResponse response = new LoadAllArchivesResponse();
        response.setArchives(archives);
        return response;
    }
}
