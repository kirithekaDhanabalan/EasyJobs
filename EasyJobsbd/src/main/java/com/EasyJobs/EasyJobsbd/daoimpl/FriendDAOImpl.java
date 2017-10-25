package com.EasyJobs.EasyJobsbd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EasyJobs.EasyJobsbd.dao.FriendDAO;
import com.EasyJobs.EasyJobsbd.dao.UserDAO;
import com.EasyJobs.EasyJobsbd.model.Forum;
import com.EasyJobs.EasyJobsbd.model.Friend;
import com.EasyJobs.EasyJobsbd.model.FriendRequest;
import com.EasyJobs.EasyJobsbd.model.Users;
import com.sun.org.apache.bcel.internal.generic.IFNONNULL;

@Repository
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserDAO userDAO;

	public List<Users> suggestedUsers(String username) {
		
		List<Users> showuser = userDAO.usersExceptLoggedIn(username);
		List<Friend> alreadyfriend=listOfFriends(username);
		List<Users> suggesteduser = null;
		int count=0;
		for(Users u:showuser)
		{
		for(Friend f:alreadyfriend)
		{
			if(u.getUsername().equals(f.getUser1()))
			{
				count=count+1;
			}
		}
		}
		
		if(suggesteduser==null)
		{
			suggesteduser=showuser;
		}
		return suggesteduser;
	}

	public List<FriendRequest> friendRequestPending(String username) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Criteria c=s.createCriteria(FriendRequest.class);
		c.add(Restrictions.eq("ReceiverName", username));
		List<FriendRequest> myFriends=c.list();
		tx.commit();
		s.close();
		return myFriends;
	}

	public List<Friend> listOfFriends(String username) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Criteria c=s.createCriteria(Friend.class);
		c.add(Restrictions.eq("user1", username));
		List<Friend> myFriends=c.list();
		tx.commit();
		s.close();
		return myFriends;
	}

	public void deleteRequest(String name) {
		// TODO Auto-generated method stub
		/*try{
			Session s = sessionFactory.openSession();
			Transaction tx = s.getTransaction();
			tx.begin();
			FriendRequest friend=new FriendRequest();
			if(FriendRequest.status()==true)
				s.update(friend);
			else
				s.delete(friend);
			
			tx.commit();
			s.close();
			}
			catch (Exception e) {
				
			}
		*/
	}

	public boolean sendFriendRequest(String receiverName,String sendername) {
		try {
			Session s = sessionFactory.openSession();
			Transaction tx = s.getTransaction();
			tx.begin();
			FriendRequest friendRequest=new FriendRequest();
			friendRequest.setReceiverName(receiverName);
			friendRequest.setSenderName(sendername);
			s.save(friendRequest);
			tx.commit();
			s.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public boolean addAsFriend(String receiverName,String sendername) {
		try {
			Session s = sessionFactory.openSession();
			Transaction tx = s.getTransaction();
			tx.begin();
			Friend friend=new Friend();
			friend.setUser1(sendername);
			friend.setUser2(receiverName);
			s.save(friend);
			friend=new Friend();
			friend.setUser1(receiverName);
			friend.setUser2(sendername);
			s.save(friend);
			tx.commit();
			s.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
			
	}

	public FriendRequest singleRequest(int id) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		FriendRequest friendrequest=(FriendRequest)s.get(FriendRequest.class,id);
		tx.commit();
		s.close();
		return friendrequest;

	}

	public boolean updatePendingRequest(int id) {
		
			Session s = sessionFactory.openSession();
			Transaction tx = s.getTransaction();
			tx.begin();
			FriendRequest friendrequest = (FriendRequest) s.get(FriendRequest.class,id);
			friendrequest.setStatus(true);   
			s.update(friendrequest);
			tx.commit();
			s.close();
			return true;
		
	}
	
}
