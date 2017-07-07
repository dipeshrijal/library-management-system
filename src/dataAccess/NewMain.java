package dataAccess;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import business.Administrator;
import business.AuthorizationLevel;
import business.Book;
import business.BookCopy;
import business.Librarian;
import business.Member;
import business.Person;

public class NewMain {

	public static void main(String[] args) throws IOException {
		Administrator admin = new Administrator("1", "Admin", "Admin", "1234567890", "I am admin", "1000 N 4th Street",
				"Fairfield", "Iowa", "52557", "root");
		admin.setAuthorizationLevel(AuthorizationLevel.ADMIN);
		Librarian librarian = new Librarian("2", "Librarian", "Librarian", "1234567890", "I am librariab",
				"1000 N 4th Street", "Fairfield", "Iowa", "52557", "root");
		librarian.setAuthorizationLevel(AuthorizationLevel.LIBRARIAN);
		
		Administrator both = new Administrator("3", "Both", "Both", "1234567890", "I am admin", "1000 N 4th Street",
				"Fairfield", "Iowa", "52557", "root");
		both.setAuthorizationLevel(AuthorizationLevel.BOTH);

		Member member = new Member("4", "Member1", "Member", "1234567890", "I am member 1", "1000N", "Chichago",
				"Illonois", "56778");

		Book book = new Book("Java 8", "11111", "5", "Dipesh", "Rijal", "1234567890", "I am author", "100N", "New York",
				"New York", "1000", "12");
		BookCopy copy1 = new BookCopy(book, "1", true);
		BookCopy copy2 = new BookCopy(book, "2", true);
		List<BookCopy> bookcopies = new ArrayList<>();
		bookcopies.add(copy1);
		bookcopies.add(copy2);
		book.setCopies(bookcopies);
		List<Book> arraybook = new ArrayList<Book>();
		arraybook.add(book);

		List<Person> person = new ArrayList<>();
		person.add(admin);
		person.add(member);
		person.add(librarian);
		person.add(both);
		DBPersonWriter write = new DBPersonWriter();
		DBBookWriter books = new DBBookWriter();
		books.bookWriter(arraybook);
		books.bookReader();
		write.personWriter(person);
		write.personReader();
//		 write.deleteContentOfFile();
//		 books.deleteContentOfFile();

		System.out.println("After...................");

		// write.deleteContentOfFile();
		/*
		 * Dao dao= new DaoImpl(); dao.addLibraryMember(new Author("bimarsh", "Neupane",
		 * 908, "lala", "hey", "yes", "ia", 52557)); write.personReader();
		 * System.out.println("deleting files.........");
		 */
		/*
		 * try { write.deleteContentOfFile(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * System.out.println("displaying........"); write.personReader();
		 */

	}

}
