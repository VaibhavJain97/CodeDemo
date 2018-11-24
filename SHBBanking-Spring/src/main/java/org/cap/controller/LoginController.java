package org.cap.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.cap.model.LoginBean;
import org.cap.model.RegisterBean;
import org.cap.service.ILoginService;
import org.cap.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IRegisterService registerService;
	
	@RequestMapping("/")
	public ModelAndView getIndexPage()	{
		return new ModelAndView("index","login", new LoginBean());
	}

	@RequestMapping("/validateLogin")
	public String validateLogin(@ModelAttribute("login") LoginBean loginBean,
			HttpSession session) {
		LoginBean loginData= loginService.IsValidLogin(loginBean);
		if(loginData!=null) 	{
			session.setAttribute("custId", loginData.getUserId());
			return "mainpage";
		}
		else
			return "redirect:/";
	}

}
