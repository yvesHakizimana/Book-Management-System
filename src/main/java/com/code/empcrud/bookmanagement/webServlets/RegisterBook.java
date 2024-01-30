package com.code.empcrud.bookmanagement.webServlets;

import com.code.empcrud.bookmanagement.dao.BookDaoImpl;
import com.code.empcrud.bookmanagement.model.Book;
import com.code.empcrud.bookmanagement.utils.DbConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerBook", value = "/register-book")
public class RegisterBook extends HttpServlet {

    BookDaoImpl bookDao;
    DbConnection connectionToDb;

    public void init(){
        this.bookDao  = new BookDaoImpl();
        this.connectionToDb = new DbConnection();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        String bookName = req.getParameter("name");
        String bookEdition = req.getParameter("edition");
        int price = Integer.parseInt(req.getParameter("price"));
        Book newBook = new Book(bookName, bookEdition, price);

        boolean result = bookDao.insertBook(newBook, connectionToDb);
        PrintWriter out =  res.getWriter();
        if(result)
            res.sendRedirect("book-list");
        else
            out.println("Sorry our there is the error in the request");
    }
}
