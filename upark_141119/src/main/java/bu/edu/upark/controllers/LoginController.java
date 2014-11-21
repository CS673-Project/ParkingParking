package bu.edu.upark.controllers;

import bu.edu.upark.entities.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import bu.edu.upark.services.LoginServiceImpl;



@Controller
@ComponentScan("bu.edu.upark.services")
public class LoginController {
	@Autowired LoginServiceImpl loginService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody UserAccount saveUserRestful( HttpServletRequest req , @RequestBody UserAccount user )   
	{		
		UserAccount uc = new UserAccount();
		uc.setUsername("");
		if (loginService.doLogin(req, user))
		{
			uc.setUsername(user.getUsername());
		}	
		return uc;
	}


}
