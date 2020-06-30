package com.hy.powerplatform.comper.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/5/8.
 */

public class RZDA implements Serializable {
    public String name;
    public String now;
    public String year;
    public String addd;
    public String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAddd() {
        return addd;
    }

    public void setAddd(String addd) {
        this.addd = addd;
    }
}
