package uiController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import business.Person;
import dataAccess.Dao;
import dataAccess.DaoImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	Button loginButton;

	@FXML
	JFXTextField userName;

	@FXML
	JFXPasswordField password;

	@FXML
	AnchorPane pane;

	private Dao dao = new DaoImpl();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void loginMethod() throws IOException {
		Person person = dao.login(userName.getText(), password.getText());

		if (person == null) {
			Stage dialogStage = new Stage();
			dialogStage.initModality(Modality.WINDOW_MODAL);

			VBox vbox = new VBox(new Text("Please Check your username and password"));
			vbox.setAlignment(Pos.CENTER);
			vbox.setPadding(new Insets(70));

			dialogStage.setScene(new Scene(vbox));
			dialogStage.show();
		} else {
			Stage previous = (Stage) pane.getScene().getWindow();
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/AfterLogin.fxml"));
			Parent root = loader.load();
			AfterLoginController afterLoginController = loader.getController();
			afterLoginController.initiliazaData(person);

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			previous.hide();
		}
	}

}
