package dataAccess;

import java.io.IOException;
import java.util.List;

import business.Book;
import business.Person;

public class DaoImpl implements Dao {
	public DBPersonWriter db = new DBPersonWriter();
	public DBBookWriter bookdb = new DBBookWriter();

	@Override
	public void addLibraryMember(Person person) {
		// TODO Auto-generated method stub
		List<Person> persons = db.personReader();
		persons.add(person);
		try {
			db.deleteContentOfFile();
			db.personWriter(persons);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Person login(String id, String password) {
		Person validperson = null;
		List<Person> persons = db.personReader();
		if (persons == null) {
			System.out.println("null from here");
		}
		for (Person p : persons) {
			if (p.getId().equals(id) && p.getPassword().equals(password)) {
				validperson = p;
			}
		}
		return validperson;
	}

	@Override
	public void addBook(Book b) {
		List<Book> books = bookdb.bookReader();
		books.add(b);
		try {
			bookdb.deleteContentOfFile();
			bookdb.bookWriter(books);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book findBook(String isbn) {
		Book b = null;
		List<Book> books = bookdb.bookReader();
		for (Book book : books) {
			if (book.getISBN().equals(isbn)) {
				b = book;
				System.out.println("found the book");
			}
		}
		return b;
	}

	@Override
	public Person findMember(String id) {
		// TODO Auto-generated method stub
		Person p = null;
		List<Person> pers = db.personReader();
		for (Person person : pers) {
			if (person.getId().equals(id)) {
				p = person;
			}
		}
		return p;
	}

	@Override
	public void editPerson(String id, Person toedit) {

		List<Person> pers = db.personReader();
		for (Person person : pers) {
			if (person.getId().equals(id)) {
				pers.remove(person);
				break;
			}
		}
		pers.add(toedit);
		try {
			db.deleteContentOfFile();
			db.personWriter(pers);
			System.out.println("Successfully written to the file");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Person> getAllMembers() {
		// TODO Auto-generated method stub
		return db.personReader();
	}

	@Override
	public Person getbyId(String id) {
		// TODO Auto-generated method stub
		Person p = null;
		List<Person> persons = getAllMembers();
		for (Person person : persons) {
			if (person.getId().equals(id)) {
				p = person;
			}
		}
		return p;
	}

}
