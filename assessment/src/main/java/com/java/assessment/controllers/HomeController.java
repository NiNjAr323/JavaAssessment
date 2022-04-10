package com.java.assessment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String goHome() {

		if (logger.isDebugEnabled()) {
			logger.debug("goHome function from HomeController was used");
		}
		return "redirect:/listpage";
	}

}
