package com.ubp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ubp.dao.CustomerDao;
import com.ubp.dao.OtpDao;
import com.ubp.model.Customer;
import com.ubp.model.Otp;

@Service
public class LoginService {
	OtpService otpService;
	OtpDao otpDao;
	CustomerDao customerDao;
	EmailService emailService;

	@Autowired
	public LoginService (
			OtpService otpService, 
			OtpDao otpDao, 
			CustomerDao customerDao,
			EmailService emailService
			) {
		this.otpService = otpService;
		this.otpDao = otpDao;
		this.customerDao = customerDao;
		this.emailService = emailService;
	}

	public String generateOtp (int customerId) {
		Customer customer = new Customer();
		customerDao.getCustomerById(customerId);
		if (customerDao.getCustomerById(customerId) == null) {
			return "Invalid Customer Id";
		} else {
			Otp otpObj = new Otp();
			otpObj.setCustomerId(customerId);
			otpObj.setOtp(otpService.generateOtp());
			otpDao.saveOtp(otpObj);
			emailService.sendOtpEmail("hackerboytom@gmail.com", otpObj.getOtp());
			return "otp Generated";
		}
	}

	public String checkLogin (Otp otp) {
		Otp otpObj = otpDao.getOtp(otp.getCustomerId());
		if (otp.getOtp()==otpObj.getOtp()) {
			deleteOtp(otp.getCustomerId());
			return "true";	
		} else {
			return "false";
		}
		
	}
	
	private void deleteOtp(long customerId) {
		otpDao.deleteOtp(customerId);
	}

}
