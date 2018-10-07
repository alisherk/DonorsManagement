package com.alsoftware.model;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;


class PaymentDaoImplTest {

	private Connection con = DatabaseCon.getInstance().getCon();
	private Payment payment;
 
	@Test
	void testEnterPayment() throws SQLException {
		
		con.setAutoCommit(false);
		
		try {
		payment = new Payment("A4", 2, 40.00 ); 
		
		PaymentDao dao = new PaymentDaoImpl(con);
		dao.enterPayment(payment);
		assertEquals(dao.readPaymentNumber(payment.getPaymentNumber()),payment.getPaymentNumber()); 
		
		} finally {
			con.rollback(); 
			con.close(); 
		}
	}
	
	@Test 
	void testDeletePayment() throws SQLException {
		
		con.setAutoCommit(false);
		
		try {
			PaymentDao dao = new PaymentDaoImpl(con); 
			Payment payment = new Payment(); 
			payment.setPaymentNumber("A3");  
			dao.deletePayment(payment);
			assertNull(dao.readPaymentNumber("A3")); 
			
					
		} finally {
			
			con.rollback();
			con.close();
		}
	}
	
	@Test 
	void testUpdatePayment() throws SQLException {
		
		con.setAutoCommit(false);
		
		try {
			
			PaymentDao dao = new PaymentDaoImpl(con); 
			payment = new Payment(); 
			payment = dao.readPayment("A2"); 
			payment.setPaymentAmount(200);
			dao.updatePayment(payment);
		 
			
		} finally {
			
			con.rollback();
			con.close();
		}
	}
}


