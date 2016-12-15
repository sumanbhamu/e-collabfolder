package com.suman.Controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.suman.ecom.dao.UserDAO;
import com.suman.ecom.model.User;

@Controller
public class HomeController {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	User user;

	@RequestMapping("/")
	public String showHome() {
		return "index";
	}

	@RequestMapping("/index")
	public String ShowHome() {
		return "index";
	}

	@RequestMapping("/aboutus")
	public String showAboutUs() {
		return "aboutus";
	}

	@RequestMapping("/login")
	public String showLogin() {
		System.out.println("loginnnnnnnn");

		return "login";
	}

	@RequestMapping("/logout")
	public String showLogout() {
		System.out.println("logooout");

		return "index";
	}

	@RequestMapping("/perform_logout")
	public ModelAndView showLogout(HttpServletRequest request, HttpSession session) {
		System.out.println("logouuut");
		ModelAndView mv = new ModelAndView("index");
		session.invalidate();
		session = request.getSession(true);
		// Category category=new Category();
		mv.addObject("logOutMessage", "u hv successfully logged out..");
		mv.addObject("loggedOut", "true");

		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView ShowRegister(@ModelAttribute("us") User user, BindingResult result,
			HttpServletRequest request) {
		System.out.println("registerrrr");
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	@ModelAttribute
	public User returnObject() {
		return new User();
	}

	@RequestMapping(value = "/addus", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) {
		System.out.println(user.getConfirmpassword());
		System.out.println(user.getPassword());

		user.setEnabled("true");
		user.setRole("ROLE_USER");

		if (user.getConfirmpassword().equals(user.getPassword())) {
			userDAO.saveOrUpdate(user);
		}

		return "login";

	}

	/* security check for login */

	@RequestMapping(value = "/login_session_attributes")
	/* getting values from textbox */

	public String login_session_attributes(HttpSession session, Model model,
			@RequestParam(value = "username") String id) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

		System.out.println("inside security check");

		session.setAttribute("name", name);
		System.out.println(name);

		user = userDAO.get(id);
		int x = user.getUser_id();
		session.setAttribute("loggedInUser", user.getUsername());

		session.setAttribute("loggedInUserID", x);

		session.setAttribute("LoggedIn", "true");

		@SuppressWarnings("unchecked")
		/* getting values from database */
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();

		String role = "ROLE_USER";
		for (GrantedAuthority authority : authorities) {
			/* comparing both the values from txtbox and database */
			if (authority.getAuthority().equals(role)) {
				System.out.println(role);

				return "index";
			} else {
				session.setAttribute("isAdmin", "true");
			}
		}
		return "adminhome";

	}

}
