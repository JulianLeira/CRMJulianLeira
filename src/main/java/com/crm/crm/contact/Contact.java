package com.crm.crm.contact;


import java.time.LocalDate;

public class Contact {
	public Contact() {
		super();
	}

	private int idContact;
	private String via;
	private String details;
	private boolean result;
	private LocalDate date;
	
	
	
	public Contact(int idContact, String via, String details, boolean result, LocalDate date) {
		super();
		this.idContact = idContact;
		this.via = via;
		this.details = details;
		this.result = result;
		this.date = date;
	}

	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Contact [idContact=" + idContact + ", via=" + via + ", details=" + details + ", result=" + result
				+ ", date=" + date + "]";
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
