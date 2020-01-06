package com.bawei.dinghongxiang20200106.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class GreenEntity {

    @Id(autoincrement = true)
    private long id;

    private String json;

    private String tag;

    @Generated(hash = 2106021411)
    public GreenEntity(long id, String json, String tag) {
        this.id = id;
        this.json = json;
        this.tag = tag;
    }

    @Generated(hash = 1875989347)
    public GreenEntity() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJson() {
        return this.json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
