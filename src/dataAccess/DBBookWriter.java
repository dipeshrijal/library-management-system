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

import business.Book;

public class DBBookWriter {
	public static final String OUTPUT_DIR = System.getProperty("book.dir") + "book.txt";
	List<Book> book = new ArrayList<>();

	public void bookWriter(List<Book> book) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_DIR);
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			output.writeObject(book);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Book> bookReader() {
		List<Book> returnbooks = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(OUTPUT_DIR));
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			@SuppressWarnings("unchecked")
			List<Book> book = (List<Book>) input.readObject();
			returnbooks = book;
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return returnbooks;
	}

	public void deleteContentOfFile() throws IOException {
		new FileOutputStream(new File(OUTPUT_DIR)).close();
	}
}
