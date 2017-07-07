package uiController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import business.AuthorizationLevel;
import business.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AfterLoginController implements Initializable {
	@FXML
	Button addLibraryMember;

	@FXML
	Button vBook;

	@FXML
	Button addBookToCollection;

	@FXML
	Button checkoutBook;

	@FXML
	Button addCopy;

	@FXML
	Button editLibraryMember;

	@FXML
	AnchorPane pane;

	private Person person;

	public AfterLoginController() {
		// TODO Auto-generated constructor stub
	}

	public void initiliazaData(Person person) {
		this.person = person;
		if (person == null) {
			System.out.println("person is null");
		}

		if (person.getAuthorizationLevel().equals(AuthorizationLevel.ADMIN)) {
			checkoutBook.setVisible(false);
		} else if (person.getAuthorizationLevel().equals(AuthorizationLevel.LIBRARIAN)) {
			addLibraryMember.setVisible(false);
			editLibraryMember.setVisible(false);
			addBookToCollection.setVisible(false);
			addCopy.setVisible(false);
		}

	}

	public void addLibraryMember() throws IOException {
		// Stage previous = (Stage) pane.getScene().getWindow();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../application/RegisterMember.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		// previous.hide();

	}

	public void checkoutBook() throws IOException {
		// Stage previous = (Stage) pane.getScene().getWindow();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../application/CheckoutForm.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		// previous.hide();

	}

	public void addBook() throws IOException {
		// Stage previous = (Stage) pane.getScene().getWindow();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../application/AddBook.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		// previous.hide();

	}

	public void editMember() throws IOException {
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../application/EditMember.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void addBookCopy() throws IOException {
		//Stage previous = (Stage) pane.getScene().getWindow();
		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("../application/BookCopy.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		//previous.hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
