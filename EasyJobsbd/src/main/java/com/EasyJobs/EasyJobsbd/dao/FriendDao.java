package com.EasyJobs.EasyJobsbd.dao;

import java.util.List;

import com.EasyJobs.EasyJobsbd.model.Friend;
import com.EasyJobs.EasyJobsbd.model.FriendRequest;
import com.EasyJobs.EasyJobsbd.model.Users;

public interface FriendDAO 
{
	public List<Users> suggestedUsers(String username);
	public boolean sendFriendRequest(String receiverName,String sendername);
	public boolean addAsFriend(String receiverName,String sendername);
	public boolean updatePendingRequest(int id);
	public void deleteRequest(String name);
	public List<FriendRequest> friendRequestPending(String username);
	public FriendRequest singleRequest(int id);
	List<Friend> listOfFriends(String username);
}
