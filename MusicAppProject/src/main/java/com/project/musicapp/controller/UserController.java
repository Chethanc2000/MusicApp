package com.project.musicapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.musicapp.entity.User;
import com.project.musicapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {
		// check user with the email id is present or not
		boolean userExists = userService.emailExists(user);

		if (userExists == false) {
			userService.saveUser(user);
			System.out.println("User added successfully");
		} else {
			System.out.println("Duplicate user");
		}

		return "login";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password) {
		if(userService.validUser(email,password) == true) {
			
			String role = userService.getRole(email);
			
			if(role.equals("admin")) {
				return "adminhome";
			}else {
				return "customerhome";
			}
		}
		else {
			return "login";
		}
	

	}
	
	@GetMapping("/logout")
	public String login(HttpSession session) {
		session.invalidate();
		return "login";
		
	}

}
