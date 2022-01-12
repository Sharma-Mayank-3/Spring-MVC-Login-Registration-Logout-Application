package com.login.registration.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.login.registration.dao.UserDataBaseDao;
import com.login.registration.model.LoginModel;
import com.login.registration.model.UserModel;

@Controller
public class LoginRegistrationController {
	
	
	private UserDataBaseDao userDataBaseDao;

	@RequestMapping("/")
	public String login() {
		return "/WEB-INF/view/login.jsp";
	}
	
	@RequestMapping("/register")
	public String registration() {
		return "/WEB-INF/view/registration.jsp";
	}
	
	@RequestMapping("/insert")
	public String insertUser(UserModel userModel, Model model) {
		userDataBaseDao = new UserDataBaseDao();
		try {
			if(userDataBaseDao.insertNewUser(userModel)) {
				model.addAttribute("nope", "Registration Succesful");
				return "/WEB-INF/view/login.jsp";
			}else {
				model.addAttribute("nope", "Registration Failed"); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/WEB-INF/view/registration.jsp";
	}
	
	@RequestMapping("/validate")
	public String validateUserLogin(LoginModel loginModel, Model model) {
		UserModel validateUser;
		userDataBaseDao = new UserDataBaseDao();
		try {
			validateUser = userDataBaseDao.validateUser(loginModel);
			if(validateUser != null) {
				model.addAttribute("user", validateUser);
				return "/WEB-INF/view/home.jsp";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("nope", "something went wrong");
		return "/WEB-INF/view/login.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/WEB-INF/view/login.jsp";
	}
	
}
