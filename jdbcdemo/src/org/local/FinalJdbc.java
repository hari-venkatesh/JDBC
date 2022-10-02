package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FinalJdbc {
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
			st.execute("CREATE TABLE Student (id INT NOT NULL, Name VARCHAR(50) NOT NULL, Age INT NULL,PRIMARY KEY(id))");
			boolean res = st.execute("INSERT INTO Student VALUES(1, 'Virat',33 )");
			System.out.println(res);
			boolean res1 = st.execute("INSERT INTO Student VALUES(2, 'Yash',30 )");
			System.out.println(res1);
		} catch (ClassNotFoundException | SQLException e) {
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
