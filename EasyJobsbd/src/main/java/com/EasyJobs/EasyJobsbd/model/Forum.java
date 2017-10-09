package com.EasyJobs.EasyJobsbd.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forum 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    int ForumId;
	private String ForumTitle;
    private String ForumDescription;
	
	
	public int getForumId() {
		return ForumId;
	}
	public void setForumId(int forumId) {
		ForumId = forumId;
	}
	public String getForumTitle() {
		return ForumTitle;
	}
	public void setForumTitle(String forumTitle) {
		ForumTitle = forumTitle;
	}
	public String getForumDescription() {
		return ForumDescription;
	}
	public void setForumDescription(String forumDescription) {
		ForumDescription = forumDescription;
	}
	
	
}
