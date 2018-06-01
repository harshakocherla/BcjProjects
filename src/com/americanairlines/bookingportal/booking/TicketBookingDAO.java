package com.americanairlines.bookingportal.booking;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;

public class TicketBookingDAO {

	public void insertCustomerDetails(Login l) {
		System.out.println("insertCustomerDetails begin");
		Connection con = null;
		java.sql.PreparedStatement pst = null;

		String query = "INSERT INTO customerdetails(firstname,lastname,emailaddress,phonenumber,customeraddress_custumeraddressID) " + "values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/americanairlines?autoReconnect=true&amp;useSSL=false", "root",
					"03Aug@91");
			pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, l.getUser().getFirstName());
			pst.setString(2, l.getUser().getLastName());
			pst.setString(3, l.getUser().getEmailAddress());
			pst.setString(4, l.getUser().getPhoneNumber());
			pst.setInt(5, l.getUser().getAddress().getCustomeraddressID());
			

			int count = pst.executeUpdate();
			System.out.println("no of rows effected:" + count);
			
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()){
				
				l.getUser().setCustomerID(rs.getInt(1));
			}
			System.out.println(l.getUser().getCustomerID()+"custid from dao");
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {

			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("insertCustomerDetails end");
	}

	public void insertAddressDetails(Login l) {
		System.out.println("insertAddressDetails begin");
		Connection con = null;
		java.sql.PreparedStatement pst = null;

		String query = "INSERT INTO customeraddress(address_line1,address_line2,city,state,zip) "
				+ "values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/americanairlines?autoReconnect=true&amp;useSSL=false", "root",
					"03Aug@91");
			pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, l.getUser().getAddress().getAddressLine1());
			pst.setString(2, l.getUser().getAddress().getAddressLine2());
			pst.setString(3, l.getUser().getAddress().getCity());
			pst.setString(4, l.getUser().getAddress().getState());
			pst.setString(5, l.getUser().getAddress().getZip());

			int count = pst.executeUpdate();
			System.out.println("no of rows effected:" + count);
			
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()){
				
				l.getUser().getAddress().setCustomeraddressID(rs.getInt(1));
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {

			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("insertAddressDetails end");
	}

	public void insertTicketDetails(Login l) {
		System.out.println("insertTicketDetails begin");
		Connection con = null;
		java.sql.PreparedStatement pst = null;

		String query = "INSERT INTO ticketdetails(from_city, to_city, fare, journey_type,customeraccount_customer_acountID, onward_date, return_date) "
				+ "values (?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/americanairlines?autoReconnect=true&amp;useSSL=false", "root",
					"03Aug@91");
			pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, l.getTicketDetails().getFromCity());
			pst.setString(2, l.getTicketDetails().getToCity());
			pst.setString(3, l.getTicketDetails().getFare());			
			pst.setString(4, l.getTicketDetails().getJourneyType());
			pst.setInt(5, l.getCustomerAcountID());
			pst.setString(6, l.getTicketDetails().getOnWardDate());
			pst.setString(7, l.getTicketDetails().getReturnDate());
			


			int count = pst.executeUpdate();
			System.out.println("no of rows effected:" + count);
			
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()){
				
				l.getTicketDetails().setTicketID(rs.getInt(1));
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {

			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("insertTicketDetails end");
	}

	public void insertLoginDetails(Login l) {
		System.out.println("insertLoginDetails begin");
		Connection con = null;
		java.sql.PreparedStatement pst = null;

		String query = "INSERT INTO customeraccount(userID,password,customerdetails_customerID) " + "values (?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/americanairlines?autoReconnect=true&amp;useSSL=false", "root",
					"03Aug@91");
			pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, l.getUserID());
			pst.setString(2, l.getPassword());
			pst.setInt(3, l.getUser().getCustomerID());
			
			

			int count = pst.executeUpdate();
			System.out.println("no of rows effected:" + count);
			
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()){
				
				l.setCustomerAcountID(rs.getInt(1));
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {

			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("insertLoginDetails end");
	}

	public void insertCreditCardDetails(Login l) {
		System.out.println("insertCreditCardDetails begin");
		Connection con = null;
		java.sql.PreparedStatement pst = null;

		String query = "INSERT INTO creditcard_details(name_on_card, card_number, expiration_date, cvv,customeraccount_customer_acountID) "
				+ "values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/americanairlines?autoReconnect=true&amp;useSSL=false", "root",
					"03Aug@91");
			pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, l.getCcDetails().getNameOnCard());
			pst.setString(2, l.getCcDetails().getCcNumber());
			pst.setString(3, l.getCcDetails().getExpirationDate());
			pst.setString(4, l.getCcDetails().getCvv());
			pst.setInt(5, l.getCustomerAcountID());

			int count = pst.executeUpdate();
			System.out.println("no of rows effected:" + count);
			
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()){
			
				l.getCcDetails().setCcID(rs.getInt(1));
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {

			try {
				con.close();
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("insertCreditCardDetails end");
	}


public CreditCard retrieveCreditCardDetails(Login l) {
	System.out.println("retrieveCreditCardDetails begin");
	CreditCard ccdDataBase = new CreditCard();
	Connection con = null;
	java.sql.PreparedStatement pst = null;

	String query = "SELECT*FROM creditcard_referData WHERE card_number =?";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/americanairlines?autoReconnect=true&amp;useSSL=false", "root",
				"03Aug@91");
		pst = con.prepareStatement(query);
		pst.setString(1, l.getCcDetails().getCcNumber());

		ResultSet rs = pst.executeQuery();
				
		//ResultSet rs = pst.getGeneratedKeys();
		
		while(rs.next()){
			ccdDataBase.setCcNumber(rs.getString("card_number"));
			ccdDataBase.setNameOnCard(rs.getString("name_on_card"));
			ccdDataBase.setExpirationDate(rs.getString("expiration_date"));
			ccdDataBase.setCvv(rs.getString("cvv"));
			ccdDataBase.setCreditCardBalance(rs.getString("available_balance"));
		}
		
	}

	catch (Exception ex) {
		ex.printStackTrace();
		return null;
	}

	finally {

		try {
			con.close();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	System.out.println("insertCreditCardDetails end");
	return ccdDataBase;
	
}
}

