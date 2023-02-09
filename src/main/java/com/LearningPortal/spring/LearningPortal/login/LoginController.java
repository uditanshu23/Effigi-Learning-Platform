package com.LearningPortal.spring.LearningPortal.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class LoginController {

	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;

	}

	@GetMapping("learn")
	public String gotoLoginPage() {
		return "login";
	}

	@PostMapping("learn")
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (authenticationService.authenticate(name, password)) {

			model.put("name", name);
			return "welcome";
		}

		model.put("errorMessage", "Invalid Credentials! Please try again.");
		return "login";
	}

}
