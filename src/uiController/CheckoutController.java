package uiController;

import java.io.IOException;
import java.time.LocalDate;

import business.Book;
import business.BookCopy;
import business.CheckoutEntry;
import business.CheckoutRecord;
import business.Member;
import business.Person;
import dataAccess.Dao;
import dataAccess.DaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CheckoutController {
	
	@FXML
	Pane checkoutbook_pane;
	
	@FXML
	Button backButton;
	
	@FXML
	TextField id;
	
	@FXML
	TextField isbn;
	
	@FXML
	Button checkoutSearchBtn;
	
	@FXML
	Label errorMessage;
	
	private Dao dao= new DaoImpl();
	
	public void search() throws IOException
	{
		Person member=dao.findMember(id.getText());
		Book book=dao.findBook(isbn.getText());
		
		if(member==null && book==null)
		{
			errorMessage.setText("Couldnot find member and book");
		}
		else if(member==null)
		{
			errorMessage.setText("Could not find the member");
		}
		else if(book==null)
		{
			errorMessage.setText("Book not found");
		}
		else
		{
			Member mem=(Member) member;
			CheckoutRecord record= new CheckoutRecord();
			String brrowabledays=book.getBorrowabledays();
			int days=Integer.parseInt(brrowabledays);
			//System.out.println("days"+days);
			LocalDate today= LocalDate.now();
			LocalDate dueDate=today.plusDays(days);
			//System.out.println("the due date"+dueDate.toString());
			//System.out.println("NewDate"+duedate.plusDays(2));
			BookCopy bookCopy= null;
			for(BookCopy copy:book.getCopies())
			{
				if(copy.isAvailable()==true)
				{
					copy.setAvailable(false);
					bookCopy=copy;
					break;
				}
			}
			//dao.addBook(book);
			
			CheckoutEntry entry= new CheckoutEntry(bookCopy, LocalDate.now(),dueDate);
			record.addEntries(entry);
			mem.setCheckoutRecord(record);
			dao.editPerson(mem.getId(), mem);
			Stage previous= (Stage) checkoutbook_pane.getScene().getWindow();
		    Stage stage= new Stage();
		    Parent root=FXMLLoader.load(getClass().getResource("../application/viewCheckout.fxml"));
		    Scene scene = new Scene(root);
		    stage.setScene(scene);
		    stage.show();
		   // previous.hide();
		}
	}
	

}
