package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="IssueDetails")
public class IssueDetail {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
	private int issueId;
	
	@Column(name="user_id")
    private int userId;
	
	@Column(name="book_id")
    private int bookId;
	
	@Column(name="issue_date")
    private Date issueDate;
	
	@Column(name="return_date")
    private Date returnDate;
    
	public IssueDetail(int issueId, int bookId, int userId, Date issueDate, Date returnDate) {
		super();
		this.issueId = issueId;
		this.userId = userId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}
	
	public int getIssueId() {
		return issueId;
	}
	public int getUserId() {
		return userId;
	}
	public int getBookId() {
		return bookId;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
