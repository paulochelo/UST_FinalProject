package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.Login;
import com.ust.beans.Vendor;
import com.ust.beans.VendorContact;

public class AdminDaoService {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// verify login
	public Login verifyLogin(String username, String password) {
		String sql = "select userId,username,password from ust_loginTable where username=? and password=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { username,
				password }, new BeanPropertyRowMapper<Login>(Login.class));
	}

	// view vendor List
	public List<Vendor> findAll() {
		String sql = "select * from ust_vendorTable where isActive=1";
		return jdbcTemplate.query(sql, new RowMapper<Vendor>() {
			public Vendor mapRow(ResultSet rs, int row) throws SQLException {
				Vendor v = new Vendor();
				v.setVendorId(rs.getInt(1));
				v.setVendorName(rs.getString(2));
				v.setVendorAddress(rs.getString(3));
				v.setVendorLocation(rs.getString(4));
				v.setVendorService(rs.getString(5));
				v.setPincode(rs.getInt(6));
				v.setIsActive(rs.getInt(7));
				return v;

			}

		});

	}
	
	public List<VendorContact> getVendor() {
		return jdbcTemplate
				.query("select vendorId,vendorName,vendorAddress,vendorLocation,vendorService,pincode from ust_vendorTable where isActive=0",
						new RowMapper<VendorContact>() {
							public VendorContact mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContact vc = new VendorContact();
								vc.setVendorId(rs.getInt(1));
								vc.setVendorName(rs.getString(2));
								vc.setVendorAddress(rs.getString(3));
								vc.setVendorLocation(rs.getString(4));
								vc.setVendorService(rs.getString(5));
								vc.setPincode(rs.getInt(6));
								return vc;
							}
						});
	}


	// get vendor by name
	public Vendor getVendorByName(String vendorName) {
		String sql = "select * from ust_vendorTable where vendorName='"
				+ vendorName + "'";

		return jdbcTemplate.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Vendor>(Vendor.class));

	}

	// get vendor by location
	public List<Vendor> getVendorByLocation(String vendorLocation) {
		String sql = "select * from ust_vendorTable where vendorLocation='"
				+ vendorLocation + "'";
		return jdbcTemplate.query(sql, new RowMapper<Vendor>() {
			public Vendor mapRow(ResultSet rs, int row) throws SQLException {
				Vendor v = new Vendor();
				v.setVendorId(rs.getInt(1));
				v.setVendorName(rs.getString(2));
				v.setVendorAddress(rs.getString(3));
				v.setVendorLocation(rs.getString(4));
				v.setVendorService(rs.getString(5));
				v.setPincode(rs.getInt(6));
				v.setIsActive(rs.getInt(7));
				return v;

			}

		});

	}

	// get vendor details by id
	public VendorContact getVendorById(int vendorId) {
		String sql ="select vc.vendorId,vc.vendorName,vc.vendorAddress,vc.vendorLocation,vc.vendorService,vc.pincode,cd.name,cd.department,cd.email,cd.phoneNo,cd.contactId from ust_vendorTable vc join ust_contactDetailsTable cd on vc.vendorId=cd.vendorId where vc.isActive=1 and vc.vendorId="
						+ vendorId + "";
					return jdbcTemplate.queryForObject(sql, new  Object[]{}, new BeanPropertyRowMapper<VendorContact>(VendorContact.class));	
						
						
	}

	// add new vendors
	public int saveVendor(VendorContact vc) {

		String sql1 = "insert into ust_vendorTable(vendorName,vendorAddress,vendorLocation,"
				+ "vendorService,pincode,isActive) values "
				+ "('"
				+ vc.getVendorName()
				+ "','"
				+ vc.getVendorAddress()
				+ "','"
				+ vc.getVendorLocation()
				+ "','"
				+ vc.getVendorService()
				+ "','" + vc.getPincode() + "'," + 1 + ")";

		jdbcTemplate.update(sql1);

		Integer maxId = getSequence();
		String sql2 = "insert into ust_contactDetailsTable(vendorId,name,department,email,phoneNo) values ("
				+ maxId
				+ ",'"
				+ vc.getName()
				+ "','"
				+ vc.getDepartment()
				+ "','" + vc.getEmail() + "','" + vc.getPhoneNo() + "')";
		return jdbcTemplate.update(sql2);

	}

	// get vendor by id
	private Integer getSequence() {
		Integer seq;
		String sql = "select MAX(vendorId)from ust_vendorTable";
		seq = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		return seq;
	}

	// update vendor
	public int updateVendor(int vendorId, VendorContact vc) {

		String sql = "update ust_vendorTable set vendorName='"
				+ vc.getVendorName() + "' ,vendorAddress='"
				+ vc.getVendorAddress() + "' ,vendorLocation='"
				+ vc.getVendorLocation() + "',vendorService='"
				+ vc.getVendorService() + "',pincode=" + vc.getPincode()
				+ ",isActive=1 " + "where vendorId ="
				+ vendorId;
		jdbcTemplate.update(sql);

		String sql1 = "update ust_contactDetailsTable set vendorId=" + vendorId
				+ ",name='" + vc.getName() + "',department='"
				+ vc.getDepartment() + "',email='" + vc.getEmail()
				+ "',phoneNo='" + vc.getPhoneNo() + "'where contactId = "
				+ vc.getContactId();

		return jdbcTemplate.update(sql1);

	}

	// disable vendor
	public int disableVendor(int vendorId) {

		String sql2 = "update ust_vendorTable set isActive=0 where vendorId="
				+ vendorId + "";
		return jdbcTemplate.update(sql2);
	}

	// get contactdetails by id

	public List<VendorContact> getContactDetailsByVId(int vid) {
		return jdbcTemplate
				.query("select  contactId,name,department,vendorId,email,phoneNo from ust_contactDetailsTable where vendorId="
						+ vid + "", new RowMapper<VendorContact>() {
					public VendorContact mapRow(ResultSet rs, int row)
							throws SQLException {
						VendorContact vc = new VendorContact();
						vc.setContactId(rs.getInt(1));
						vc.setName(rs.getString(2));
						vc.setDepartment(rs.getString(2));
						vc.setVendorId(rs.getInt(4));
						vc.setEmail(rs.getString(5));
						vc.setPhoneNo(rs.getString(6));
						return vc;
					}
				});
	}



}
