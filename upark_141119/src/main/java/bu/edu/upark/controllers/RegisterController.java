package bu.edu.upark.controllers;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bu.edu.upark.entities.UserAccount;
import bu.edu.upark.services.RegisterServiceImpl;

@Controller
public class RegisterController {
	@Autowired
	RegisterServiceImpl RegisterService;
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public UserAccount doRegister( HttpServletRequest req ,@RequestBody UserAccount user){
		
		System.out.println("reg!");
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		
	
		RegisterService.doRegister(req, user);
		
		
		UserAccount uc = new UserAccount();
		
		uc.setUsername(user.getUsername());
		
		return uc;
	}
	

}
