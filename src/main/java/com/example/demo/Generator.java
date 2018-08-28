package com.example.demo;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args)throws Exception {
        /*List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //File file = new File("nihao.txt");
        //System.out.println(file.getAbsolutePath());
        //相对路径是相对于虚拟机启动的目录，通常情况下是工程下的第一个目录，所以是hope下的目录
        File configFile = new File("src/main/resources/mybatis/MyTableMapper.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);*/
    }
}
