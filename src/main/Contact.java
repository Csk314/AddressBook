package main;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	private String name;
	private String organisation;
	private List<PhoneNumber> phoneNumList = new ArrayList<PhoneNumber>();
	private List<Address> addressList = new ArrayList<Address>();

	public void setOrganisation(String organisation) throws LengthException {

		if (organisation.length() <= 255) {
			this.organisation = organisation;
		} else {
			throw new LengthException("Invalid organisation name, length should be in the range of (0..255)");
		}
	}

	public void setName(String name) throws LengthException {
		if (name.length() != 0 && name.length() <= 255) {
			this.name = name;
		} else {
			throw new LengthException("Invalid name, length should be in the range of (1..255)");
		}
	}

	// added setters
	public String getName() {
		return name;
	}

	public String getOrganisation() {
		return organisation;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumList;
	}

	public List<Address> getAddresses() {
		return addressList;
	}

	public void addPhoneNumber(PhoneNumber number) {
		phoneNumList.add(number);
	}

	public void addAddress(Address addres) {
		addressList.add(addres);
	}

//	public void setOrganisation(String organisation) {
//	this.organisation = organisation;
//}

//public void setName(String name) {
//this.name = name;
//}

//public void setPhoneNumList(List<PhoneNumber> phoneNumList) {
//this.phoneNumList = phoneNumList;
//}
//	public void setAddressList(List<Address> addressList) {
//		this.addressList = addressList;
//	}

}
