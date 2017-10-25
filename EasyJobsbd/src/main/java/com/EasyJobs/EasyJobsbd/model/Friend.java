package com.EasyJobs.EasyJobsbd.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Friend 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int FriendsId;
	private String User1;
	private String User2;
	
	public int getFriendsId() {
		return FriendsId;
	}
	public void setFriendsId(int friendsId) {
		FriendsId = friendsId;
	}
	public String getUser1() {
		return User1;
	}
	public void setUser1(String user1) {
		User1 = user1;
	}
	public String getUser2() {
		return User2;
	}
	public void setUser2(String user2) {
		User2 = user2;
	}
	
	
}
