package com.example.demo.Controller;

import com.example.demo.MycustomBeanAndTools.PictureUploadFailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler(PictureUploadFailException.class)
    String ads(PictureUploadFailException e){

        return "服务器忙碌请重试....\n"+ Arrays.toString(e.getStackTrace());
    }
}
