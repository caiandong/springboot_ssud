package com.example.demo;

import com.example.demo.MycustomBean.GongJu;
import com.example.demo.dao.BookMapper;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

@Controller
@EnableConfigurationProperties({serverproperties.class})
public class upload {
    public  interface checkfile{
        public default List<String> existfile(List<String> list){
            return list;
        }


    }
    @Autowired
    private serverproperties duankou;
    @Autowired
    private BookMapper book;
    @GetMapping("/getimages")
    @ResponseBody
    public List<String> mmad(){
        System.out.println(duankou.getXuniduankou());
        List<String> list;
        list=book.selectallbookname();
        System.out.println(list);
        return list;
    }
    @PostMapping("/up")
    @ResponseBody
    String sssa( Part file) throws IOException {

//        System.out.println(file.getSubmittedFileName());
//        file.write(file.getSubmittedFileName());
        GongJu.ChangeImageSize(file.getInputStream(),new FileOutputStream("D:\\sss.jpeg"),500,300);
        return "好了";
    }
}
