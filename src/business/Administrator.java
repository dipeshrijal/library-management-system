package business;

public class Administrator extends Person  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Person member;

	public Administrator(String id,String fName, String lName, String phoneNumber, String bio, String street, String city,
			String state, String zip,String password) {
		super(id,fName, lName, phoneNumber, bio, street, city, state, zip,password);
	}
	
	public void addMember(Person person) {
		
	}

	public Person getMember() {
		return member;
	}

	public void setMember(Person member) {
		this.member = member;
	}

}
