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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "deleteBook", value = "/delete-book")
public class DeleteBook extends HttpServlet {
    BookDaoImpl bookDao;
    DbConnection connectionToDb;
    public void init(){
        this.bookDao = new BookDaoImpl();
        this.connectionToDb = new DbConnection();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean result = bookDao.deleteBookById(id, connectionToDb);
        List<Book> books =  bookDao.selectBooks(connectionToDb);
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book-list.jsp");
        if(result)
            dispatcher.forward(req, res);
        else {
            PrintWriter out = res.getWriter();
            out.println("Error within: .... ");
        }
    }


}
