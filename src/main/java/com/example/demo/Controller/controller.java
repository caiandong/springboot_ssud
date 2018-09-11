package com.example.demo.Controller;


import com.example.demo.Serverproperties;
import com.example.demo.Service.BookService;
import com.example.demo.aop.mytarget;
import com.example.demo.dao.BookMapper;
import com.example.demo.dao.PeopleMapper;
import com.example.demo.model.Book;
import com.example.demo.model.People;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class controller {
    //aop测试
    @Autowired
    mytarget tar;
    @Autowired
    PeopleMapper people;
    @Autowired
    private Serverproperties duankou;
    @Autowired
    private BookMapper book;
    @Autowired
    private BookService bookService;

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
    public List<Book> mmad(@RequestParam(defaultValue = "1") int pagenum){

        List<Book> pageselect = bookService.pageselect(pagenum);
        System.out.println(pageselect);
        return pageselect;
    }
}
