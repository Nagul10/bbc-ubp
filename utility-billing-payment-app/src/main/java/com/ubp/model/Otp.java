package com.ubp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Otp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	long customerId;
	long otp;
}
