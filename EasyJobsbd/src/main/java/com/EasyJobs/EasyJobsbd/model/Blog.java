package com.EasyJobs.EasyJobsbd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Blog 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int BlogId;
	@Column
	private String BlogName;
	@Column
	private String BlogTitle;
	@Column
	private String BlogDescription;
	@Column
	private String BlogAuthor;
	@DateTimeFormat @Temporal(value = TemporalType.DATE)
	Date CreatedOn;
	
	
	public int getBlogId() {
		return BlogId;
	}
	public void setBlogId(int blogId) {
		BlogId = blogId;
	}
	public String getBlogName() {
		return BlogName;
	}
	public void setBlogName(String blogName) {
		BlogName = blogName;
	}
	public String getBlogTitle() {
		return BlogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		BlogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return BlogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		BlogDescription = blogDescription;
	}
	public String getBlogAuthor() {
		return BlogAuthor;
	}
	public void setBlogAuthor(String blogAuthor) {
		BlogAuthor = blogAuthor;
	}
	public Date getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn() {
		CreatedOn = new Date();
	}
	
	
	
}
