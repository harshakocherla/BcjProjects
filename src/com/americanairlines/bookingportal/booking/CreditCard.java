package com.americanairlines.bookingportal.booking;

public class CreditCard {
	
	private int ccID;
	private String nameOnCard;
	private String ccNumber;
	private String expirationDate;
	private String cvv;
	private String saveDetails;
	private String creditCardBalance;

	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getCcNumber() {
		return ccNumber;
	}
	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getSaveDetails() {
		return saveDetails;
	}
	public void setSaveDetails(String saveDetails) {
		this.saveDetails = saveDetails;
	}
	public int getCcID() {
		return ccID;
	}
	public void setCcID(int ccID) {
		this.ccID = ccID;
	}
	public String getCreditCardBalance() {
		return creditCardBalance;
	}
	public void setCreditCardBalance(String creditCardBalance) {
		this.creditCardBalance = creditCardBalance;
	}

}
