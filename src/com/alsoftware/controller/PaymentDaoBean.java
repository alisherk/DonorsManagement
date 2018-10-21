package com.alsoftware.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.alsoftware.model.DaoFactory;
import com.alsoftware.model.Payment;
import com.alsoftware.model.PaymentDao;

@ManagedBean 
@ViewScoped 

public class PaymentDaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
    private List <Payment> payments;  
    
    public PaymentDaoBean() {
    	
    	payments = new ArrayList<>(); 
    	PaymentDao dao = DaoFactory.getPaymentImplDao(); 
    	payments.addAll(dao.findAllPayments()); 
    	
    	
    }

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
}
