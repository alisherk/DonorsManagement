package com.alsoftware.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class PaymentDaoImpl implements PaymentDao {

	private PreparedStatement ps;
	private Connection con = DatabaseCon.getInstance().getCon();
	private ResultSet rs;

	public PaymentDaoImpl() {

	}
	
	@Override
	public List<Payment> findAllPayments() {
		
		try {
			
			List<Payment> payments = new ArrayList<>(); 
			ps = con.prepareStatement("Select * from Payments");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Payment payment = new Payment(); 
				payment.setPaymentNumber(rs.getString("PaymentNumber"));
				payment.setFirstName(rs.getString("FirstName"));
				payment.setFirstName(rs.getString("LastName"));
				payment.setPaymentAmount(rs.getDouble("PaymentAmount"));
				payments.add(payment); 
			}
			
			return payments; 
		
			
		} catch(SQLException ex) {
			
			ex.printStackTrace();
			
		}
		
		return null;
	}
	
	@Override
	public void insertPayment(Payment payment) {
		try {

			ps = con.prepareStatement("Insert into Payments(PaymentNumber, MemberID, PaymentAmount) Values(?, ?, ?)");
			ps.setString(1, payment.getPaymentNumber());
			ps.setInt(2, payment.getMemberID());
			ps.setDouble(3, payment.getPaymentAmount());

			int i = ps.executeUpdate();

			if (i == 0) {
				System.out.println("Payment is added");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public String readPayment (String paymentNumber) {

		String number = null;

		try {
			ps = con.prepareStatement("Select * from Payments where PaymentNumber=?");
			ps.setString(1, paymentNumber);
			rs = ps.executeQuery();

			if (rs.next()) {

				number = (rs.getString(2));

				return number;

			} else {

				System.out.println("Such payment does not exist in database");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return number;
	}
	
	@Override
	public void deletePayment(Payment payment) {

		try {
			ps = con.prepareStatement("Delete from Payments where PaymentNumber = ?");
			ps.setString(1, payment.getPaymentNumber());

			int i = ps.executeUpdate();

			if (i == 1) {

				System.out.println("Payment is deleted");

			} else {

				System.out.println("This payment does not exist");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void updatePayment(Payment payment) {

		try {

			ps = con.prepareStatement("Update Payments Set PaymentAmount=? where PaymentNumber=?");
			ps.setDouble(1, payment.getPaymentAmount());
			ps.setString(2, payment.getPaymentNumber());

			int i = ps.executeUpdate();

			if (i == 1) {

				System.out.println("Payment is updated");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void searchPayment(String paymentNumber, int memberID) {

		String number = paymentNumber;
		int amount = memberID;

		try {

			HashMap<String, String> map = new HashMap<>();

			if (number != null && number.length() != 0) {
				map.put("PaymentNumber", paymentNumber);
			}

			if (amount != 0) {
				map.put("PaymentAmount", Integer.toString(amount));
			}

			StringBuilder sb = new StringBuilder("Select * from Payments ");
			Set<String> set = map.keySet();
			if (set.size() >= 1) {

				sb.append("Where ");

			} else {

				System.out.println("Please enter a valid search parameter !");
				return;

			}

			int count = 0;
			for (String column : map.keySet()) {

				if (count >= 1) {
					sb.append(" And ");
				}
				sb.append(column);
				sb.append("=?");
				count++;
			}

			ps = con.prepareStatement(sb.toString());

			int i = 1;
			for (String value : map.values()) {

				if (value.equals(number)) {
					ps.setString(i, value);
				}

				if (value.equals(amount)) {
					ps.setString(i, value);

				}

				i++;
			}

			rs = ps.executeQuery();

			if (rs.next()) {

				Payment payment = new Payment();
				payment.setPaymentNumber(rs.getString(2));
				payment.setMemberID(rs.getInt(3));
				payment.setPaymentAmount(rs.getDouble(4));
				System.out.println(
						payment.getPaymentNumber() + " " + payment.getMemberID() + " " + payment.getPaymentAmount());

			}

			else {

				System.out.println("No payment found");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
}
