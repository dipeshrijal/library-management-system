package uiController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import business.CheckoutEntry;
import business.Member;
import business.Person;
import business.TableConverter;
import dataAccess.Dao;
import dataAccess.DaoImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class CheckoutViewController implements Initializable {

	@FXML
	Pane viewcheckout_pane;

	@FXML
	TableView<TableConverter> table_pane;

	@FXML
	JFXTextField memberid;

	@FXML
	Button viewCheckout;

	@FXML
	TableColumn<TableConverter, String> item;

	@FXML
	TableColumn<TableConverter, String> doc;
	@FXML
	TableColumn<TableConverter, String> dueDate;
	@FXML
	TableColumn<TableConverter, Boolean> available;

	public void viewCheckout() {
		ObservableList<TableConverter> data = FXCollections.observableArrayList();
		table_pane.getColumns().clear();
		data.addAll(Yo());
		List<TableConverter> getTableitems = Yo();
		item.setCellValueFactory(new PropertyValueFactory<TableConverter, String>("item"));
		doc.setCellValueFactory(new PropertyValueFactory<TableConverter, String>("doc"));
		dueDate.setCellValueFactory(new PropertyValueFactory<TableConverter, String>("dueDate"));
		available.setCellValueFactory(new PropertyValueFactory<TableConverter, Boolean>("available"));

		table_pane.getColumns().addAll(item, doc, dueDate, available);
		table_pane.setItems(data);

	}

	public List<TableConverter> Yo() {
		List<TableConverter> tables = new ArrayList<>();
		Dao dao = new DaoImpl();
		Person p = dao.getbyId(memberid.getText());
		List<CheckoutEntry> checkoutEntries = new ArrayList<>();
		if (p instanceof Member) {
			System.out.println("instance of member");
			Member m = (Member) p;

			for (CheckoutEntry entries : m.getCheckoutRecord().getCheckoutEntries()) {
				TableConverter converter = new TableConverter(entries.getBook().getBook().getTitle(),
						entries.getCheckoutDate().toString(), entries.getDueDate().toString(),
						entries.getBook().isAvailable());
				tables.add(converter);
				/*
				 * TableConverter table= new TableConverter();
				 * System.out.println("for checkout: "+entries.getBook().getBook().getTitle());
				 * table.setItem(entries.getBook().getBook().getTitle());
				 * table.setDoc(entries.getCheckoutDate().toString());
				 * table.setDueDate(entries.getDueDate().toString());
				 * table.setAvailable(entries.getBook().isAvailable());
				 */

			}

		}
		return tables;

	}
	/*
	 * public void viewCheckout(List<TableConverter> conv) { List<TableConverter>
	 * getTableitems=yo(); item.setCellValueFactory(new
	 * PropertyValueFactory<TableConverter, String>("item"));
	 * doc.setCellValueFactory(new
	 * PropertyValueFactory<TableConverter,String>("doc"));
	 * dueDate.setCellValueFactory(new
	 * PropertyValueFactory<TableConverter,String>("dueDate"));
	 * available.setCellValueFactory(new
	 * PropertyValueFactory<TableConverter,Boolean>("available"));
	 * 
	 * table_pane.getItems().addAll(getTableitems); }
	 */

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/*
		 * item.setCellValueFactory(new PropertyValueFactory<TableConverter,
		 * String>("item")); doc.setCellValueFactory(new
		 * PropertyValueFactory<TableConverter,String>("doc"));
		 * dueDate.setCellValueFactory(new
		 * PropertyValueFactory<TableConverter,String>("dueDate"));
		 * available.setCellValueFactory(new
		 * PropertyValueFactory<TableConverter,Boolean>("available"));
		 * 
		 * table_pane.getItems().addAll(viewCheckout());
		 */
	}

}
