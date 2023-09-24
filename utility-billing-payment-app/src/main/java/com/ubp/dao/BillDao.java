package com.ubp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubp.model.Bill;

@Repository
public class BillDao {
	@Autowired
	SessionFactory sessionFactory;

	public String createNewBill(Bill bill) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(BillDao.class);
		session.save(bill);
		return "Bill Created";
	}

	public List<Bill> getBills(int customerId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		criteria.createAlias("customer", "customer");
        criteria.add(Restrictions.eq("customer.customerId", customerId));
		return criteria.list();
	}

	public List<Bill> getAllBills() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		
		return criteria.list();
	}
	
}
