package dataAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import business.Person;

public class DBPersonWriter {

	public static final String OUTPUT_DIR = System.getProperty("user.txt") + "user.txt";
	List<Person> person = new ArrayList<>();

	public void personWriter(List<Person> user) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_DIR);
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			output.writeObject(user);
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Person> personReader() {
		List<Person> returnPersons = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(OUTPUT_DIR));
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			@SuppressWarnings("unchecked")
			List<Person> person = (List<Person>) input.readObject();
			returnPersons = person;
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return returnPersons;
	}

	public void deleteContentOfFile() throws IOException {
		new FileOutputStream(new File(OUTPUT_DIR)).close();
	}

}
