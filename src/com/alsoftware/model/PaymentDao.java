package com.alsoftware.model;

public interface PaymentDao {
	
	public void enterPayment(Payment payment); 

	public String readPaymentNumber (String paymentNumber); 

	public void deletePayment(Payment payment); 

	public void updatePayment(Payment payment); 

	public Payment readPayment(String paymentID);

	public void searchPayment (String paymentNumber, int memberID);

}
