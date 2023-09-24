package com.ubp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter	
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
    private LocalDate billDueDate;
    private double amount;
    private boolean isPaid;
    private double unitsConsumed;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
}
