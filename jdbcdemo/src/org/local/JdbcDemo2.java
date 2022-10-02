package org.local;

public class JdbcDemo2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded and Registered");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
