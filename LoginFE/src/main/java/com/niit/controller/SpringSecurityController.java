package com.niit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDAO;
import com.niit.domain.User;




@Controller
public class SpringSecurityController {

	public static Logger log = LoggerFactory.getLogger(SpringSecurityController.class);

	@Autowired
	private HttpSession session;
	
	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDAO;

	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.debug("Starting of the method loginError");
		session.setAttribute("errorLoginMessage", "Invalid Credentials.  Please try again. ");
		log.debug("Ending of the method loginError");
		return "redirect:/Login";

	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page. ");

		log.debug("Ending of the method accessDenied");
		return "Home";

	}

	@RequestMapping(value = "/checkRole", method = RequestMethod.GET)
	public ModelAndView checkRole(HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("starting of the method validate");
		ModelAndView mv = new ModelAndView("Home");
		// session = request.getSession(true);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		mv.addObject("userList", userDAO.list());
		mv.addObject("user", user);
		//mv.addObject("isUserAtHomePage", "true");
		
		
		String userID = auth.getName();
		session.setAttribute("loggedInUser", userID);
		session.setAttribute("loggedInUserID", userID);
		mv.addObject("successMessage","Welcome "+userID+". ");
		session.setAttribute("successMessage","Welcome "+userID+". ");
		if (request.isUserInRole("ROLE_ADMIN")) {
			log.debug("You are admin");
			mv.addObject("isAdmin", "true");
			session.setAttribute("role", "ROLE_ADMIN");
			session.setAttribute("isAdmin", true);
			mv.addObject("isUserAtHomePage", "false");

		} else {

			log.debug("You are a customer");
			session.setAttribute("isAdmin", false);
			session.setAttribute("isUserLoggedIn", "true");
	
			mv.addObject("isAdmin", "false");
			session.setAttribute("role", "ROLE_USER");
			session.setAttribute("isUserLoggedIn", "true");
			session.setAttribute("loggedInUserID",userID);
			String loggedInUserID = (String) session.getAttribute("loggedInUserID");
			mv.addObject("isUserAtHomePage", "true");
			

		}
		log.debug("Ending of the method validate");
		return mv;
	}

	@RequestMapping("/secure_logout")
	public ModelAndView secureLogout() {
		
		session.invalidate();

		ModelAndView mv = new ModelAndView("redirect:/Login");

				return mv;

	}

}
