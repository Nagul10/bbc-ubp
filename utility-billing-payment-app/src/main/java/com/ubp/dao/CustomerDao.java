package com.ubp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubp.model.Customer;

@Repository
public class CustomerDao {
	@Autowired
	SessionFactory sessionFactory;

	public List<Customer> getCustomerById(int id) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("customerId",id));
		return criteria.list();
	}

	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}

}
