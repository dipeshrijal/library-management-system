package business;

public class Member extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CheckoutRecord checkoutRecord;

	public Member(String id,String fName,String lName, String phoneNumber, String bio,String street, String city,
			String state, String zip) {
		super(id,fName,lName, phoneNumber, bio, street, city, state, zip,null);
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
		this.checkoutRecord = checkoutRecord;
	}

	

}
