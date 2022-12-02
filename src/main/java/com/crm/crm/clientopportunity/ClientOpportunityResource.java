package com.crm.crm.clientopportunity;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.crm.contact.Contact;
//import com.crm.crm.contact.ContactDaoService;

@RestController
@RequestMapping("/ClientOpp")
@CrossOrigin(origins = "*")
public class ClientOpportunityResource {
	private ClientOpportunityDaoService clientOppservice;

	public ClientOpportunityResource(ClientOpportunityDaoService clientOppservice) {
		this.clientOppservice = clientOppservice;

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
	@PostMapping
	public ClientOpportunity createOpportunity(@RequestBody ClientOpportunity cliOpp) {

		return clientOppservice.saveClientOpportunity(cliOpp);
	}
	
	//Set CliOpp isClient boolean to true
	@PutMapping("/{cliOppId}")
	public void changeOpportunityToClient(@PathVariable int cliOppId) {
		clientOppservice.setOpportunityAsClient(cliOppId);
	}
	
	//Delete one CliOpp by Id
	@PostMapping("/{cliOppId}/delete")
	public boolean deleteCliOpp(@PathVariable int cliOppId) {
		try {
			clientOppservice.deleteClient(cliOppId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@GetMapping("/{cliOppId}")
	public ClientOpportunity getCLiOppById(@PathVariable int cliOppId) {
		return clientOppservice.findClientOpportunityById(cliOppId);
	}
	// Create new contact
	@PostMapping("/{cliOppId}")
	public Contact createContact(@RequestBody Contact contact, @PathVariable int cliOppId) {
		clientOppservice.addContactToClient(contact, cliOppId);
		return contact;
	}

	// Get contacts from one CliOpp by id
	@GetMapping("/{cliOppId}/contacts")
	public List<Contact> getContactsFromCliOppById(@PathVariable int cliOppId) {
		return clientOppservice.getContactsFromCliOppById(cliOppId);
	}
	
	// Get one contact from one CLiOpp
	@GetMapping("/{cliOppId}/contacts/{id}")
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
	@PutMapping("/{cliOppId}/contacts/{id}")
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
