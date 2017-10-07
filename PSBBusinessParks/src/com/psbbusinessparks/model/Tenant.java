package com.psbbusinessparks.model;

import java.util.List;

public class Tenant {
private String tenantName;
private Address address;
private List<Contact> contactList;

public String getTenantName() {
	return tenantName;
}
public void setTenantName(String tenantName) {
	this.tenantName = tenantName;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public List<Contact> getContactList() {
	return contactList;
}
public void setContactList(List<Contact> contactList) {
	this.contactList = contactList;
}


}
