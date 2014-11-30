package bu.edu.upark.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import bu.edu.upark.entities.UserAccount;


public interface LoginService {
	public boolean doLogin(HttpServletRequest req,UserAccount userAccount);
	public void printSession(HttpServletRequest req);

}
