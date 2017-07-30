package org.goiot.controller.response;

import org.goiot.controller.base.WebResponse;
import org.goiot.controller.model.Category;

import java.util.List;

/**
 * Created by chenxing on 2017/7/30.
 */
public class LoadAllCategoriesResponse extends WebResponse{
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
