package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetStudents {
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		Statement st=null;
		ResultSet res=null;
		ResultSet ress=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", 
					"root", "Sarpata@6");
			st = conn.createStatement();
			res = st.executeQuery("SELECT * FROM Student");
//			ress = st.executeQuery("SELECT * FROM Student");
			System.out.println("ID    Name    Age");
			while(res.next()) {
				System.out.println(res.getInt("id")+"    "+res.getString("Name")+"    "+res.getInt("Age"));
			}
			System.out.println();
//			System.out.println("ID    Name    Age");
//			while(ress.next()) {
//				System.out.println(ress.getInt(1)+"    "+ress.getString(2)+"    "+ress.getInt(3));
//			}
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
			if(ress!=null) {
				ress.close();
			}
		}

	}


}
