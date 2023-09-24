package com.ubp.service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.ubp.dao.CustomerDao;
import com.ubp.model.Bill;
import com.ubp.model.Customer;

@Service
public class CustomerService {
	
	SessionFactory sessionFactory;
	CustomerDao customerDao;
	
	public CustomerService(CustomerDao customerDao) {
		this.customerDao=customerDao;
	}
	
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	public Customer getCustomerById(int id) {
		List<Customer> customers = customerDao.getCustomerById(id);
		if(customers.isEmpty()) {
		return null;
		} else {
			return customers.get(0);
		}
	}
}
