package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.beans.Login;
import com.ust.beans.Vendor;
import com.ust.beans.VendorContact;
import com.ust.dao.AdminDaoService;


@RestController
public class MainController {
	
	@Autowired
	AdminDaoService admindaoservice;
	
	// verify login
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public Login verifyLogin(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return admindaoservice.verifyLogin(username, password);
	}
	
	
	//view vendor list
	@RequestMapping(value="/api/getallvendors",method=RequestMethod.GET)
	@ResponseBody
	public List getAllVendors(){
		List list = admindaoservice.findAll();
		return list;
	}
	
	//view vendors by name
	
	@RequestMapping(value = "/api/vendor/{vendorName}", method = RequestMethod.GET)
	@ResponseBody
	public List getVendor(Model m,
			@PathVariable("vendorName") String vendorName) {
		List list;
		if (vendorName.equals("null")) {
			list = admindaoservice.getVendor();
		} else {
			list = (List) admindaoservice.getVendorByName(vendorName);
		}

		return list;
	}
	
	// view vendor list by id
			@RequestMapping(value = "/api/vendors/{vendorId}", method = RequestMethod.GET)
			@ResponseBody
			public VendorContact getvendors(Model m, @PathVariable("vendorId") int vendorId) {
				
				return admindaoservice.getVendorById(vendorId);
				 
			}


	
	//get vendor by name
	@RequestMapping(value="/api/getVendorByName/{vendorName}",method=RequestMethod.GET)
	@ResponseBody
	public Vendor getVendorByName(@PathVariable("vendorName") String vendorName){
		return admindaoservice.getVendorByName(vendorName);
	}
	
	// get vendor by location
	@RequestMapping(value = "/api/getVendorByLocation/{vendorLocation}", method = RequestMethod.GET)
	@ResponseBody
	public List getVendorByLocation(@PathVariable("vendorLocation") String vendorLocation) {
		List<?> list = admindaoservice.getVendorByLocation(vendorLocation);
		return list;
	}
	
	//add new vendors
	@RequestMapping(value="/api/insertVendor",method=RequestMethod.POST)
	@ResponseBody
	public void insertVendor(@RequestBody VendorContact vc){
		 admindaoservice.saveVendor(vc);
	}
	
	// update Vendor
	
	@RequestMapping(value = "/api/updateVendor", method = RequestMethod.PUT)
	@ResponseBody
	public void updateVendor(@RequestBody VendorContact vc){
		int vendorId = vc.getVendorId();
		admindaoservice.updateVendor(vendorId, vc);
	}
	
	//disable Vendor
	@RequestMapping(value = "/api/disableVendor/{vendorId}", method = RequestMethod.PUT)
	@ResponseBody
	public void disableVendor(@PathVariable("vendorId") int vendorId) {
		admindaoservice.disableVendor(vendorId);
	}
	
	
	// view contactdetails by vendor id

	@RequestMapping(value = "/api/contactDetails/{vId}", method = RequestMethod.GET)
	@ResponseBody
	public List getContactDetails(Model m, @PathVariable("vId") int vId) {
		List list = admindaoservice.getContactDetailsByVId(vId);
		return list;

	}



	
}
