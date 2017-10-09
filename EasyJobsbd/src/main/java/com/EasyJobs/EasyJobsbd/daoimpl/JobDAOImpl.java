package com.EasyJobs.EasyJobsbd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EasyJobs.EasyJobsbd.dao.JobDAO;
import com.EasyJobs.EasyJobsbd.model.Job;
import com.EasyJobs.EasyJobsbd.model.UserCredentials;
import com.EasyJobs.EasyJobsbd.model.Users;


@Repository
public class JobDAOImpl implements JobDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void saveJob(Job job) 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		s.save(job);
		tx.commit();
		s.close();	
	}

	public Job findById(int id) 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Job job=(Job)s.get(Job.class,id);
		tx.commit();
		s.close();
		return job;
	}

	public List<Job> findAllJobs() 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		List<Job> showJob=s.createQuery("From Job").list();
		tx.commit();
		s.close();
		return showJob;
	}

	public void deleteJobById(int id) 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Job job = (Job) s.get(Job.class, id);
		s.delete(job);
		tx.commit();
		s.close();
	}

}
