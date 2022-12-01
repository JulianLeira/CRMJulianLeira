package com.crm.crm.clientopportunity;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crm.crm.contact.Contact;
import com.crm.crm.contact.ContactDaoService;

@RestController
@CrossOrigin(origins = "*")
public class ClientOpportunityResource {
	private ClientOpportunityDaoService clientOppservice;
	private ContactDaoService contactService;

	public ClientOpportunityResource(ClientOpportunityDaoService clientOppservice, ContactDaoService contactService) {
		this.clientOppservice = clientOppservice;
		this.contactService = contactService;

	}

	// retrieve all clients
	@GetMapping("/Clients")
	public List<ClientOpportunity> retrieveAllClients() {
		return clientOppservice.findAllClients();
	}

	// Retrieve all opportunities
	@GetMapping("/Opportunities")
	public List<ClientOpportunity> retrieveAllOpportunities() {
		return clientOppservice.findAllOpportunities();
	}

	// CREATE OPPORTUNITY
	@PostMapping("/ClientOpp")
	public ClientOpportunity createOpportunity(@RequestBody ClientOpportunity cliOpp) {

		return clientOppservice.saveClientOpportunity(cliOpp);
	}
	
	
	
	//Delete one CliOpp by Id
	@DeleteMapping("ClientOpp/{cliOppId}")
	public boolean deleteCliOpp(@PathVariable int cliOppId) {
		try {
			clientOppservice.deleteClient(cliOppId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Create new contact
	@PostMapping("/ClientOpp/{cliOppId}")
	public Contact createContact(@RequestBody Contact contact, @PathVariable int cliOppId) {
		clientOppservice.addContactToClient(contact, cliOppId);
		return contact;
	}

	// Get contacts from one CliOpp by id
	@GetMapping("/ClientOpp/{cliOppId}/contacts")
	public List<Contact> getContactsFromCliOppById(@PathVariable int cliOppId) {
		return clientOppservice.getContactsFromCliOppById(cliOppId);
	}

	// Get one contact from one CLiOpp
	@GetMapping("ClientOpp/{cliOppId}/contacts/{id}")
	public Contact getContactFromCliOppById(@RequestBody Contact contact, @PathVariable int id,
			@PathVariable int cliOppId) {
		try {
			return clientOppservice.findContactById(cliOppId, id);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Change contact details contacts
	@PutMapping("ClientOpp/{cliOppId}/contacts/{id}")
	public boolean updateContact(@RequestBody Contact contact, @PathVariable int id, @PathVariable int cliOppId) {
		try {
			clientOppservice.findContactById(cliOppId, id).setDetails(contact.getDetails());
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

}
