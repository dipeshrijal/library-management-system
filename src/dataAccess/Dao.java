package dataAccess;

import java.util.List;

import business.Book;
import business.Person;

public interface Dao {
	
	public void addLibraryMember(Person person);
	public Person login(String id, String password);
	public void addBook(Book b);
	public Book findBook(String isbn);
	public Person findMember(String id);
	public void editPerson(String id, Person person);
	public List<Person> getAllMembers();
	public Person getbyId(String id);
	

}
