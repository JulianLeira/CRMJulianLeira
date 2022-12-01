package com.crm.crm.contact;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class ContactResource {
	private ContactDaoService service;
	
	public ContactResource(ContactDaoService service) {
		this.service=service;
	}
	
	//Look for specific contact
	@GetMapping("/contacts")
	public List<Contact> retrieveAllContacts(){
		return service.findAllContactsFromClientOpportunity();
	}
	//Look for specific contact
	@GetMapping("/contacts/{id}")
	public Contact retrieveContact(@PathVariable int id){
		return service.findById(id);
	}
	//Create new contact
	@PostMapping("/contacts")
	public Contact createContact(@RequestBody Contact contact) {
		return service.save(contact);
	}
	//Change contact details for future contacts
	@PutMapping("/contacts/{id}")
	public boolean updateContact(@RequestBody Contact contact,@PathVariable int id) {
		try {
			service.findById(id).setDetails(contact.getDetails());
			return true;
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		return false;
	}
	
}
