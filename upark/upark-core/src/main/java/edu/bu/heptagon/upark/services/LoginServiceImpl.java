package edu.bu.heptagon.upark.services;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import edu.bu.heptagon.upark.dao.UserAccountDAO;
import edu.bu.heptagon.upark.entities.UserAccount;

import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginServiceImpl implements LoginService{
	   @Autowired
	   private UserAccountDAO uad;
       public ModelAndView doLogin(HttpServletRequest req,String username, String password){
    	   UserAccount ua=uad.findUserbyName(username);
    	   ModelAndView mav = new ModelAndView();
    	   if(ua.getPassword().equals(password)){
    		  req.getSession().setMaxInactiveInterval(60*30);
    		  req.getSession().setAttribute("username", username);
    		  req.getSession().setAttribute("password", password);
    		   mav.setViewName("/success.html");
    		   return mav;
    	   }
    	   else{
    		   mav.setViewName("/login.html");
    		   return  mav;
    	   }
    	   
       }
}
