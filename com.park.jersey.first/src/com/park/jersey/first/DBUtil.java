package com.park.jersey.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/parks";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Mphasis@99";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println(" Driver loaded");	
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading Driver");
			e.printStackTrace();
		}
	}
	
	public static Connection connect() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
		} catch (SQLException e) {
			System.err.println("Error getting connection");
			e.printStackTrace();
		}
		
		return con;
	}
	
	
}

