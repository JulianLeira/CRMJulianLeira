package com.crm.crm.clientopportunity;

import java.util.ArrayList;
import java.util.List;

import com.crm.crm.contact.Contact;

public class ClientOpportunity {

	private int idClientOpp;
	private String name;
	private String lastname;
	private String phone;
	private String email;
	private List<Contact> contacts;
	private boolean isClient;

	
	public ClientOpportunity() {
		super();
	}


	public ClientOpportunity(int idClientOpp, String name, String lastname, String phone, String email, boolean isClient) {
		super();
		this.idClientOpp = idClientOpp;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.contacts = new ArrayList<>();
		this.isClient = isClient;
	}


	public void addContact(Contact contact) {
		contacts.add(contact);
	}


	public int getIdClientOpp() {
		return idClientOpp;
	}


	public void setIdClientOpp(int idClientOpp) {
		this.idClientOpp = idClientOpp;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Contact> getContacts() {
		return contacts;
	}


	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}


	public boolean getClient() {
		return isClient;
	}


	public void setClient(boolean isClient) {
		this.isClient = isClient;
	}

	

}
