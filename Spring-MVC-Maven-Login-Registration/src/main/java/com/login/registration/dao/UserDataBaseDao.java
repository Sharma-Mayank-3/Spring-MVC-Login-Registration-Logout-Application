package com.login.registration.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.login.registration.model.LoginModel;
import com.login.registration.model.UserModel;

@Repository
public class UserDataBaseDao {
	
	private final String InsertUser = "insert into user (name, password, email, country) values(?, ?, ?, ?)";
	private final String ValidateUser = "select * from user where name = ? and password = ?";
	
	public boolean insertNewUser(UserModel userModel) throws SQLException {
		ConnectionUtil con = new ConnectionUtil();
		boolean b = false;
		try {
			Connection connection = con.getConnection();
			
			PreparedStatement prepareStatement = connection.prepareStatement(InsertUser);
			prepareStatement.setString(1, userModel.getName());
			prepareStatement.setString(2, userModel.getPassword());
			prepareStatement.setString(3, userModel.getEmail());
			prepareStatement.setString(4, userModel.getCountry());
			
			System.out.println(userModel.toString());
			
			b = prepareStatement.executeUpdate() > 0;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	
	public UserModel validateUser(LoginModel loginModel) throws SQLException {
		ConnectionUtil con = new ConnectionUtil();
		UserModel userModel = null;
		try {
			Connection connection = con.getConnection();
			
			PreparedStatement prepareStatement = connection.prepareStatement(ValidateUser);
			prepareStatement.setString(1, loginModel.getUserName());
			prepareStatement.setString(2, loginModel.getPassword());
			
			ResultSet result = prepareStatement.executeQuery();
			
			while(result.next()) {
				String name = result.getString("name");
				String password = result.getString("password");
				String email = result.getString("email");
				String country = result.getString("country");
				userModel = new UserModel(name, password, email, country);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userModel;
	}
	
}
