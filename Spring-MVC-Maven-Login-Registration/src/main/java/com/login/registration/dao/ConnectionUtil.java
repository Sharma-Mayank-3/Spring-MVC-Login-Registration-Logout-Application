package com.login.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class ConnectionUtil {
	private final String DriverUrl = "com.mysql.cj.jdbc.Driver";
	private final String ConnectionUrl = "jdbc:mysql://localhost/userDB";
	private final String UserName = "root";
	private final String UserPassword = "root";

	public Connection getConnection() throws ClassNotFoundException {
		Class.forName(DriverUrl);
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(ConnectionUrl, UserName, UserPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
