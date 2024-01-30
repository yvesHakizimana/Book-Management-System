package com.code.empcrud.bookmanagement.model;

public class Book {
    private long id;
    private String bookName;
    private String bookEdition;
    private int bookPrice;
    public Book(long id, String bkName, String bkEdition, int bkPrice){
        this.id = id;
        this.bookName = bkName;
        this.bookEdition = bkEdition;
        this.bookPrice = bkPrice;
    }

    public Book(String bkName, String bkEdition, int bkPrice){
        this.bookName = bkName;
        this.bookEdition = bkEdition;
        this.bookPrice = bkPrice;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }




}
