package business;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableConverter {
	private SimpleStringProperty item;
	private SimpleStringProperty doc;
	private SimpleStringProperty dueDate;
	private SimpleBooleanProperty available;
	
	public TableConverter(String item, String doc, String dueDate,boolean available) {
     this.item= new SimpleStringProperty(item);
     this.doc=new SimpleStringProperty(doc);
     this.dueDate= new SimpleStringProperty(dueDate);
     this.available=new SimpleBooleanProperty(available);
	}
	public boolean isAvailable() {
		return available.get();
	}
	public void setAvailable(boolean available) {
		this.available.set(available);
	}
	public String getItem() {
		return item.get();
	}
	public void setItem(String item) {
		this.item.set(item);
	}
	public String getDoc() {
		return doc.get();
	}
	public void setDoc(String doc) {
		this.doc.set(doc);
	}
	public String getDueDate() {
		return dueDate.get();
	}
	public void setDueDate(String dueDate) {
		this.dueDate.set(dueDate);
	}
	
	

}
