package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnection {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded and Registered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "Sarpata@6");
			System.out.println("Connection Estabilished");
			System.out.println(conn);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
