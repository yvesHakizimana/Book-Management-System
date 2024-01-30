package com.code.empcrud.bookmanagement.webServlets;

import com.code.empcrud.bookmanagement.dao.BookDaoImpl;
import com.code.empcrud.bookmanagement.model.Book;
import com.code.empcrud.bookmanagement.utils.DbConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditBook", value = "/editScreen-book")
public class EditScreenBook extends HttpServlet {
    BookDaoImpl bookDao;
    DbConnection connectionToDb;

    public void init(){
        this.bookDao = new BookDaoImpl();
        this.connectionToDb =  new DbConnection();
    }


    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        // Getting the id passed
        int id = Integer.parseInt(req.getParameter("id"));
        //Fetching the book
        Book book  = bookDao.selectBookByID(id, connectionToDb);
        req.setAttribute("book", book);
        Cookie cookie = new Cookie("id", String.valueOf(id));
        res.addCookie(cookie);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit-book.jsp");
        dispatcher.forward(req,res);
    }
}
