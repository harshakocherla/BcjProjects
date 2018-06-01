package com.americanairlines.bookingportal.booking;

import java.util.Random;

public class TicketBookingService {
	
public void saveCustomerDetails(Login l){
	TicketBookingDAO tbd = new TicketBookingDAO();
	tbd.insertCustomerDetails(l);
	
}

public void saveAddressDetails(Login l){
	TicketBookingDAO tbd = new TicketBookingDAO();
	tbd.insertAddressDetails(l);
}

public void saveTicketDetails(Login l){
	TicketBookingDAO tbd = new TicketBookingDAO();
	tbd.insertTicketDetails(l);
}

public void saveLoginDetails(Login l){
	TicketBookingDAO tbd = new TicketBookingDAO();
	tbd.insertLoginDetails(l);
}

public void saveCreditCardDetails(Login l){
	TicketBookingDAO tbd = new TicketBookingDAO();
	tbd.insertCreditCardDetails(l);
}

public boolean verifyCreditCardDetails(Login l){
	TicketBookingDAO tdao = new TicketBookingDAO();
	
	CreditCard ccdBank = tdao.retrieveCreditCardDetails(l);
	boolean verified = false;
	
	
	if(l.getCcDetails().getCcNumber().equals(ccdBank.getCcNumber())){
		if(l.getCcDetails().getNameOnCard().equals(ccdBank.getNameOnCard())){
			if(l.getCcDetails().getCvv().equals(ccdBank.getCvv())){
				if(l.getCcDetails().getExpirationDate().equals(ccdBank.getExpirationDate())){
					if(Integer.parseInt(l.getTicketDetails().getFare()) < Integer.parseInt(ccdBank.getCreditCardBalance())){
		verified = true;
					}
				}
			}
		}
	}
	return verified;
	
}
public int generateItenaryNumber(){
	Random rand = new Random();

	int  n = rand.nextInt(500000) + 5000;
	
	return n;
	
}

public int generateAccountNumber(){
	Random rand = new Random();

	int  n = rand.nextInt(100000) + 1000;
	
	return n;
	
}
}
