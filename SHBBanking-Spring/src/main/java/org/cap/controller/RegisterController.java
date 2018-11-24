package org.cap.controller;

import java.util.List;

import javax.validation.Valid;

import org.cap.model.RegisterBean;
import org.cap.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	private RegisterBean register;
	
	@Autowired
	private IRegisterService registerService;
	private boolean flag;
	
	//@RequestMapping(value="/registerForm", method=RequestMethod.POST)
	@PostMapping("/registerForm")	//from SPRING 4 onwards
	public String registerDetails(
			@Valid @ModelAttribute("register") RegisterBean registerBean,
			BindingResult result)	{
		if(result.hasErrors())
			{
				return "register";}
		else
		{
			if(!flag)
				{
					if(registerService.registerDetails(registerBean))
						return "redirect:registerRedirect";
				}
			else
				{
					registerService.updateRegistration(registerBean);
					flag=false;
					return "redirect:registerRedirect";
				}
			
		}
		return "register";
	}
	
	@RequestMapping("/registerRedirect")
	public String showRegistrationPage(ModelMap map)
	{
		List<RegisterBean> registers= registerService.getAllRegistrations();
		String buttonLabel="Update";
		
		if(!flag) {
			buttonLabel="Register";
			map.addAttribute("register", new RegisterBean());
		}
		else
		{
			map.addAttribute("register",register);
		}
		
		map.addAttribute("buttonLabel",buttonLabel);
		map.addAttribute("registers", registers);
		map.addAttribute("flag", flag);
		return "register";
	}
	
	@RequestMapping("/delete/{customerId}")
	public String deleteRegistration(@PathVariable("customerId") Long customerId)	{
		
		registerService.deleteRegistration(customerId);
		return "redirect:/registerRedirect";
	}
	
	@RequestMapping("/edit/{customerId}")
	public String editRegistration(@PathVariable("customerId") Long customerId) {
		
		flag=true;
		register=registerService.findRegistration(customerId);
		return "redirect:/registerRedirect";
	}
	
}
