package com.EasyJobs.EasyJobsbd.dao;

import java.util.List;

import com.EasyJobs.EasyJobsbd.model.Forum;

public interface ForumDAO 
{
 public void saveForum(Forum forum);
 public void deleteForumById(int id);
 public List<Forum> findAllForum();
 public Forum findById(int id);
 
}
