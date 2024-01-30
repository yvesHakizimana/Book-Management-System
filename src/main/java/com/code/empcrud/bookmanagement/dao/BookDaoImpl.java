package com.code.empcrud.bookmanagement.dao;

import com.code.empcrud.bookmanagement.model.Book;
import com.code.empcrud.bookmanagement.utils.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements bookDao {

    DbConnection connection = new DbConnection();
    private  static String INSERT_BOOK_SQL = "INSERT INTO bookTable (name , edition, price) VALUES  " + " (?, ? , ?);";
    private static  String SELECT_ALL_SQL = "SELECT name , edition, price FROM bookTable;";
    private static String SELECT_BOOK_BY_ID = "SELECT name , edition, price FROM bookTable where id = ?;";
    private static String UPDATE_BOOK_BY_ID = "UPDATE bookTable set name = ? , edition = ? , price = ? where id = ? ;";
    private static String DELETE_BY_ID = "DELETE FROM bookTable where id = ?;";


    @Override
    public void insertBook(Book book, DbConnection connection)  {
        try(PreparedStatement statement = connection.connectToDb().prepareStatement(INSERT_BOOK_SQL);){
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getBookEdition());
            statement.setInt(3, book.getBookPrice());
            int result = statement.executeUpdate();
            if(result == 1) System.out.println("The record registered successfully");
            else System.out.println("The record is not registered successfully");

        } catch(SQLException ex){
            System.out.println("SQLState: " + ex.getErrorCode());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            System.out.println("Message: " + ex.getMessage());
        }
    }

    @Override
    public List<Book> selectBooks(DbConnection connection) {
        List<Book> books = new ArrayList<>();
        try(PreparedStatement statement = connection.connectToDb().prepareStatement(SELECT_ALL_SQL)){
            ResultSet results = statement.executeQuery();
            while(results.next()){
                String name = results.getString("name");
                String edition = results.getString("edition");
                int price = results.getInt("price");
                books.add(new Book(name, edition, price));
            }

        } catch (SQLException ex){
            System.out.println("SQLState: " + ex.getErrorCode());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            System.out.println("Message: " + ex.getMessage());
        }

        return books;
    }

    @Override
    public Book selectBookByID(long id, DbConnection connection) {
        Book book = null;
        try(PreparedStatement statement = connection.connectToDb().prepareStatement(SELECT_BOOK_BY_ID)){
            statement.setLong(1,id);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String name = result.getString(1);
                String edition = result.getString(2);
                int price = result.getInt(3);
                book = new Book(name , edition, price);
            }

        } catch(SQLException ex){
            System.out.println("SQLState: " + ex.getErrorCode());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            System.out.println("Message: " + ex.getMessage());
        }
        return book;
    }

    @Override
    public int updateBookById(Book book, DbConnection connection) {
        int result = 0;
        try(PreparedStatement statement = connection.connectToDb().prepareStatement(UPDATE_BOOK_BY_ID)){
            statement.setString(1, book.getBookName());
            statement.setString(2, book.getBookEdition());
            statement.setInt(3, book.getBookPrice());
            statement.setLong(4, book.getId());

            result = statement.executeUpdate();
            if(result == 1)
                System.out.println("The book updated successfully");
            else
                System.out.println("The book was not updated at all.");


        } catch(SQLException ex){
            System.out.println("SQLState: " + ex.getErrorCode());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            System.out.println("Message: " + ex.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteBookById(long id, DbConnection connection) {
        boolean rowDeleted = false;
        try(PreparedStatement statement = connection.connectToDb().prepareStatement(DELETE_BY_ID);){
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
            if(rowDeleted)
                System.out.println("The book deleted successfully");
            else
                System.out.println("The book was not deleted...");

        } catch(SQLException ex){
            System.out.println("SQLState: " + ex.getErrorCode());
            System.out.println("ErrorCode: " + ex.getErrorCode());
            System.out.println("Message: " + ex.getMessage());
        }
        return rowDeleted;
    }
}
