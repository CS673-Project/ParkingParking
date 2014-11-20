package bu.edu.upark.controllers;



import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import bu.edu.upark.entities.*;

import javax.servlet.http.HttpServletRequest;




import javax.servlet.http.HttpSession;

import bu.edu.upark.services.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bu.edu.upark.services.LoginServiceImpl;



@Controller
@ComponentScan("bu.edu.upark.services")
public class LoginController {

	
	@Autowired LoginServiceImpl loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody UserAccount saveUserRestful( HttpServletRequest req , @RequestBody UserAccount user )   
	{		
		
		if (loginService.doLogin(req, user.getUsername(), user.getPassword()))
		{
			HttpSession session = req.getSession();
			session.setAttribute("username" , user.getUsername());
		}
		
		//loginService.printSession(req);
		
		UserAccount uc = new UserAccount();
		
		uc.setUsername(user.getUsername());

		return uc;

	}


}
