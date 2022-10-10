package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCRUD {
	
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_jdbc","root","Sarpata@6");
		return con;
	}
	
	public void closeResource(Connection con, PreparedStatement pst, ResultSet res) throws Exception {
		if(con!=null) con.close();
		if(pst!=null) pst.close();
		if(res!=null) res.close();
	}
	
	public void saveUser(User u) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = getConnection();
			pst = con.prepareStatement("INSERT INTO User VALUES(?, ?, ?)");
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setString(3, u.getPassword());
			int r = pst.executeUpdate();
			System.out.println(r+" User Saved Succesfully");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			closeResource(con, pst, null);
		}
	}
	
	public void readUser(User u) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		try{
			con = getConnection();
			pst = con.prepareStatement("SELECT * FROM User WHERE id=?");
			pst.setInt(1, u.getId());
			res = pst.executeQuery();
			while(res.next()) {
				System.out.println("Hello "+ res.getString(2));
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			closeResource(con, pst, res);
		}
	}
	
	public void updateUser(User u) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = getConnection();
			pst = con.prepareStatement("INSERT INTO User VALUES(?, ?, ?)");
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setString(3, u.getPassword());
			int r = pst.executeUpdate();
			System.out.println(r+" User Saved Succesfully");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			closeResource(con, pst, null);
		}
	}
	
	public void deleteUser(User u) throws Exception {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = getConnection();
			pst = con.prepareStatement("INSERT INTO User VALUES(?, ?, ?)");
			pst.setInt(1, u.getId());
			pst.setString(2, u.getName());
			pst.setString(3, u.getPassword());
			int r = pst.executeUpdate();
			System.out.println(r+" User Saved Succesfully");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			closeResource(con, pst, null);
		}
	}

}
