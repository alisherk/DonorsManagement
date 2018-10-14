package com.alsoftware.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCon {
	
	private static Connection con;
	private static DatabaseCon instance = new DatabaseCon(); 
	
	private DatabaseCon() {
		
	}
	
	public static DatabaseCon getInstance() {
		
		return instance; 
	}

	public Connection getCon() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/membershipdatabase?autoReconnect=true&useSSL=false", "root", "border");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

			if (con != null) {
				try {
					System.out.println("Transaction is being rolled back");
					con.rollback();
					con.close();
				
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			
			}
		} 
		 return con;

	}

}
