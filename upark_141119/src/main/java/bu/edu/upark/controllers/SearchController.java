package bu.edu.upark.controllers;
import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
import bu.edu.upark.utils.*;

@Controller
@ComponentScan("bu.edu.upark.services")
public class SearchController {
	SearchService searchService;
	String userinput;
	double lat1;
	double lat2;
	
	double lng1;
	double lng2;
	double[] NorthEast = new double[2];
    double[] SouthWest = new double[2];
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody List<ParkingInfo> saveUserRestful( HttpServletRequest req , @RequestBody UserInput userInput)    
	{		
		ParkingInfo pi = new ParkingInfo();
		List<ParkingInfo> al = new ArrayList<ParkingInfo>();
		if(searchService.doSearch(req, userInput))
		{
			List<ParkingInfo> results = new ArrayList<ParkingInfo>();
			userinput = userInput.getUserInput();
			JSONObject bean;
			try {
				bean = GoogleMapUtils.getInstance().geocodeByAddress(userinput);
	            NorthEast = SearchUtils.getNorthEast(bean);
	            SouthWest = SearchUtils.getSouthWest(bean);
	            lat1 = SouthWest[0];
	            lat2 = NorthEast[0];	            
	            lng1 = NorthEast[1];
	            lng2 = SouthWest[1];
	            for(ParkingInfo result:results) {
	            	if(result.getLattitude() <= lat2 && result.getLattitude() >= lat1 && 
	            			result.getLongitude() <= lng2 && result.getLongitude() >= lat1) {
	            		al.add(result);
	            	}
	            	
	            }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	
			pi.setUsername(pi.getUsername());
			return al;
		}
		else
		{
			return null;
		}

	}

}
