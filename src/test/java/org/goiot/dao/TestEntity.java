package org.goiot.dao;

import org.goiot.mybatis.InsertColumn;
import org.goiot.mybatis.InsertTable;

/**
 * Created by chenxing on 2017/5/29.
 */
@InsertTable(name = "Test")
public class TestEntity {
    private Long id;

    @InsertColumn(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
