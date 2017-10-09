package com.EasyJobs.EasyJobsbd.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.EasyJobs.EasyJobsbd.dao.BlogDAO;
import com.EasyJobs.EasyJobsbd.model.Blog;
@Repository
public class BlogDAOImpl implements BlogDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveBlog(Blog blog) 
	{
		//blog.setCreatedOn();
		try
		{
			Session s = sessionFactory.openSession();
			Transaction tx = s.getTransaction();
			tx.begin();
			s.save(blog);
			tx.commit();
			s.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public void deleteBlogById(int id) 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Blog blog = (Blog) s.get(Blog.class, id);
		s.delete(blog);
		tx.commit();
		s.close();
		
	}

	public List<Blog> findAllBlog() 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		List<Blog> showBlog=s.createQuery("From Blog").list();
		tx.commit();
		s.close();
		return showBlog;
	}

	public Blog findById(int id) 
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Blog blog=(Blog)s.get(Blog.class,id);
		tx.commit();
		s.close();
		return blog;
	}


}
