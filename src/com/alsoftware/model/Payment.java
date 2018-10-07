package com.alsoftware.model;

public class Payment {

	private String paymentNumber;
	private int memberID;
	private double paymentAmount;


	public Payment() {

	}

	public Payment(String paymentNumber, int memberID, double paymentAmount) {

		this.paymentNumber = paymentNumber;
		this.memberID = memberID;
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public void setPaymentAmount(double paymentAmount) {
	}
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
}
