package org.goiot.controller.response;

import org.goiot.controller.base.WebResponse;
import org.goiot.controller.model.Archive;

import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadAllArchivesResponse extends WebResponse {
    private List<Archive> archives;

    public List<Archive> getArchives() {
        return archives;
    }

    public void setArchives(List<Archive> archives) {
        this.archives = archives;
    }
}
