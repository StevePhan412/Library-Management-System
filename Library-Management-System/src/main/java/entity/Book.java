package entity;

import java.util.Objects;

public class Book {
	private int bookId;
    private String title;
    private String author;
    private String isbn;
    private boolean available;
	public int getBookId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getIsbn() {
		return isbn;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public int hashCode() {
		return Objects.hash(author, available, bookId, isbn, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && available == other.available && bookId == other.bookId
				&& Objects.equals(isbn, other.isbn) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", available="
				+ available + "]";
	}

    
}
