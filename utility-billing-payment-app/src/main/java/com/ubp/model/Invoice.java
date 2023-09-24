package com.ubp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Invoice {

	private long invoiceId;
	private long invoiceNumber;
    private Customer customer;
    private LocalDate invoiceDate;
}
