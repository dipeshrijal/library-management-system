package uiController;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import business.Member;
import business.Person;
import dataAccess.Dao;
import dataAccess.DaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegisterMemberController implements Initializable {

	@FXML
	Button register;

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
	JFXTextField id;

	@FXML
	Pane pane;

	public RegisterMemberController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void register() {
		if (id.getText().trim().isEmpty() || fName.getText().trim().isEmpty() || lName.getText().trim().isEmpty()
				|| phoneNumber.getText().trim().isEmpty() || street.getText().trim().isEmpty()
				|| city.getText().trim().isEmpty() || state.getText().trim().isEmpty()
				|| zip.getText().trim().isEmpty()) {
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);

			VBox vbox = new VBox(new Text("Please Check all fields"));
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(70));

			dialogStage.setScene(new Scene(vbox));
			dialogStage.show();

		} else {
			Dao dao = new DaoImpl();
			Person person = new Member(id.getText(), fName.getText(), lName.getText(), phoneNumber.getText(), null,
					street.getText(), city.getText(), state.getText(), zip.getText());
			dao.addLibraryMember(person);
		}
	}

}
