package com.example.demo.Controller;


import com.example.demo.Serverproperties;

import com.example.demo.Service.BookService;
import com.example.demo.aop.mytarget;
import com.example.demo.dao.BookMapper;
import com.example.demo.dao.PeopleMapper;
import com.example.demo.model.Book;
import com.example.demo.model.People;

import com.example.demo.model.PeopleExample;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/nihao")
    String mmmmmmm(HttpSession se,@NotNull String username,@NotNull String password){
        PeopleExample peopleExample = new PeopleExample();
        peopleExample.createCriteria().andNameEqualTo(username).andPasswordEqualTo(password);
        if(this.people.selectByExample(peopleExample)!=null)
            se.setAttribute("username",username);
        return "redirect:album";
    }
    @GetMapping("/getimages")
    @ResponseBody
    public Map<String,Object> mmad(@RequestParam(defaultValue = "1") int pagenum){
        Map<String,Object> map=new HashMap<String, Object>();
        List<Book> pageselect = bookService.pageselect(pagenum);
        PageInfo<Book> page = new PageInfo(pageselect,5);
        map.put("list",pageselect);
        map.put("currentnum", page.getPageNum());
        map.put("firstpage", page.getNavigateFirstPage());
        map.put("allpage", page.getPages());
        map.put("allnum", page.getTotal());
        System.out.println(pageselect);
        return map;
    }
}
