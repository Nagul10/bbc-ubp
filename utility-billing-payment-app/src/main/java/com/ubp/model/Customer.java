package com.ubp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	@Id
	private int customerId; 
	private String customerName;
	private String address;
	private String email;
	private long telephone;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Bill> bills = new ArrayList<>();
}
