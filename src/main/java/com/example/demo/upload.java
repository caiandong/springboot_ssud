package com.example.demo;

import com.example.demo.MycustomBean.GongJu;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@EnableConfigurationProperties({Serverproperties.class})
public class upload {
    @Autowired
    Myservice myservice;
    @Autowired
    private  Serverproperties serverproperties;

    private  String dir;

    public  interface checkfile{
        public default List<String> existfile(List<String> list){
            return list;
        }
    }
    @PostConstruct
    public void innit() {
        this.dir =Serverproperties.translateDir(serverproperties.getXuniduankou());
    }

    @PostMapping("/up")
    @ResponseBody
    String sssa(Book book,Part file) throws Exception {
        System.out.println(book);
        if(file==null) {
            book.setPicturename(null);
            myservice.insertbook(book);
            return "没有图片";
        }
        String name = UUID.randomUUID().toString() + "."+file.getSubmittedFileName().split("\\.")[1];
        File file1 = new File(dir +name );
        book.setPicturename(name);
        try {
            FileOutputStream out = new FileOutputStream(file1);
            GongJu.ChangeImageSize(file.getInputStream(),out,serverproperties.getWidth(),serverproperties.getHeight());
            myservice.insertbook(book);
        }catch (Exception except){
            file1.delete();
            throw except;
        }

        return "好了";
    }
}
