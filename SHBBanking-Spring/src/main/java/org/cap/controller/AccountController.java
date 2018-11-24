package org.cap.controller;

import java.util.List;

import javax.validation.Valid;

import org.cap.model.Account;
import org.cap.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//@SessionAttributes("customerId")
@Controller
public class AccountController {

	@Autowired
	private IAccountService accountService;
	
	@PostMapping("/createAccount")
	public String createNewAccount(@Valid @ModelAttribute("account") Account account, BindingResult result)  {
		
		if(accountService.createAccount(account))
			return "redirect:/";
		return "redirect:/";
	}
	
	
}
