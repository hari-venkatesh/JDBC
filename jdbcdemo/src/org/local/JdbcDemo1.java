package org.local;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JdbcDemo1 {

	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Loaded and Registered");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
