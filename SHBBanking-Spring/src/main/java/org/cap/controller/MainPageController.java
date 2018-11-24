package org.cap.controller;

import org.cap.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

	@RequestMapping("/titlePage")
	public String displayIFrameContent() {
		return "titlePage";
	}
	
	@RequestMapping("/createAccountPage")
	public String createAccountPage() {
		
		return "createAccount";
	}
	
}
