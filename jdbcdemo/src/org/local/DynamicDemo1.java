package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicDemo1 {
	public static void main(String[] args) throws Exception {
		Connection conn=null;
		PreparedStatement pst=null;
		String qry="INSERT INTO Student VALUES(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", 
					"root", "Sarpata@6");
			pst=conn.prepareStatement(qry);
			pst.setInt(1, 11);
			pst.setString(2, "Hari");
			pst.setInt(3, 22);
			pst.execute();
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				conn.close();
			}
			if(pst!=null) {
				pst.close();
			}
		}

	}

}
			


