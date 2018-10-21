package com.alsoftware.model;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PaymentDaoImplTest {
	
    @Test 
	void testFindAllPayments() {
		
		List <Payment> payments = new ArrayList<>(); 
		PaymentDao dao = new PaymentDaoImpl(); 
		payments = dao.findAllPayments(); 
		assertNotNull(payments);
		
		
	}


}


