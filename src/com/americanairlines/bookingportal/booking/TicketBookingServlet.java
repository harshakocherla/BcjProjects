package com.americanairlines.bookingportal.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketBookingServlet
 */
@WebServlet("/TicketBookingServlet")
public class TicketBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TicketBookingServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    	
    	String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email_address");
		String phoneNumber = request.getParameter("Phone Number");
	
    	Customer customer = new Customer();
    	customer.setFirstName(firstName);
    	customer.setLastName(lastName);
    	customer.setEmailAddress(email);
    	customer.setPhoneNumber(phoneNumber);
    	   	
    	Address ad = new Address();
    	
		String addressLine1 = request.getParameter("Address Line 1");
		String addressLine2 = request.getParameter("Address Line 2");
		String city = request.getParameter("City");
		String state = request.getParameter("State");//here we need to get State details
		String zip = request.getParameter("ZIP");
		
    	ad.setAddressLine1(addressLine1);
    	ad.setAddressLine2(addressLine2);
    	ad.setCity(city);
    	ad.setState(state);
    	ad.setZip(zip);
    	
		String userID = request.getParameter("user id");
		String password = request.getParameter("password");
    	

		String ccName = request.getParameter("name");
		String ccNumber = request.getParameter("CC Number");
		String expirationDate = request.getParameter("exp");
		String cvv = request.getParameter("CVV");
		String saveDetails = request.getParameter("save");
		
		CreditCard ccd = new CreditCard();
		
		ccd.setCcNumber(ccNumber);
		ccd.setNameOnCard(ccName);
		ccd.setCvv(cvv);
		ccd.setExpirationDate(expirationDate);
		ccd.setSaveDetails(saveDetails);
		
		Ticket td = new Ticket();
		td.setFromCity(request.getParameter("from"));
		td.setToCity(request.getParameter("to"));
		td.setFare(request.getParameter("fare"));
		td.setOnWardDate(request.getParameter("onWardDate"));
		td.setReturnDate(request.getParameter("ReturnDate"));
		
		td.setJourneyType(request.getParameter("journeyType"));
				
    	Login l = new Login();
    	l.setUserID(userID);
    	l.setPassword(password);
		
		l.setCcDetails(ccd);
		l.setUser(customer);
		l.getUser().setAddress(ad);
		l.setCcDetails(ccd);
		l.setTicketDetails(td);		

		TicketBookingService tbs = new TicketBookingService();
		if(tbs.verifyCreditCardDetails(l)){
			
			tbs.saveAddressDetails(l);
			tbs.saveCustomerDetails(l);
			tbs.saveLoginDetails(l);
			tbs.saveTicketDetails(l);
			
			 PrintWriter out=response.getWriter();  
		        out.println("<h1>Thank you for flying with American Airlines</h1><br/>");
		        out.println("<h3>Your Account Number is "+tbs.generateAccountNumber()+"</h3><br/>");
		        out.println("<h3>Your Itenary Number is "+tbs.generateItenaryNumber()+"</h3><br/>");
			if("save".equals(ccd.getSaveDetails())){
				tbs.saveCreditCardDetails(l);
			}
		}else{
			 PrintWriter out = response.getWriter();  
		        out.println("<h1>card details doesnt match</h1>");  
		        
		}

		
 
		
		
		
    }

}
