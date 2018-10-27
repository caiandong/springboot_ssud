package com.example.demo.model;

public class Book {
    private Integer id;

    private String bookname;

    private Integer hasnumber;

    private Integer readcount;

    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", hasnumber=" + hasnumber +
                ", readcount=" + readcount +
                ", author='" + author + '\'' +
                ", picturename='" + picturename + '\'' +
                ", bookdescribe='" + bookdescribe + '\'' +
                '}';
    }

    private String picturename;

    private String bookdescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Integer getHasnumber() {
        return hasnumber;
    }

    public void setHasnumber(Integer hasnumber) {
        this.hasnumber = hasnumber;
    }

    public Integer getReadcount() {
        return readcount;
    }

    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename == null ? null : picturename.trim();
    }

    public String getBookdescribe() {
        return bookdescribe;
    }

    public void setBookdescribe(String bookdescribe) {
        this.bookdescribe = bookdescribe == null ? null : bookdescribe.trim();
    }
}