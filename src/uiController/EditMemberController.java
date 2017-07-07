package uiController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import business.Member;
import business.Person;
import dataAccess.Dao;
import dataAccess.DaoImpl;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditMemberController {
	
	@FXML
	Button register;

	@FXML
	JFXTextField fName;

	@FXML
	JFXTextField memberid;

	@FXML
	JFXButton search;

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

	

	public void searchMember() {
		String memId = memberid.getText();
		
		if (memId.trim().isEmpty()) {
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);

			VBox vbox = new VBox(new Text("Please Enter Member ID"));
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(70));

			dialogStage.setScene(new Scene(vbox));
			dialogStage.show();
		} else {
			Dao dao = new DaoImpl();
			Person p = dao.findMember(memId);
			
			if (p == null) {
				Stage dialogStage = new Stage();
				dialogStage.initModality(Modality.WINDOW_MODAL);

				VBox vbox = new VBox(new Text("Member Not Found"));
				vbox.setAlignment(Pos.CENTER);
				vbox.setPadding(new Insets(70));

				dialogStage.setScene(new Scene(vbox));
				dialogStage.show();
			} else {
				fName.setText(p.getFirstName());
				lName.setText(p.getLastName());
				street.setText(p.getAddress().getStreet());
				city.setText(p.getAddress().getCity());
				zip.setText(p.getAddress().getZip());
				state.setText(p.getAddress().getState());
				phoneNumber.setText(p.getPhoneNumber());
			}
		}

	}
	
	public void update() {
		if (fName.getText().trim().isEmpty() || lName.getText().trim().isEmpty()
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
			Person person = new Member(memberid.getText(), fName.getText(), lName.getText(), phoneNumber.getText(), null,
					street.getText(), city.getText(), state.getText(), zip.getText());
			dao.editPerson(memberid.getText().trim(), person);
		}
	}

}
