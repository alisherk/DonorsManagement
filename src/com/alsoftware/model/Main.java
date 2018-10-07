package com.alsoftware.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.BiConsumer;

public class Main {

	public static void main(String[] args) throws SQLException {

		Connection con = DatabaseCon.getInstance().getCon();
		PreparedStatement ps = con.prepareStatement("Select * from Members");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			System.out.println("There is a record");

		}

	}

	public static void process(int[] numbers, int key, BiConsumer<Integer, Integer> cons) {

		for (int i : numbers) {
			cons.accept(i, key);
		}
	}

	public static BiConsumer<Integer, Integer> catchLambda(BiConsumer<Integer, Integer> cons) {

		return (a, b) -> {

			try {

				cons.accept(a, b);

			} catch (Exception ex) {

				ex.printStackTrace();
			}

		};
	}
}
