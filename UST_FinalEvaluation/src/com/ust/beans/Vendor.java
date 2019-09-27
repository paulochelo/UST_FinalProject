package com.ust.beans;

public class Vendor {
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorLocation;
	private String vendorService;
	private int pincode;
	private int isActive;
	
	//constructor with superclass
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//constructor using fields
	public Vendor(int vendorId, String vendorName, String vendorAddress,
			String vendorLocation, String vendorService, int pincode,
			int isActive) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorAddress = vendorAddress;
		this.vendorLocation = vendorLocation;
		this.vendorService = vendorService;
		this.pincode = pincode;
		this.isActive = isActive;
	}
	
	//getters and setters
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	//toStrig()
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName
				+ ", vendorAddress=" + vendorAddress + ", vendorLocation="
				+ vendorLocation + ", vendorService=" + vendorService
				+ ", pincode=" + pincode + ", isActive=" + isActive + "]";
	}
	
	
	
	

}
