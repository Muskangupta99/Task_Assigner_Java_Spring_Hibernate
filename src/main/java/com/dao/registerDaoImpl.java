package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.Users;

import com.dao.HibernateUtility;

public class registerDaoImpl implements registerDao {

	@Override
	public String registerUser(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("In class to save data to table---");
		try{HibernateUtility hibernateutility = new HibernateUtility();
		Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
		configuration.addAnnotatedClass(Users.class); 
		
		
		SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
		Session session = session_factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Users user = new Users();
		
		System.out.println("setting");
		
		user.setPk_user_id(null);
		user.setEmail(email);
		user.setPassword(password);
		
		session.save(user);
		transaction.commit();
		session.close();
		}
		catch(Exception e) {
			System.out.println(e);
			return "failure";
		}
		return "success";
	}

}
