package bu.edu.upark.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class StartController {
	
	@RequestMapping("/")
	public String home(ModelMap map) {
	        return "index.html";
	}
	

}
