package com.americanairlines.bookingportal.booking;

public class Ticket {
	
	private int ticketID;
	private String fromCity;
	private String toCity;
	private String fare;
	private String onWardDate;
	private String returnDate;
	private String journeyType;
	private String date;
	
	private Login login;
	
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getJourneyType() {
		return journeyType;
	}
	public void setJourneyType(String journeyType) {
		this.journeyType = journeyType;
	}
	public String getOnWardDate() {
		return onWardDate;
	}
	public void setOnWardDate(String onWardDate) {
		this.onWardDate = onWardDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

}
