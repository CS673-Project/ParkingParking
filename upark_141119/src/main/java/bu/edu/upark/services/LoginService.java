package bu.edu.upark.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


public interface LoginService {
	public boolean doLogin(HttpServletRequest req,String username, String password);
	public void printSession(HttpServletRequest req);

}
