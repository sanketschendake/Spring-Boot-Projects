package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.model.User;
import com.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
	
	@Autowired
	private UserService repo;
	
	@PostMapping("/register")
	public String userRegistration(@ModelAttribute User user, Model model)
	{
		System.out.println(user);
		
		User userInserted1 = repo.storeData(user);
		
		model.addAttribute("msg", user.getEmail() + " inserted");
		return "welcome";
	}
	
	@GetMapping("/openLoginPage")
	public String openLoginPage()
	{
		return "openLoginPage";
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model)
	{	
		User userData = repo.findByEmail(user.getEmail());
		
		if(userData.getPasswd().equals(user.getPasswd())
				&& userData.getEmail().equals(user.getEmail()))
		{
			model.addAttribute("email", user.getEmail());
			return "home";
		}
		else
		{
			return "error";
		}
		
	}
	
	@PostMapping("/logout")
	public String logoutUser(HttpServletRequest request, HttpServletResponse response)
	{
		return "redirect:/index";
	}
}
