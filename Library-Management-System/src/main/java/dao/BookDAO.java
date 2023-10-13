package dao;

import entity.Book;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	 public Book getBook(int bookId) {
	     Book book = null;
	     String sql = "SELECT * FROM Books WHERE book_id = ?";
	     try (Connection conn = DBConnection.getConnection();
	          PreparedStatement stmt = conn.prepareStatement(sql)) {
	         stmt.setInt(1, bookId);
	         ResultSet rs = stmt.executeQuery();
	         if (rs.next()) {
	             book = new Book();
	             book.setBookId(rs.getInt("book_id"));
	             book.setTitle(rs.getString("title"));
	             book.setAuthor(rs.getString("author"));
	             book.setIsbn(rs.getString("isbn"));
	             book.setAvailable(rs.getBoolean("available"));
	         }
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	     return book;
	 }
	
	 public List<Book> getBooks() {
	     List<Book> books = new ArrayList<>();
	     String sql = "SELECT * FROM Books";
	     try (Connection conn = DBConnection.getConnection();
	          PreparedStatement stmt = conn.prepareStatement(sql)) {
	         ResultSet rs = stmt.executeQuery();
	         while (rs.next()) {
	             Book book = new Book();
	             book.setBookId(rs.getInt("book_id"));
	             book.setTitle(rs.getString("title"));
	             book.setAuthor(rs.getString("author"));
	             book.setIsbn(rs.getString("isbn"));
	             book.setAvailable(rs.getBoolean("available"));
	             books.add(book);
	         }
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	     return books;
	 }
	
	 public boolean createBook(Book book) {
	     String sql = "INSERT INTO Books (title, author, isbn, available) VALUES (?, ?, ?, ?)";
	     try (Connection conn = DBConnection.getConnection();
	          PreparedStatement stmt = conn.prepareStatement(sql)) {
	         stmt.setString(1, book.getTitle());
	         stmt.setString(2, book.getAuthor());
	         stmt.setString(3, book.getIsbn());
	         stmt.setBoolean(4, true);
	         return stmt.executeUpdate() > 0;
	     } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
	
	 public boolean updateBook(Book book) {
	     String sql = "UPDATE Books SET title = ?, author = ?, isbn = ?, available = ? WHERE book_id = ?";
	     try (Connection conn = DBConnection.getConnection();
	          PreparedStatement stmt = conn.prepareStatement(sql)) {
	         stmt.setString(1, book.getTitle());
	         stmt.setString(2, book.getAuthor());
	         stmt.setString(3, book.getIsbn());
	         stmt.setBoolean(4, book.isAvailable());
	         stmt.setInt(5, book.getBookId());
	         return stmt.executeUpdate() > 0;
	     } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
	
	 public boolean deleteBook(int bookId) {
	     String sql = "DELETE FROM Books WHERE book_id = ?";
	     try (Connection conn = DBConnection.getConnection();
	          PreparedStatement stmt = conn.prepareStatement(sql)) {
	         stmt.setInt(1, bookId);
	         return stmt.executeUpdate() > 0;
	     } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	     }
	 }
 }
