package com.crm.crm.clientopportunity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.crm.crm.contact.Contact;

@Component
public class ClientOpportunityDaoService {

	private static List<ClientOpportunity> clientOppotunities = new ArrayList<>();
	private static List<Contact> contacts = new ArrayList<>();
	private static int idCliopp = 0;
	private static int idCont = 0;

	static {
		clientOppotunities
				.add(new ClientOpportunity(++idCliopp, "Julian", "Leira", "julian@solera.com","123456789", contacts, false));
		clientOppotunities.add(new ClientOpportunity(++idCliopp, "Juan", "Valdes", "Juan@solera.com","123456789", contacts, true));
		contacts.add(new Contact(++idCont, "email", "", false, LocalDate.now().minusMonths(1)));
	}

	// Get all clients
	public List<ClientOpportunity> findAllClients() {
		List<ClientOpportunity> clients = new ArrayList<>();
		for (ClientOpportunity clientOpportunity : clientOppotunities) {
			if (clientOpportunity.isClient()) {
				clients.add(clientOpportunity);
			}
		}
		return clients;
	}

	// Get All Opportunities
	public List<ClientOpportunity> findAllOpportunities() {
		List<ClientOpportunity> clients = new ArrayList<>();
		for (ClientOpportunity clientOpportunity : clientOppotunities) {
			if (!clientOpportunity.isClient()) {
				clients.add(clientOpportunity);
			}
		}
		return clients;
	}

	// Create and add new CliOpp
	public ClientOpportunity saveClientOpportunity(ClientOpportunity client) {
		client.setIdClientOpp(++idCliopp);
		client.setClient(false);
		clientOppotunities.add(client);
		return client;
	}

	// Change opp to client
	public void setOpportunityAsClient(int id) {
		findClientOpportunityById(id).setClient(true);
	}

	// Delete Client
	public void deleteClient(int id) {
		clientOppotunities.remove(id);
	}

	// Find CliOpp by Id
	public ClientOpportunity findClientOpportunityById(int id) {
		Predicate<? super ClientOpportunity> predicate = client -> client.getIdClientOpp() == id;
		Optional<ClientOpportunity> clientOpportunityOptional = clientOppotunities.stream().filter(predicate)
				.findFirst();

		if (clientOpportunityOptional.isPresent()) {
			return clientOpportunityOptional.get();
		}
		return new ClientOpportunity();
	}

	// Get all contacts from one CliOpp
	public List<Contact> getContactsFromCliOppById(int id) {
		return findClientOpportunityById(id).getContacts();
	}

	// Get one contact by ID
	public Contact findContactById(int contactId, int cliOppId) {

		Predicate<? super Contact> predicate = contact -> contact.getIdContact() == contactId;
		Optional<Contact> contactsOptional = getContactsFromCliOppById(cliOppId).stream().filter(predicate).findFirst();

		if (contactsOptional.isPresent()) {
			return contactsOptional.get();
		}
		return new Contact();
	}

	// Add contact to opp
	public ClientOpportunity addContactToClient(Contact contact, int id) {
		ClientOpportunity client = findClientOpportunityById(id);
		contact.setIdContact(++idCont);
		client.addContact(contact);
		return client;
	}

}
