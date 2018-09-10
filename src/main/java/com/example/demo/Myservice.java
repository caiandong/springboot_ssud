package com.example.demo;

import com.example.demo.MycustomBeanAndTools.GongJu;
import com.example.demo.dao.BookMapper;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.OutputStream;

@Service
@Transactional
public class Myservice {
    @Autowired
    private BookMapper bookMapper;
    public int insertbook(Book book, Part part, OutputStream out,int width,int height)throws IOException {
        int insert = bookMapper.insert(book);
        GongJu.ChangeImageSize(part.getInputStream(),out,width,height );

        return insert;
    }
    public int insertbook(Book book){
        return bookMapper.insertSelective(book);
    }

}
