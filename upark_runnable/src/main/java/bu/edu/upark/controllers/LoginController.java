package bu.edu.upark.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import bu.edu.upark.entities.*;

import javax.servlet.http.HttpServletRequest;





import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller

public class LoginController {

	@RequestMapping(value = "/login/abc", method = RequestMethod.PUT)
	
	@ResponseBody
	public String saveUserRestful( /*@RequestBody User user , HttpServletRequest request */)   
	{		
		//
		// Code processing the input parameters
		//	
		System.out.println("aaaaaa");
		
		//System.out.println(username);
		//System.out.println(user.getPassword());
		//String response = "{\"message\":\"Post With ngResource: The user username: " + user.getUsername() + ", password: " + user.getPassword();
		return "index";
	}

}
