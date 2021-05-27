package com.cyber.springsecureboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/cyber")
	public String getDeveloper()
	{
		return "index.jsp";
	}

}
