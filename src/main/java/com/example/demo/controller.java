package com.example.demo;

import com.example.demo.aop.mytarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    mytarget tar;
    @GetMapping("/ni")
    public String nni(){
        tar.nishisehi();
        return "sssssssssssssa";
    }

}
