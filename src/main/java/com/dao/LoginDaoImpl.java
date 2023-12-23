package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.beans.Users;
import org.hibernate.query.Query;
import java.util.*;

public class LoginDaoImpl implements LoginDao{

	@Override
	public Long login(String email, String password) {
		System.out.println("In class to save data to table---");
		try{HibernateUtility hibernateutility = new HibernateUtility();
		Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
		configuration.addAnnotatedClass(Users.class); 
		
		
		SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
		Session session = session_factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Users user = new Users();
		
		String hql = "from Users where email =:email AND password =:password";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
		 List<Users> results = (List<Users>) query.list();
		System.out.println(results.get(0).getPk_user_id());
		
		if(results.size() !=0)
			return results.get(0).getPk_user_id();
		else 
			return null;
		
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public String UserDetails(Long id) {
		System.out.println("In class to save data to table---");
		try{HibernateUtility hibernateutility = new HibernateUtility();
		Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
		configuration.addAnnotatedClass(Users.class); 
		
		
		SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
		Session session = session_factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Users user = new Users();
		
		String hql = "from Users where pk_user_id =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
	
		 List<Users> results = (List<Users>) query.list();
		 System.out.println(results.get(0).getEmail());
		
		if(results.size() !=0)
			return results.get(0).getEmail();
		else 
			return null;
		
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

}
