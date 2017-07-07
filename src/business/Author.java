package business;

public class Author extends Person {

	public Author(String id,String fName, String lName, String phoneNumber, String bio, String street, String city, String state,
			String zip) {
		super(id,fName, lName, phoneNumber, bio, street, city, state, zip,null);
	}

}
