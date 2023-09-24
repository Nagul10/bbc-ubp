package com.ubp.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ubp.model.Bill;
import com.ubp.model.Customer;
import com.ubp.service.BillService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("bill")
public class BillController {
	
	BillService billService;
	
	@Autowired
	public BillController(BillService billService) {
		this.billService=billService;
	}
	
	@PostMapping("create-bill")
	public String createNewBill() {
		return billService.createNewBill();
	}
	
	@GetMapping("get-bill/{customerId}")
	public List<Bill> getBills(@PathVariable int customerId){
		return billService.getBills(customerId);
	}
	@GetMapping("get-all-bills")
	public List<Bill> getAllBills(){
		return billService.getBills();
	}
	@GetMapping("bill-status/{customerId}")
	public String changeBillStatus(@PathVariable int customerId){
		return billService.changeBillStatus(customerId);
	}
}
