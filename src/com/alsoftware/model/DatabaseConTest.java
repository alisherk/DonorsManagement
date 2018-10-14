package com.alsoftware.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

class DatabaseConTest {

	Connection con = DatabaseCon.getInstance().getCon();
	PreparedStatement pst = null;

	@Test
	void testCon() {

		assertNotNull(con);

	}

	@Test
	void testReturnedData() throws SQLException {

		pst = con.prepareStatement("Select * from Members");
		assertNotNull(pst);

	}

	@Test
	void testException() {

		String wrongQuery = "fjfjfljf";
		try {
			pst = con.prepareStatement(wrongQuery); 
			pst.executeQuery(); 

		} catch (SQLException e) {
			assertNotNull(e.getMessage());
		}

	}
    
	@Test 
	void testConClosed() {
		
		try {
		String malFormedSQL = "Sel from Members"; 
		pst = con.prepareStatement(malFormedSQL); 
		pst.executeQuery(); 
		assertTrue(con.isClosed());
		
	}catch (SQLException ex) {
		ex.printStackTrace();
	}
}
}