package entity;

import java.util.Date;
import java.util.Objects;

public class IssueDetails {

	private int issueId;
    private int userId;
    private int bookId;
    private Date issueDate;
    private Date returnDate;
    @Override
	public String toString() {
		return "IssueDetails [issueId=" + issueId + ", userId=" + userId + ", bookId=" + bookId + ", fineAmount="
				+ fineAmount + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookId, fineAmount, issueId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueDetails other = (IssueDetails) obj;
		return bookId == other.bookId
				&& Double.doubleToLongBits(fineAmount) == Double.doubleToLongBits(other.fineAmount)
				&& issueId == other.issueId && userId == other.userId;
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
	public Date getDueDate() {
		return dueDate;
	}
	public double getFineAmount() {
		return fineAmount;
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
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}
	private Date dueDate;
    private double fineAmount;

}
