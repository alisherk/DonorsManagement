package com.alsoftware.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DatabaseCon.getInstance().getCon();
			ps = con.prepareStatement("Select UserName, Password from Users where UserName = ? and Password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return true;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

		} return false;
	}
}
