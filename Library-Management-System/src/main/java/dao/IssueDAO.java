package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.IssueDetail;
import util.DBConnection;

public class IssueDAO {
	// Helper method to check if a book is available
	private boolean isBookAvailable(int bookId) {
		BookDAO bookdao = new BookDAO();
		Book book = bookdao.getBook(bookId);
		System.out.println("Book available?" + book.isAvailable());
		if(book.isAvailable() == true) {
			return true;
		}
		return false;
	}
		
	public boolean issueBook(int bookId, int userId) {
	    // First, check if the book is available (you can uncomment this if needed)
	    if (!isBookAvailable(bookId)) {
	        return false; // Book is not available
	    }

	    String issueSQL = "INSERT INTO IssueDetails (book_id, user_id, issue_date, return_date) VALUES (?, ?, CURRENT_TIMESTAMP, DATE_ADD(CURRENT_TIMESTAMP, INTERVAL 30 DAY))";
	    String updateSQL = "UPDATE Books SET available = 0 WHERE book_id = ?";

	    try (Connection conn = DBConnection.getConnection()) {
	        conn.setAutoCommit(false);

	        try (PreparedStatement issueStmt = conn.prepareStatement(issueSQL);
	             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {

	            issueStmt.setInt(1, bookId);
	            issueStmt.setInt(2, userId);
	            issueStmt.executeUpdate();

	            updateStmt.setInt(1, bookId);
	            updateStmt.executeUpdate();

	            conn.commit();
	            return true; // Successfully issued the book
	        } catch (SQLException e) {
	            conn.rollback();
	            e.printStackTrace();
	            return false; // Error occurred while issuing the book
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; // Error occurred while establishing a connection
	    }
	}

    public List<IssueDetail> getAllIssues() {
        List<IssueDetail> issues = new ArrayList<>();
        String sql = "SELECT * FROM IssueDetails";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int issueId = rs.getInt("issue_id");
                int bookId = rs.getInt("book_id");
                int userId = rs.getInt("user_id");
                Timestamp issueDate = rs.getTimestamp("issue_date");
                Timestamp returnDate = rs.getTimestamp("return_date");

                IssueDetail issue = new IssueDetail(issueId, bookId, userId, issueDate, returnDate);
                issues.add(issue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issues;
    }

    public boolean deleteIssueByIssueId(int issueId) throws SQLException {
        String deleteSql = "DELETE FROM IssueDetails WHERE issue_id = ?";
        String updateBookAvailabilitySql = "UPDATE Books SET available = 1 WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
             PreparedStatement updateStmt = conn.prepareStatement(updateBookAvailabilitySql)) {

            conn.setAutoCommit(false);

            // First, delete the issue
            deleteStmt.setInt(1, issueId);
            int rowsDeleted = deleteStmt.executeUpdate();

            if (rowsDeleted > 0) {
                // If the issue was successfully deleted, update the book's availability
                updateStmt.setInt(1, issueId); // Assuming issueId corresponds to the book_id
                int rowsUpdated = updateStmt.executeUpdate();

                if (rowsUpdated > 0) {
                    conn.commit(); 
                    return true; 
                }
            }

            conn.rollback(); // Rollback the transaction if something went wrong
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Error occurred or no rows affected
    }


}
