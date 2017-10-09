package com.EasyJobs.EasyJobsbd.dao;

import java.util.List;

import com.EasyJobs.EasyJobsbd.model.Blog;
import com.EasyJobs.EasyJobsbd.model.Users;

public interface BlogDAO 
{
	public boolean saveBlog(Blog blog);
    public void deleteBlogById(int id);
    public List<Blog> findAllBlog();
    public Blog findById(int id);
   
}
