package com.ubp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ubp.model.Otp;

@Repository
public class OtpDao {
	SessionFactory sessionFactory;
	
	@Autowired
	public OtpDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Otp getOtp(long l) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Otp.class);
		//criteria.add(Restrictions.eq("customerId",customerId));
		session.beginTransaction().commit();
		return (Otp) criteria.list().get(0);
	}

	public void saveOtp(Otp otpObj) {
		Session session = sessionFactory.openSession();
		session.save(otpObj);
		session.beginTransaction().commit();
	}
	

	public void deleteOtp(long customerId) {
		Otp otp = new Otp();
		otp.setCustomerId(customerId);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Otp.class);
		criteria.add(Restrictions.eq("customerId",customerId));
		session.delete(otp);
		session.beginTransaction().commit();
		
	}
	
	

}
