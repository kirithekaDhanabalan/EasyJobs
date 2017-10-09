package com.EasyJobs.EasyJobsbd.dao;

import java.util.List;

import com.EasyJobs.EasyJobsbd.model.Job;

public interface JobDAO 
{
 public void saveJob(Job job);
 
 public Job findById(int id);
 
 public List<Job> findAllJobs();

public void deleteJobById(int id);
 
}
