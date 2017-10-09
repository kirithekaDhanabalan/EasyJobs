package com.EasyJobs.EasyJobsbd.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EasyJobs.EasyJobsbd.model.UserCredentials;
import com.EasyJobs.EasyJobsbd.model.UserRegistration;
import com.EasyJobs.EasyJobsbd.model.Users;
 

public interface UserDAO 
{
	public Users findByName(String name);
    
	public void saveUser(Users user);
     
    public void updateUser(Users user);
     
    public void deleteUserById(String name);
 
    public List<Users> findAllUsers(); 
     
   public boolean isUserExist(String name);
   
   public boolean check(String name,String Password);
}
