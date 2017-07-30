package org.goiot.controller;

import org.goiot.controller.model.Category;
import org.goiot.controller.request.LoadAllCategoriesRequest;
import org.goiot.controller.response.LoadAllCategoriesResponse;
import org.goiot.entity.BlogCategoryEntity;
import org.goiot.mapper.BlogCategoryMapper;
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
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private BlogCategoryMapper blogCategoryMapper;

    @RequestMapping("loadAllCategories.do")
    @ResponseBody
    public LoadAllCategoriesResponse loadAllCategories(LoadAllCategoriesRequest request) {
        List<BlogCategoryEntity> categoryEntities = blogCategoryMapper.selectAll();
        List<Category> categories = new ArrayList<>(categoryEntities.size());
        for(BlogCategoryEntity categoryEntity : categoryEntities) {
            Category category = new Category.CategoryBuilder()
                    .appendCategoryEntity(categoryEntity)
                    .build();
            categories.add(category);
        }
        LoadAllCategoriesResponse response = new LoadAllCategoriesResponse();
        response.setCategories(categories);
        return response;
    }


}
