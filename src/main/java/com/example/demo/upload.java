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
    @Autowired
    private BookMapper book;
    public  interface checkfile{
        public default List<String> existfile(List<String> list){
            return list;
        }
    }


    @PostMapping("/up")
    @ResponseBody
    String sssa( Part file) throws IOException {
        FileOutputStream out = new FileOutputStream("D:\\" + file.getSubmittedFileName());
        try {
            GongJu.ChangeImageSize(file.getInputStream(),out,500,300);

        }catch (IOException except){
            new File("D:\\" + file.getSubmittedFileName()).delete();
            throw except;
        }

        return "好了";
    }
}
