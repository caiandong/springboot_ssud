package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Controller
public class upload {
    @PostMapping("/up")
    @ResponseBody
    String sssa(/*MultipartFile file,*/ Part file) throws IOException {
        //String filename=file.getOriginalFilename();
        //System.out.println(filename);
        //if(filename==null)
        //    return "名字为空";
//        ByteBuffer b=ByteBuffer.allocate(1024);
//        try {
//            InputStream in=file.getInputStream();
//            OutputStream out=new FileOutputStream("/file"+filename);
//            FileChannel ch = ((FileOutputStream) out).getChannel();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        OutputStream out=new FileOutputStream(filename);
//        out.write(file.getBytes());
//        out.close();
        System.out.println(file.getSubmittedFileName());
        file.write(file.getSubmittedFileName());
        return "好了";
    }
}
