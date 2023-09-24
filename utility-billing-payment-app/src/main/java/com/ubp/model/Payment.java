package com.ubp.model;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Payment {
	private int paymentId;
    private double amount;
    private LocalDate paymentDate;
    private String paymentMethod; 
    private Bill associatedBill;
    
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;
}
