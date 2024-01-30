package com.code.empcrud.bookmanagement.dao;

import com.code.empcrud.bookmanagement.model.Book;
import com.code.empcrud.bookmanagement.utils.DbConnection;

import java.util.List;

public interface bookDao {
    boolean insertBook(Book book, DbConnection connection) ;
    List<Book> selectBooks(DbConnection connection);
    Book selectBookByID(long id, DbConnection connection);

    int updateBookById(Book book, DbConnection connection);

    boolean deleteBookById(long id , DbConnection connection);

}
