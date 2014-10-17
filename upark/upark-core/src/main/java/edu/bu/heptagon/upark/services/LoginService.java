package edu.bu.heptagon.upark.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface LoginService {
	public ModelAndView doLogin(HttpServletRequest req,String username, String password);
}
