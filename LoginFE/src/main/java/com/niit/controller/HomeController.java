package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	
	// @Autowired User

		@Autowired
		HttpSession session;

			
	//http://localhost:8080/ShoppingCart/
	
	@RequestMapping("/")
	public ModelAndView goToHome() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting GamePedia! ");
		mv.addObject("isUserAtHomePage", "true");
		// model.addAttribute("message", "Thank you for visiting Shopping Cart!
		// <br>");

				return mv;
		// return "Home";
	}

	@RequestMapping("/Home")
	public ModelAndView goToHomeButton() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isUserAtHomePage", "true");
		
		
		return mv;
		// return "Home";
	}	
	
	
	/*public  String    goToHome(Model model)
	
	{
		model.addAttribute("message", "Thank you for visiting Shopping Cart");
		return "Home";
	}*/
	
	
	@RequestMapping(value="/Login")
	public String loginPage(Model model) {
		model.addAttribute("isUserClickedLogin", "true");

		Long currentTime = System.currentTimeMillis();
		Date currentDate = new Date(currentTime);
		return "Home";
	}
	
	
	
	@RequestMapping("/SignOut")
	public ModelAndView userSignOut() {
		//log.debug("Signout Initiated");
		ModelAndView mv = new ModelAndView("redirect:/");
		session.setAttribute("isUserLoggedIn", "false");
		session.setAttribute("isAdmin", "false");

		return mv;
	}
	
	@RequestMapping("/RegistrationPage")
	public String registerPage(Model model) {
		model.addAttribute("isUserClickedRegistration", "true");
		model.addAttribute("isUserAtHomePage", "false");
		return "Home";
	}


}
