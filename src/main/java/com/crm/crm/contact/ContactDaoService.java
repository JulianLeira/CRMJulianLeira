package com.crm.crm.contact;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crm.crm.clientopportunity.ClientOpportunity;

@Component
public class ContactDaoService {
	
	
	private static List<Contact> contacts = new ArrayList<>();
	private static int id=0;
	
	static {
		contacts.add(new Contact(++id,"email","",false,LocalDate.now().minusMonths(1)));
		contacts.add(new Contact(++id,"phone","",false,LocalDate.now().minusMonths(2)));
		contacts.add(new Contact(++id,"email","",false,LocalDate.now().minusMonths(1).minusDays(5)));
	}
	
	public List<Contact> findAllContactsFromClientOpportunity(){
		return contacts;
	}
	
	//public Contact save(Contact contact)
	public Contact save(Contact contact) {
		contact.setIdContact(++id);
		contacts.add(contact);
		return contact;
	}
	
	//Find one contact
	public Contact findById(int id) {
		Predicate<? super Contact> predicate = contact -> contact.getIdContact() == id;
		Optional<Contact> contactOptional = contacts.stream().filter(predicate).findFirst();		
		if (contactOptional.isPresent()) {
			return contactOptional.get();
		}
		return null;
		
	}
}
