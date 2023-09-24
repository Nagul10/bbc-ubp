package com.ubp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ubp.dao.BillDao;
import com.ubp.dao.CustomerDao;
import com.ubp.model.Bill;
import com.ubp.model.Customer;

@Service
public class BillService {
	
	CustomerDao customerDao;
	BillDao billDao;
	CustomerService customerService;
	
	public BillService(CustomerService customerService,BillDao billDao) {
		this.customerService=customerService;
		this.billDao=billDao;
	}

	public String createNewBill() {
		Customer customer = customerService.getCustomerById(1);
		Bill bill = new Bill();
		bill.setAmount(1000);
		bill.setBillDueDate(LocalDate.now());
		bill.setUnitsConsumed(200);
		bill.setPaid(false);
		bill.setCustomer(customer);
		return billDao.createNewBill(bill);
	}

	public List<Bill> getBills(int customerId) {
		return billDao.getBills(customerId);
	}

	public List<Bill> getBills() {
		return billDao.getAllBills();
	}

	public String changeBillStatus(int billId) {
		Bill bill = getBillById(billId);
		bill.setPaid(true);
		return "changed";
	}

	private Bill getBillById(int billId) {
		return (Bill) billDao.getBills(billId);
	}

}
