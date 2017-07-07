package business;

import java.io.Serializable;

public class BookCopy implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public BookCopy(Book book, String copybookId, boolean isAvailable) {
		this.book=book;
		this.setCopybookId(copybookId);
		this.available=isAvailable;
		// TODO Auto-generated constructor stub
	}

	private Book book;
	private String copybookId;
	private boolean available;
	


	public boolean isAvailable() {
		return available;
	}



	public void setAvailable(boolean available) {
		this.available = available;
	}



	public Book getBook() {
		return book;
	}

	

	public void setBook(Book book) {
		this.book = book;
	}



	public String getCopybookId() {
		return copybookId;
	}



	public void setCopybookId(String copybookId) {
		this.copybookId = copybookId;
	}

	

}
