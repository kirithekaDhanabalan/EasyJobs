package com.EasyJobs.EasyJobsbd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FriendRequest 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int FriendId;
	private String SenderName;
	private String ReceiverName;
	@Column
	private boolean status=false;
	
	public int getFriendId() {
		return FriendId;
	}
	public void setFriendId(int friendId) {
		FriendId = friendId;
	}
	public String getSenderName() {
		return SenderName;
	}
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	public String getReceiverName() {
		return ReceiverName;
	}
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
