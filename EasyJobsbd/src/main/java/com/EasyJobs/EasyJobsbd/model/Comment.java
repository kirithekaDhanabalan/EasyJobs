package com.EasyJobs.EasyJobsbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int CommentId;
	@Column
	String CommentDescription;
	@Column
	int BlogId;
	@Column
	int ForumId;
	
	public int getCommentId() {
		return CommentId;
	}
	public void setCommentId(int commentId) {
		CommentId = commentId;
	}
	public String getCommentDescription() {
		return CommentDescription;
	}
	public void setCommentDescription(String commentDescription) {
		CommentDescription = commentDescription;
	}
	public int getBlogId() {
		return BlogId;
	}
	public void setBlogId(int blogId) {
		BlogId = blogId;
	}
	public int getForumId() {
		return ForumId;
	}
	public void setForumId(int forumId) {
		ForumId = forumId;
	}
	
	

}
