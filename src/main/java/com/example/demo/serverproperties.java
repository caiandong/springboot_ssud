package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "myserver.se")
public class Serverproperties {
    private String xuniduankou;
    private int height;
    private int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getXuniduankou() {
        return xuniduankou;
    }

    public void setXuniduankou(String xuniduankou) {
        this.xuniduankou = xuniduankou;
    }
    public static String translateDir(String dir){
        return dir;
    }
}
