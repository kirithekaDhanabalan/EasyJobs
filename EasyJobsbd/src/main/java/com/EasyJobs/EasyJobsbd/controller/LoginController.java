/*package com.EasyJobs.EasyJobsbd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EasyJobs.EasyJobsbd.dao.UserDAO;
import com.EasyJobs.EasyJobsbd.model.UserRegistration;
import com.EasyJobs.EasyJobsbd.model.Users;

@RestController
public class LoginController 
{
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseEntity<String> login(HttpSession session)
	{
		//UserRegistration userregistration=userDao.findAllUsers(username);
		String username=(String)session.getAttribute("username");
		if(username!=null)
		{	
			return new ResponseEntity<Users>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		
	}
	

}
*/