package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdate2 {
	public static void main(String[] args) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","Sarpata@6");
			st = con.prepareStatement("INSERT INTO Student VALUES(?,?,?)");
			st.setInt(1, 132);
			st.setString(2, "Lionel");
			st.setInt(3, 40);
			st.addBatch();
			st.setInt(1, 133);
			st.setString(2, "Lionel");
			st.setInt(3, 40);
			st.addBatch();
			st.setInt(1, 134);
			st.setString(2, "Lionel");
			st.setInt(3, 40);
			st.addBatch();
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
