package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<CheckoutEntry> checkoutEntries;
	public List<CheckoutEntry> getCheckoutEntries() {
		return checkoutEntries;
	}

	public void setCheckoutEntries(List<CheckoutEntry> checkoutEntries) {
		this.checkoutEntries = checkoutEntries;
	}

	public CheckoutRecord() {
		checkoutEntries= new ArrayList<>();
	}
	
	private Person member;

	public Person getMember() {
		return member;
	}

	public void setMember(Person member) {
		this.member = member;
	}
	public void addEntries(CheckoutEntry entry)
	{
		checkoutEntries.add(entry);
	}

}
