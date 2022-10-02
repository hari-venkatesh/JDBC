package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded and Registered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "Sarpata@6");
			System.out.println("Connection Estabilished");
			System.out.println(conn);
			st = conn.createStatement();
			int u = st.executeUpdate("UPDATE Student SET Name='Rohit', Age=36 WHERE id=1");
			System.out.println(u+" Row Affected");
			int d = st.executeUpdate("DELETE FROM Student WHERE id=1");
			System.out.println(d+" Row Affected");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
			}
			if(st!=null) {
				st.close();
			}
		}

	}

}
