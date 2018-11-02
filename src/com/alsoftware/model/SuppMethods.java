package com.alsoftware.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuppMethods {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con = DatabaseCon.getInstance().getCon();
	
    public boolean checkID(String ID) throws SQLException {


		try {
			ps = con.prepareStatement("Select * from Donors where DonorNumber=?");
			ps.setString(1, ID);
			rs = ps.executeQuery();

			if (rs.next()) {
				
				return true;

			} 

		} catch (SQLException e) {

			e.printStackTrace();

		} 
		return false;
	}
	
	public Member extractMemberFromRs(ResultSet rs) throws SQLException {
	
        Member member = new Member();
		member.setMemberNumber(rs.getString("DonorNumber"));
		member.setType(rs.getString("Type"));
		member.setFirstName(rs.getString("FirstName"));
		member.setLastName(rs.getString("LastName"));
		member.setStreetAddress(rs.getString("StreetAddress"));
		member.setCity(rs.getString("City"));
		member.setProvince(rs.getString("Province"));
		member.setPostalCode(rs.getString("PostalCode"));
		member.setEmail(rs.getString("Email"));
		member.setPhone(rs.getString("Phone"));
		member.setComment(rs.getString("Comment"));
		return member;
	}
}
