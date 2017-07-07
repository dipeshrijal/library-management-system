package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookCopy book;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	public CheckoutEntry(BookCopy book, LocalDate checkoutDate, LocalDate dueDate) {
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.book=book;
	}

	public BookCopy getBook() {
		return book;
	}

	public void setBook(BookCopy book) {
		this.book = book;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

}
