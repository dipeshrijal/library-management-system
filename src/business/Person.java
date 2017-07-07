package business;

import java.io.Serializable;
import java.util.List;

public abstract class Person implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String password;
	private String bio;
	private Address address;
	private Role role;
	private AuthorizationLevel authorizationLevel;

	

	public Person(String id,String fName, String lName, String phoneNumber, String bio, String street, String city, String state,
			String zip,String password) {
		firstName = fName;
		lastName = lName;
		this.phoneNumber = phoneNumber;
		this.bio = bio;
		this.id=id;
		this.password=password;
		address = new Address(street, city, state, zip);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	

	public String getPassword() {
		return password;
	}

	public String getBio() {
		return bio;
	}

	public AuthorizationLevel getAuthorizationLevel() {
		return authorizationLevel;
	}

	public void setAuthorizationLevel(AuthorizationLevel authorizationLevel) {
		this.authorizationLevel = authorizationLevel;
	}

	

}
