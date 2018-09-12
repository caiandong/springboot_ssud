package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "myserver.se")
public class Serverproperties {
    private String xuniduankou;
    private Integer height;
    private Integer width;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getXuniduankou() {
        return translateDir(xuniduankou);
    }

    public void setXuniduankou(String xuniduankou) {
        this.xuniduankou = xuniduankou;
    }
    private   String translateDir(String dir){
        if (dir.lastIndexOf(dir.length()-1)=='/')
            return dir;
        return dir+"/";
    }
}


