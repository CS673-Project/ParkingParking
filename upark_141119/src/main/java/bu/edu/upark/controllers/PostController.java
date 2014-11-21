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
public class PostController {

	
	//@Autowired 
	PostService postService;

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public @ResponseBody ParkingInfo saveUserRestful( HttpServletRequest req , @RequestBody ParkingInfo parkInfo )   
	{		
		
		if(postService.doPost(req, parkInfo))
		{
			return parkInfo;
		}
		else
		{
		
			return null;
		}

	}
	
	private void printInfo(ParkingInfo pi)
	{
		System.out.println(pi.getInfoId());
		System.out.println(pi.getUsername());
		System.out.println(pi.getZipcode());
		System.out.println(pi.getCity());
		System.out.println(pi.getAddress());
		System.out.println(pi.getFromTime());
		System.out.println(pi.getEndTime());
		System.out.println(pi.getRentDate());
		System.out.println(pi.getLattitude());
		System.out.println(pi.getLongitude());
		
	}


}
