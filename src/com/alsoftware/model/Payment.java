package com.alsoftware.model;

public class Payment {

	private int donorID;
	private String paymentNumber;
	private String firstName; 
	private String lastName; 
    private double paymentAmount;
	private String comment; 
    
    public Payment() {

	}

	public Payment(int donorID, String paymentNumber, String firstName, String lastName, double paymentAmount, 
		String comment) {
        
		this.donorID = donorID;
		this.paymentNumber = paymentNumber;
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.paymentAmount = paymentAmount;
		this.comment = comment; 
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
