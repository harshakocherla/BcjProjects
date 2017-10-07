package com.psbbusinessparks.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.psbbusinessparks.model.Address;
import com.psbbusinessparks.model.Contact;
import com.psbbusinessparks.model.Tenant;
import com.psbbusinessparks.service.PSBService;



/**
 * @author Harsha Kocherla
 * 
 * This class contains 
 */
public class PSBParkDemo {
	PSBService psbService = new PSBService();
	
public static void main(String[] args) throws IOException {
	PSBParkDemo psbParkDemo = new PSBParkDemo();
	psbParkDemo.createTenantData();
	psbParkDemo.displayPSBTenantInfo();
	
}
public void createTenantData() throws IOException{
	System.out.println("Please enter the number of Tenants in the complex");
	BufferedReader input1 = new BufferedReader(new InputStreamReader(System.in));
	int number = Integer.parseInt(input1.readLine());
	
	for(int i = 1; i<=number; i++){
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Please enter Tenant details!");
	System.out.println(i+". Enter Tenant name : ");
	String tenantName = br.readLine();
	System.out.println("Enter Address Line 1 :");
	
	String addressLine1 = br.readLine();
	System.out.println("Enter Address Line 2 : ");
	String addressLine2 = br.readLine();
	System.out.println("Enter city : ");
	String city = br.readLine();
	System.out.println("Enter state : ");
	String state = br.readLine();
	System.out.println("Enter zip : ");
	String zip = br.readLine();
	
	System.out.println("Please enter Primary Contact details.");
	System.out.println("Enter first name : ");
	String firstName1 = br.readLine();
	System.out.println("Enter last name : ");
	String lastName1 = br.readLine();
	System.out.println("Enter Phone Number : ");
	String phoneNumber1 = br.readLine();
	System.out.println("Enter email id : ");
	String emailId1 = br.readLine();
	
	System.out.println("Please enter Secondary Contact details.");
	System.out.println("Enter first name : ");
	String firstName2 = br.readLine();
	System.out.println("Enter last name : ");
	String lastName2 = br.readLine();
	System.out.println("Enter Phone Number : ");
	String phoneNumber2 = br.readLine();
	System.out.println("Enter email id : ");
	String emailId2 = br.readLine();
	
	Tenant tenant = new Tenant();
	Address address = new Address();
	Contact primaryContact = new Contact();
	Contact secondaryContact = new Contact();
	
	tenant.setTenantName(tenantName);
	address.setAddressLine1(addressLine1);
	address.setAddressLine2(addressLine2);
	address.setCity(city);
	address.setState(state);
	address.setZip(zip);
	
	tenant.setAddress(address);
	
	primaryContact.setFirstName(firstName1);
	primaryContact.setLastName(lastName1);
	primaryContact.setPhoneNumber(phoneNumber1);
	primaryContact.setEmailId(emailId1);
	
	secondaryContact.setFirstName(firstName2);
	secondaryContact.setLastName(lastName2);
	secondaryContact.setPhoneNumber(phoneNumber2);
	secondaryContact.setEmailId(emailId2);
	
	List<Contact> contactList = new ArrayList<Contact>();
	contactList.add(primaryContact);
	contactList.add(secondaryContact);
	
	tenant.setContactList(contactList);
	
	psbService.saveTenantInfo(tenant);
	System.out.println("******************************************");
	}
	
}
public void displayPSBTenantInfo() throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Please enter search address line 1 of the Tenant : ");
	String addressLine1 = br.readLine();
	
	List<Tenant> matchedTenantList = psbService.compareTenantInfo(addressLine1);
	
	for(Tenant tenant : matchedTenantList){
		System.out.println("Tenant name : "+tenant.getTenantName()+"\n");
		System.out.println("Address Line 1 :"+tenant.getAddress().getAddressLine1());
		System.out.println("Address Line 2 :"+tenant.getAddress().getAddressLine2());
		System.out.println("city : "+tenant.getAddress().getCity());
		System.out.println("state : "+tenant.getAddress().getState());
		System.out.println("zip : "+tenant.getAddress().getZip()+"\n");

		String[] s = {"Primary contact :","Secondary contact :"};
		int count = 0;
		for(Contact contactList : tenant.getContactList()){
			System.out.println(s[count]);
			System.out.println("\tFirst name: "+contactList.getFirstName());
			System.out.println("\tLast name: "+contactList.getLastName());
			System.out.println("\tPhone number: "+contactList.getPhoneNumber());
			System.out.println("\tEmail ID: "+contactList.getEmailId());
			System.out.println("-----------------------------------------");
			count++;

		}
	}
}
}
