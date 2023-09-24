package com.ubp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	private String transactionStatus;
	private LocalDate transactionDate;
	private String paymentMethod;
	private long customerId;
	private long billId;
	
}
