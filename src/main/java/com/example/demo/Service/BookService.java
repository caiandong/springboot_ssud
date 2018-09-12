package com.example.demo.Service;

import com.example.demo.MycustomBeanAndTools.GongJu;
import com.example.demo.dao.BookMapper;
import com.example.demo.model.Book;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
@Transactional
public class BookService {
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
    public List<Book> pageselect(int pagenum){
        PageHelper.startPage(pagenum, 6);
        return bookMapper.selectByExample(null);
    }

}
