package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "myserver.se")
public class serverproperties {
    String xuniduankou;

    public String getXuniduankou() {
        return xuniduankou;
    }

    public void setXuniduankou(String xuniduankou) {
        this.xuniduankou = xuniduankou;
    }
}
