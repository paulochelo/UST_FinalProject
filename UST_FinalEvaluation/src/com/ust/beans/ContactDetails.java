package com.ust.beans;

public class ContactDetails {
	private int contactId;
	private String name;
	private int vendorId;
	private String department;
	private String email;
	private String phoneNo;
	private int isActive;
	
	
	//constructor with superclass
	public ContactDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor using fields
	public ContactDetails(int contactId, String name, int vendorId,
			String department, String email, String phoneNo, int isActive) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.vendorId = vendorId;
		this.department = department;
		this.email = email;
		this.phoneNo = phoneNo;
		this.isActive = isActive;
	}
	
	
	//getters and setters
	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	//toStrig()
	@Override
	public String toString() {
		return "ContactDetails [contactId=" + contactId + ", name=" + name
				+ ", vendorId=" + vendorId + ", department=" + department
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", isActive="
				+ isActive + "]";
	}
	
	
	
	

}
