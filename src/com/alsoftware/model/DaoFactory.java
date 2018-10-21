package com.alsoftware.model;

public class DaoFactory {

	public static MemberDaoImpl getMemberImplDao() {
		return new MemberDaoImpl();	
	}
	public static PaymentDaoImpl getPaymentImplDao() {
		return new PaymentDaoImpl(); 
	}
	public static LoginDao getLoginDao() {
		return new LoginDao();
		
	}
}
