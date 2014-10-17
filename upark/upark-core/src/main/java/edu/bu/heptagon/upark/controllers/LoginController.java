package edu.bu.heptagon.upark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.bu.heptagon.upark.services.LoginServiceImpl;

@Controller
public class LoginController {

    @Autowired LoginServiceImpl loginService;
 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, @RequestParam String username,@RequestParam String password) {
		
        ModelAndView loginView = loginService.doLogin(req,username,password);
		return loginView;
	}
 
 

}
