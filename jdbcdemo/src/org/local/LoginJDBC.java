package org.local;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginJDBC {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String name = sc.next();
		System.out.println("Enter Your Password: ");
		String pass = sc.next();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_jdbc","root","Sarpata@6");
			pst = con.prepareStatement("SELECT * FROM user WHERE name=? and password=?");
			pst.setString(1, name);
			pst.setString(2, pass);
			res = pst.executeQuery();
			if(res.next()) {
				System.out.println("Welcome Mr."+ res.getInt(1));
			} else {
				System.err.println("Invalid Credentials");
			}
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(con!=null) con.close();
			if(pst!=null) pst.close();
			if(res!=null) res.close();
			sc.close();
			}
	}

}
