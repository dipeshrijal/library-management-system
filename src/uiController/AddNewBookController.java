package uiController;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import business.Book;
import dataAccess.Dao;
import dataAccess.DaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddNewBookController implements Initializable {

	@FXML
	Button addBook;
	@FXML
	JFXTextField title;
	@FXML
	JFXTextField id;
	@FXML
	JFXTextField isbn;
	@FXML
	JFXTextField borrowabledays;
	@FXML
	JFXTextField fName;
	@FXML
	JFXTextField lName;
	@FXML
	JFXTextField street;
	@FXML
	JFXTextField city;
	@FXML
	JFXTextField state;
	@FXML
	JFXTextField zip;
	@FXML
	JFXTextField phoneNumber;
	@FXML
	JFXTextField bio;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void addNewBook() {

		if (title.getText().trim().isEmpty() || isbn.getText().trim().isEmpty() || id.getText().trim().isEmpty()
				|| fName.getText().trim().isEmpty() || lName.getText().trim().isEmpty()
				|| phoneNumber.getText().trim().isEmpty() || bio.getText().trim().isEmpty()
				|| street.getText().trim().isEmpty() || city.getText().trim().isEmpty()
				|| state.getText().trim().isEmpty() || zip.getText().trim().isEmpty()
				|| borrowabledays.getText().trim().isEmpty()) {
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);

			VBox vbox = new VBox(new Text("Please Check all fields"));
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(70));

			dialogStage.setScene(new Scene(vbox));
			dialogStage.show();
		} else {
			Book b = new Book(title.getText(), isbn.getText(), id.getText(), fName.getText(), lName.getText(),
					phoneNumber.getText(), bio.getText(), street.getText(), city.getText(), state.getText(),
					zip.getText(), borrowabledays.getText());
			Dao dao = new DaoImpl();
			dao.addBook(b);
		}

	}

	/*
	 * public void returnBack() throws IOException{ Stage current = (Stage)
	 * newbook_pane.getScene().getWindow(); Stage stage = new Stage(); Parent root =
	 * FXMLLoader.load(getClass().getResource("\\..\\application\\AfterLogin.fxml"))
	 * ; Scene scene = new Scene(root); stage.setScene(scene);
	 * stage.setTitle("Library Management System || Dashboard"); stage.show();
	 * current.hide(); }
	 */

}
