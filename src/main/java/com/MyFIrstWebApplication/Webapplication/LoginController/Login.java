package com.MyFIrstWebApplication.Webapplication.LoginController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class Login {

	/*
	 * private Authentication auth;
	 * 
	 * @Autowired public Login(Authentication auth) { super(); this.auth = auth; }
	 * 
	 * @RequestMapping(value = "login", method = RequestMethod.GET) public String
	 * userLogin() { // model.put("na", name); return "login"; }
	 * 
	 */
	@RequestMapping(value = "/")
	public String userWelcome(// @RequestParam String name, @RequestParam String password,
			ModelMap model) {

		/*
		 * if (auth.getUserAuth(name, password)) { model.put("name", name); return
		 * "welcome";
		 * 
		 * }
		 */
		model.put("name", getUsername());
		return "welcome";

	}

	private String getUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();

	}

}
