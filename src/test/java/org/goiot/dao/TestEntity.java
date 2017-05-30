package org.goiot.dao;

import org.goiot.core.mybatis.jpa.Column;
import org.goiot.core.mybatis.jpa.Table;

/**
 * Created by chenxing on 2017/5/29.
 */
@Table(name = "Test")
public class TestEntity {
    private Long id;

    @Column(name = "name")
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
