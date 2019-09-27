package com.ust.beans;

public class VendorContact {
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorLocation;
	private String vendorService;
	private int pincode;
	private int contactId;
	private String name;
	private String department;
	private String email;
	private String phoneNo;
	private int isActive;
	
	//constructor from superclass
	public VendorContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor using fields
	public VendorContact(int vendorId, String vendorName, String vendorAddress,
			String vendorLocation, String vendorService, int pincode,
			int contactId, String name, String department, String email,
			String phoneNo, int isActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorLocation = vendorLocation;
		this.vendorService = vendorService;
		this.pincode = pincode;
		this.contactId = contactId;
		this.name = name;
		this.department = department;
		this.email = email;
		this.phoneNo = phoneNo;
		this.isActive = isActive;
	}
	
	
	//setters ad getters
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorLocation() {
		return vendorLocation;
	}

	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}

	public String getVendorService() {
		return vendorService;
	}

	public void setVendorService(String vendorService) {
		this.vendorService = vendorService;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

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
	
	
	//toString()
	@Override
	public String toString() {
		return "VendorContact [vendorId=" + vendorId + ", vendorName="
				+ vendorName + ", vendorAddress=" + vendorAddress
				+ ", vendorLocation=" + vendorLocation + ", vendorService="
				+ vendorService + ", pincode=" + pincode + ", contactId="
				+ contactId + ", name=" + name + ", department=" + department
				+ ", email=" + email + ", phoneNo=" + phoneNo + ", isActive="
				+ isActive + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
