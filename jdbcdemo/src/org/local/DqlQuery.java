package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DqlQuery {
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		Statement st=null;
		ResultSet res=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded and Registered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", 
					"root", "Sarpata@6");
			System.out.println("Connection Estabilished");
			System.out.println(conn);
			st = conn.createStatement();
			res = st.executeQuery("SELECT * FROM Student");
			System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
			}
			if(st!=null) {
				st.close();
			}
			if(res!=null) {
				res.close();
			}
		}

	}

}
