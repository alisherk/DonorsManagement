package com.alsoftware.model;

import java.util.List;

public interface PaymentDao {
	
	public List<Payment> findAllPayments(); 
	
	public void insertPayment(Payment payment); 

	public void updatePayment(Payment payment); 
	
	public void deletePayment(Payment payment); 
	
	public String readPayment (String paymentNumber); 

	public void searchPayment (String paymentNumber, int memberID);

}
