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

import bu.edu.upark.repositories.ParkingInfoDAO;
import bu.edu.upark.services.*;
import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONValue;
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
@ComponentScan("bu.edu.upark.repositories")
public class SearchController {
	SearchService searchService;
	String userinput;
	double lat1;
	double lat2;

	double lng1;
	double lng2;
	double[] NorthEast = new double[2];
	double[] SouthWest = new double[2];
	double[] NewNorthEast = new double[2];
	double[] NewSouthWest = new double[2];

	@Autowired
	ParkingInfoDAO pid;

	@RequestMapping(value = "/search", method = RequestMethod.POST)

	public @ResponseBody ParkingInfoList saveUserRestful(

			HttpServletRequest req, @RequestBody UserInput userInput) {
		System.out.println(userInput.getAddress());
		
		ParkingInfoList al = new ParkingInfoList();

		List<ParkingInfo> results = pid.findAll();

		userinput = userInput.getAddress();
		JSONObject bean;
		try {
			bean = GoogleMapUtils.getInstance().geocodeByAddress(userinput);
			NorthEast = SearchUtils.getNorthEast(bean);
			SouthWest = SearchUtils.getSouthWest(bean);
			NewNorthEast = SearchUtils.getNewNorthEest(NorthEast);
			NewSouthWest = SearchUtils.getNewSouthWest(SouthWest);
			
			lat1 = NewSouthWest[0];
			lat2 = NewNorthEast[0];
			lng1 = NewNorthEast[1];
			lng2 = NewSouthWest[1];
			
			System.out.println(lat1);
			System.out.println(lat2);
			System.out.println(lng1);
			System.out.println(lng2);
			
			
			for (ParkingInfo result : results) {
				if (result.getLattitude() <= lat2
						&& result.getLattitude() >= lat1
						&& result.getLongitude() <= lng1
						&& result.getLongitude() >= lng2) {
					al.getList().add(result);
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsString = JSONValue.toJSONString(al);
		System.out.println("^^^^"+jsString);
		JSONObject markers = JSONObject.fromObject(jsString);
		return markers;

	}

}
