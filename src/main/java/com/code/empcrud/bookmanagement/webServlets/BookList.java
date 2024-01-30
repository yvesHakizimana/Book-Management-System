package com.code.empcrud.bookmanagement.webServlets;

import com.code.empcrud.bookmanagement.dao.BookDaoImpl;
import com.code.empcrud.bookmanagement.model.Book;
import com.code.empcrud.bookmanagement.utils.DbConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookList", value = "/book-list")
public class BookList extends HttpServlet {

    BookDaoImpl bookDao;
    DbConnection connectionToDb;

    public void init(){
        this.bookDao = new BookDaoImpl();
        this.connectionToDb =  new DbConnection();
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        List<Book> books = new ArrayList<>();
        books = bookDao.selectBooks(connectionToDb);
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book-list.jsp");
        dispatcher.forward(req, res);
    }
}
