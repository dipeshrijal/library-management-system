package uiController;

import java.util.List;

import com.jfoenix.controls.JFXTextField;

import business.Book;
import business.BookCopy;
import dataAccess.Dao;
import dataAccess.DaoImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class BookCopyController {

	@FXML
	Pane bookcopy_pane;

	@FXML
	JFXTextField isbn;

	@FXML
	TextField id;

	@FXML
	Button addBook;

	@FXML
	Button searchButton;

	@FXML
	Label error;

	@FXML
	Label title;

	@FXML
	Label author;

	@FXML
	Label giveid;

	Book book;

	public void addNewBook() {
		System.out.println(id.getText());
	Dao daoimpl = new DaoImpl();
		BookCopy copy = new BookCopy(book, id.getText(), true);
		List<BookCopy> bookcopies = book.getCopies();
		bookcopies.add(copy);
		book.setCopies(bookcopies);
		daoimpl.addBook(book);

	}

	public Book searchBook() {
		Dao dao = new DaoImpl();
		Book book = dao.findBook(isbn.getText());
		if (book == null) {
			error.setText("The Book with ISBN: " + isbn.getText() + " " + " is not available");
		} else {
			title.setText("Book Name: " + book.getTitle());
			author.setText("Book Author: " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName());
			giveid.setText("Enter  Id");
			addBook.setVisible(true);
			id.setVisible(true);
		}
		this.book = book;
		return book;

	}

}
