package org.goiot.controller.response;

import org.goiot.controller.base.WebResponse;
import org.goiot.controller.model.Summary;

import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadArchiveSummariesResponse extends WebResponse {
    private List<Summary> summaries;

    public List<Summary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<Summary> summaries) {
        this.summaries = summaries;
    }
}
