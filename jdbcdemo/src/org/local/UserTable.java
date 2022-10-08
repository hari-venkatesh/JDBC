package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable {
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded and Registered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_jdbc", "root", "Sarpata@6");
			System.out.println("Connection Estabilished");
			System.out.println(conn);
			st = conn.createStatement();
			st.execute("CREATE TABLE User (id INT NOT NULL, Name VARCHAR(50) NOT NULL, Password VARCHAR(40) NULL,PRIMARY KEY(id))");
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
				System.out.println("Connection Closed");
			}
			if(st!=null) {
				st.close();
				System.out.println("Statement Closed");
			}
		}

	}
}
