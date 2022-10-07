package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdate1 {
	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Sarpata@6");
			st = con.createStatement();
			st.addBatch("INSERT INTO Student VALUES(128,'Messi',34)");
			st.addBatch("UPDATE Student SET Name='Messii', Age=35 WHERE id=128");
			st.addBatch("DELETE FROM Student WHERE id=128");
			int[] res = st.executeBatch();
			for(int i:res) {
				System.out.println(i + "Row Affected");
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) con.close();
			if(st!=null) st.close();
		}
		
	}

}
