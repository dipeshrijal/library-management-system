package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String ISBN;
	private boolean availability;
	private List<BookCopy> copies;
	public void setCopies(List<BookCopy> copies) {
		this.copies = copies;
	}

	private Author author;
	private String borrowabledays;
	
	public Book(String title, String isbn,String id,String fName, String lName, String phoneNumber, String bio, String street, String city, String state,
			String zip, String borrowabledays) {
		this.title=title;
		this.ISBN=isbn;
		this.setBorrowabledays(borrowabledays);
		author= new Author(id,fName, lName, phoneNumber, bio, street, city, state, zip);
		this.copies=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public Author getAuthor() {
		return author;
	}



	public void setAuthor(Author author) {
		this.author = author;
	}



	public Book(String title, String ISBN, boolean availability) {
		this.title = title;
		this.ISBN = ISBN;
		this.availability = availability;

		copies = new ArrayList<BookCopy>();
	}

	

	public String getTitle() {
		return title;
	}

	public String getISBN() {
		return ISBN;
	}

	public boolean isAvailability() {
		return availability;
	}

	public List<BookCopy> getCopies() {
		return copies;
	}

	public String getBorrowabledays() {
		return borrowabledays;
	}

	public void setBorrowabledays(String borrowabledays) {
		this.borrowabledays = borrowabledays;
	}

}
