package main;

import java.util.List;

public class AddressBookDemo {
	static void printList(List<Contact> list) {
		for (Contact i : list) {
			System.out.println("Name: " + i.getName() + " Organisation: " + i.getOrganisation());
			System.out.println(i.getAddresses().toString());
			System.out.println(i.getPhoneNumbers().toString());

			System.out.println();

		}

	}

	public static void main(String[] args) throws LengthException {

		try {
			PhoneNumber p1 = new PhoneNumber();
			p1.setLabel("Work");
			p1.setPhoneNumber("9493884364");

			PhoneNumber p2 = new PhoneNumber();
			p2.setLabel("Home");
			p2.setPhoneNumber("9988772211");

			Address a1 = new Address();
			a1.setLabel("Home");
			a1.setAddress("4th Cross,Bangalore,560029");

			Address a2 = new Address();
			a2.setLabel("Office");
			a2.setAddress("Richmond Road,Bangalore,560025");

			Contact c1 = new Contact();
			c1.setName("Chandra sekhar");
			c1.setOrganisation("Maveric Systems Limited");
			c1.addAddress(a1);
			c1.addAddress(a2);
			c1.addPhoneNumber(p2);
			c1.addPhoneNumber(p1);

			PhoneNumber p3 = new PhoneNumber();
			p3.setLabel("Work");
			p3.setPhoneNumber("7722889911");
			PhoneNumber p4 = new PhoneNumber();
			p4.setLabel("Home");
			p4.setPhoneNumber("9938772211");

			Address a3 = new Address();
			a3.setLabel("Home");
			a3.setAddress("DLF,West Delhi, Delhi – 110059");

			Address a4 = new Address();
			a4.setLabel("Office");
			a4.setAddress("Church Street, Bengaluru, KarnaTaka 560001");

			Contact c2 = new Contact();
			c2.setName("Virat Kohli");
			c2.setOrganisation("Royal Challengers Bangalore");
			c2.addAddress(a3);
			c2.addAddress(a4);
			c2.addPhoneNumber(p3);
			c2.addPhoneNumber(p4);

			// adding to addressbook
			AddressBook addressBook = new AddressBook();
			addressBook.addContact(c1);
			addressBook.addContact(c2);

			// Printing All the Contacts present in the List
			List<Contact> contactList = addressBook.contactList;
			System.out.println("------------Printing All the Contacts present in the List-------------");
			System.out.println(" ");
			printList(contactList);

			/*
			 * Calling all Methods and checking the functionality searchByName()
			 * searchByOrganisation() updateContact() deleteContact()
			 *
			 *
			 */
			System.out.println("-----------------Calling method searchByName(\"Chand\")-------------------");

			List<Contact> filteredList = addressBook.searchByName("Chand");

			printList(filteredList);

			System.out.println("-----------------Calling method searchByOrganisation(\"Royal\")-------------------");
			List<Contact> filteredList1 = addressBook.searchByOrganisation("Royal");
			printList(filteredList1);

			System.out.println(
					"-----------------Calling method to update name to Virat Kohli on c2 contact updateContact(\"Virat Kohli\", c2)-------------------");

			try {
				addressBook.updateContact("Virat Kohli", c2); // should throw exception

			} catch (Exception e) {
				System.out.println(e);

			}

			System.out.println(
					"\n-----------------Calling method to update name to Virat Kohli on c2 contact updateContact(\"KING\", c2)-------------------");

			addressBook.updateContact("KING", c2); // works
			System.out
					.println("-----------------------------After Updating  Virat Kohli to KING----------------------");
			System.out.println();
			printList(addressBook.contactList);

			System.out.println(
					"\n-----------------Calling method to delete contact deleteContact(\"Chandra sekhar\")-------------------");

			addressBook.deleteContact("Chandra sekhar");
			System.out.println("--------------------After Deleting Chandra sekhar------------------------");
			printList(addressBook.contactList);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
