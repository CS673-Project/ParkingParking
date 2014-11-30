package bu.edu.upark.controllers;



import java.util.List;

import bu.edu.upark.entities.*;

import javax.servlet.http.HttpServletRequest;




import javax.servlet.http.HttpSession;

import bu.edu.upark.services.*;
import net.sf.json.JSONObject;

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
import bu.edu.upark.utils.GoogleMapUtils;
import bu.edu.upark.utils.SearchUtils;



@Controller
@ComponentScan("bu.edu.upark.services")
public class PostController {

	
	@Autowired PostServiceImpl postService;
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public @ResponseBody ParkingInfo saveUserRestful( HttpServletRequest req , @RequestBody ParkingInfo parkInfo )   
	{		
		HttpSession session = req.getSession();
		parkInfo.setUsername((String)session.getAttribute("username"));
		
		String searchAddr = "";
		printInfo(parkInfo);
		if(parkInfo.getAddress2() == null)
		{
			searchAddr = parkInfo.getAddress1() +  " " + parkInfo.getArea();
		}
		else
		{
			searchAddr = parkInfo.getAddress1() + " " + parkInfo.getAddress2() + " " + parkInfo.getArea();		
		}
		
		
		System.out.println(searchAddr);
		try {
			JSONObject object = GoogleMapUtils.getInstance().geocodeByAddress(searchAddr);
			String formatedAddr = SearchUtils.getFormattedAddress(object);
	
			System.out.println(formatedAddr);
			
			parkInfo.setAddress1(formatedAddr);
			parkInfo.setAddress2(null);
			
			double[] location = SearchUtils.getLocation(object);
			
			parkInfo.setLattitude(location[0]);
			parkInfo.setLongitude(location[1]);
			
			System.out.println(location[0]);
			System.out.println(location[1]);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
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
		System.out.println(pi.getArea());
		System.out.println(pi.getAddress1());
		System.out.println(pi.getStartTime());
		System.out.println(pi.getEndTime());
		System.out.println(pi.getDate());
		System.out.println(pi.getLattitude());
		System.out.println(pi.getLongitude());
		System.out.println(pi.getUnitPrice());
		
	}


}
