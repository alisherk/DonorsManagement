package com.alsoftware.model;

public class Payment {

	private int donorID;
	private String paymentNumber;
	private String firstName; 
	private String lastName; 
    private double paymentAmount;
	
    public Payment() {

	}

	public Payment(int donorID, String paymentNumber, String firstName, double paymentAmount, 
		String lastName) {
        
		this.donorID = donorID;
		this.paymentNumber = paymentNumber;
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public int getMemberID() {
		return donorID;
	}

	public void setMemberID(int donorID) {
		this.donorID = donorID;
	}

	public void setPaymentAmount(double paymentAmount) {
	    this.paymentAmount = paymentAmount; 
	}
	
	public double getPaymentAmount() {
		return paymentAmount;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
