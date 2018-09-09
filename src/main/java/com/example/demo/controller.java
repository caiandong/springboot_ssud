package com.example.demo;

import com.example.demo.aop.mytarget;
import com.example.demo.dao.BookMapper;
import com.example.demo.dao.PeopleMapper;
import com.example.demo.model.People;
import com.example.demo.model.PeopleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class controller {
    @Autowired
    mytarget tar;
    @Autowired
    PeopleMapper people;
    @Autowired
    private serverproperties duankou;
    @Autowired
    private BookMapper book;

    @GetMapping("/haha")
    public  List<?> nni(){
        tar.nishisehi();
        People pl=new People();
        pl.setAge(18);
        pl.setLocale("江苏宿迁");
        pl.setName("小明1");
        pl.setQq("123456789");
        return  people.myselect(1,3);
    }

    @PostMapping("/nihao")
    String mmmmmmm(HttpSession se,String username){
        se.setAttribute("username",username);
        return "redirect:album";
    }
    @GetMapping("/getimages")
    @ResponseBody
    public List<String> mmad(){
        System.out.println(duankou.getXuniduankou());
        List<String> list=book.selectallbookname();
        System.out.println(list);
        return list;
    }
}
