package com.ubp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubp.model.Transaction;

@Repository
public class TransactionDao {
	@Autowired
	SessionFactory sessionFactory;

	public String newTransaction(Transaction transaction) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		session.save(transaction);
		session.beginTransaction().commit();
		return "Payment Successful";
	}

	public List<Transaction> getAllTransactions(long customerId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Transaction.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		return criteria.list();
	}
	

}
