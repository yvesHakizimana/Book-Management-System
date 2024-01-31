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
import java.util.List;

@WebServlet(name = "UpdateBook", value = "/update-book")
public class UpdateBook extends HttpServlet {

    DbConnection connectionToDb;
    BookDaoImpl bookDao;

    public void init(){
        this.bookDao = new BookDaoImpl();
        this.connectionToDb = new DbConnection();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        int id = 0;
        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies)
        {
            if(c.getName().equals("id"))
                id = Integer.parseInt(c.getValue());
        }
        String name = req.getParameter("name");
        String edition = req.getParameter("edition");
        int price = Integer.parseInt(req.getParameter("price"));
        bookDao.updateBookById(new Book(id, name, edition, price), connectionToDb);
        List<Book> books =  bookDao.selectBooks(connectionToDb);
        req.setAttribute("books", books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book-list.jsp");
        dispatcher.forward(req, res);
    }

}
