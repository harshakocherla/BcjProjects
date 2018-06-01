package com.americanairlines.bookingportal.booking;

public class Login {
	
	private int customerAcountID;
	private String userID;
	private String password;	
	private Customer user;
	private CreditCard ccDetails;
	private Ticket ticket;
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;

	}

	public int getCustomerAcountID() {
		return customerAcountID;
	}

	public void setCustomerAcountID(int customerAcountID) {
		this.customerAcountID = customerAcountID;
	}

	public CreditCard getCcDetails() {
		return ccDetails;
	}

	public void setCcDetails(CreditCard ccDetails) {
		this.ccDetails = ccDetails;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Ticket getTicketDetails() {
		return ticket;
	}

	public void setTicketDetails(Ticket ticket) {
		this.ticket = ticket;
	}
}
