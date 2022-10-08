package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserCRUD {
	public void saveUser(User u) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_jdbc","root","Sarpata@6");
			pst = con.prepareStatement("INSERT INTO User VALUES(?, ?, ?)");
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setString(3, u.getPassword());
			int r = pst.executeUpdate();
			System.out.println(r+" User Saved Succesfully");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) con.close();
			if(pst!=null) pst.close();
		}
	}

}
