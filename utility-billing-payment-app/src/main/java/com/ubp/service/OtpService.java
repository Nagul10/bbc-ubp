package com.ubp.service;

import org.springframework.stereotype.Service;

@Service
public class OtpService {
	public int generateOtp() {
        int otp = (int) (Math.random() * 900000) + 100000;
        return otp;
    }
}
