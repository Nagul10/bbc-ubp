package com.ubp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubp.model.Bill;
import com.ubp.model.Customer;
import com.ubp.service.CustomerService;

@CrossOrigin()
@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("get-customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	

}
