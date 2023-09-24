package com.ubp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ubp.model.Otp;
import com.ubp.service.LoginService;

@CrossOrigin()
@RestController
@RequestMapping("login")
public class LoginController {
	LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@PostMapping("generate-otp/{customerId}")
	public String  generateOtp(@PathVariable int customerId) {
		String msg = loginService.generateOtp(customerId);
		return msg;
	}
	@PostMapping("login-otp")
	public String loginCustomer(@RequestBody Otp otp) {
		return loginService.checkLogin(otp);
	}
}
