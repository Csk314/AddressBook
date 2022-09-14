package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {
	List<Contact> contactList = new ArrayList<Contact>();

	public void addContact(Contact contact) throws DuplicateContact {
		if (!contactList.contains(contact)) {
			contactList.add(contact);
		} else {
			throw new DuplicateContact("Contact already Exists");
		}
	}

	public List<Contact> searchByName(String name) {

		List<Contact> filteredList = contactList.stream().filter(i -> i.getName().matches("(?i)" + name + "(.*)"))
				.collect(Collectors.toList());
		return filteredList;

	}

	public List<Contact> searchByOrganisation(String organisation) {
//		List<Contact> filteredOrgList = contactList.stream()
//				.filter(i -> organisation.compareTo(i.getOrganisation()) != -1).collect(Collectors.toList());

		List<Contact> filteredOrgList = contactList.stream()
				.filter(i -> i.getOrganisation().matches("(?i)" + organisation + "(.*)")).collect(Collectors.toList());
		return filteredOrgList;
	}

	public void updateContact(String name, Contact contact) throws DuplicateNameException, LengthException {
		if (contact.getName() != name) {
			contact.setName(name);
		} else {
			throw new DuplicateNameException("Cannot Update Same Name already Exists");
		}
	}

	public void deleteContact(String name) {
		Contact tobeDeleted = null;
		for (Contact i : contactList) {
			if (i.getName().equals(name)) {
				// contactList.remove(i); //gives java.util.ConcurrentModificationException
				tobeDeleted = i;
			}
		}
		if (tobeDeleted != null) {
			contactList.remove(tobeDeleted);
		} else {
			System.out.println("Invalid name, Try to delete again ");
		}
	}
}
