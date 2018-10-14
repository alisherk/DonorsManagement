package com.alsoftware.model;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class LoginDAOTest {

	@Test
	void testValidate() {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DatabaseCon.getInstance().getCon();
			ps = con.prepareStatement("Select UserName, Password from Users where UserName = ? and Password = ?");
			ps.setString(1, "Ali");
			ps.setString(2, "7161034");
			
			ResultSet rs = ps.executeQuery(); 
			assertNotNull(rs);
	
		}catch (SQLException ex) {
			
			ex.printStackTrace();
			
		}
	}
}
