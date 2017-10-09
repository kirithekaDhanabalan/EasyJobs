package com.EasyJobs.EasyJobsbd.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import java.util.List;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.EasyJobs.EasyJobsbd.dao.UserDAO;
import com.EasyJobs.EasyJobsbd.model.UserCredentials;
import com.EasyJobs.EasyJobsbd.model.UserRegistration;
import com.EasyJobs.EasyJobsbd.model.Users;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Users findByName(String name) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Users c = (Users) s.get(Users.class, name);
		tx.commit();
		s.close();
		return c;
	}

	public void saveUser(Users user) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		s.save(user);
		UserCredentials uc = new UserCredentials();
		uc.setUsername(user.getUsername());
		uc.setUpassword(user.getUpassword());
		s.save(uc);
		tx.commit();

		s.close();
	}

	public void updateUser(Users user) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Users c = (Users) s.get(Users.class, user.getUsername());
		c.setPhonenumber(user.getPhonenumber());
		c.setEmail(user.getEmail());
		c.setUpassword(user.getUpassword());
		s.update(c);
		tx.commit();

		s.close();
	}

	public void deleteUserById(String name) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Users c = (Users) s.get(Users.class, name);
		UserCredentials uc = (UserCredentials) s.get(UserCredentials.class, name);
		s.delete(uc);
		s.delete(c);
		tx.commit();

		s.close();
	}

	public List<Users> findAllUsers() {
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		List<Users> showuser = s.createQuery("FROM Users").list();
		tx.commit();

		s.close();
		return showuser;
	}

	public boolean isUserExist(String name) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();
		Users c = (Users) s.get(Users.class, name);

		s.close();
		if (c == null)
			return false;
		else
			return true;
	}

	public boolean check(String name, String Password) {
		Session s = sessionFactory.openSession();
		System.out.println(Password);
		Transaction tx = s.getTransaction();
		tx.begin();
		UserCredentials c = (UserCredentials) s.get(UserCredentials.class, name);
		System.out.println(c.getUpassword());

		s.close();
		if (c.getUpassword().equals(Password)) {
			System.out.println("hello");
			return true;
		} else
			return false;
	}

}
