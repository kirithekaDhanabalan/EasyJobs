package com.EasyJobs.EasyJobsbd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EasyJobs.EasyJobsbd.dao.ForumDAO;
import com.EasyJobs.EasyJobsbd.model.Blog;
import com.EasyJobs.EasyJobsbd.model.Forum;
import com.EasyJobs.EasyJobsbd.model.Job;

@Repository
public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public void saveForum(Forum forum) 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		s.save(forum);
		tx.commit();
		s.close();		
	}


	public List<Forum> findAllForum() 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		List<Forum> showForum=s.createQuery("From Forum").list();
		tx.commit();
		s.close();
		return showForum;
	}

	public Forum findById(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
        Forum forum=(Forum)s.get(Forum.class,id);
		tx.commit();
		s.close();
		return forum ;
	}

	public void deleteForumById(int id) 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
        Forum forum = (Forum) s.get(Forum.class, id);
		s.delete(forum);
		tx.commit();
		s.close();	
	}

}
