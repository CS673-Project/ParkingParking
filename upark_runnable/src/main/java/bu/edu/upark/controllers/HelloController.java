package bu.edu.upark.controllers;



import org.codehaus.jackson.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bu.edu.upark.entities.*;

@Controller
public class HelloController {
	@RequestMapping(value = "/aaa" , method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelMap model) {

		return new ModelAndView("student", "command", new Student());

	}
	

	
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("mvcHelloWorld")Student student, 
	   ModelMap model) {
	      model.addAttribute("name", student.getName());
	      model.addAttribute("age", student.getAge());
	      model.addAttribute("id", student.getId());
	      System.out.println(student.getName());
	      System.out.println(student.getAge());
	      System.out.println(student.getId());
	      
	      return "result";
	}
}
