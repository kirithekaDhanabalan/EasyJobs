package com.EasyJobs.EasyJobsbd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JustController {
	
	@RequestMapping("/")
	public String goToIndex()
	{
		return "index";
	}

}
