package com.dao;
import com.beans.Person;
import com.beans.Tasks;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class TaskDaoImpl {

	public Boolean setTask(Long fk_person_id, String desc) {
		System.out.println("In class to save task to table---");
		try{
		HibernateUtility hibernateutility = new HibernateUtility();
		Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
		configuration.addAnnotatedClass(Tasks.class); 
		SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
		Session session = session_factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Tasks tasks = new Tasks();
		System.out.println("setting task");
		
		tasks.setFk_person_id(fk_person_id);
		tasks.setDescription(desc);
		tasks.setIs_completed(0);
		
		session.save(tasks);
		transaction.commit();
		session.close();
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

		
	
	
	public ArrayList<Tasks> getTask(Long fk_person_id, String message) {
		
		System.out.println("In class to get tasks for person---"+fk_person_id);
		
		try{HibernateUtility hibernateutility = new HibernateUtility();
		Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
		
		configuration.addAnnotatedClass(Tasks.class); 
		configuration.addAnnotatedClass(Person.class);
		SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
		Session session = session_factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Tasks tasks = new Tasks();
		
		String hql = "from Tasks where fk_person_id =:fk_person_id";
		Query query = session.createQuery(hql);
		query.setParameter("fk_person_id", fk_person_id);
		
		ArrayList<Tasks> results = (ArrayList<Tasks>) query.list();
		System.out.println(results.get(0).getDescription());
		
		transaction.commit();
		session.close();
		
		return results;
		
		
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
   public Boolean setCompleted(Long pk_task_id) {
		
		System.out.println("In class to get tasks for person---"+pk_task_id);
		
		try{HibernateUtility hibernateutility = new HibernateUtility();
		Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
		
		configuration.addAnnotatedClass(Tasks.class); 
		configuration.addAnnotatedClass(Person.class);
		SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
		Session session = session_factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Tasks tasks = new Tasks();
		
		String hql = "update Tasks set is_completed=1 where pk_task_id =:pk_task_id ";
		Query query = session.createQuery(hql);
		query.setParameter("pk_task_id", pk_task_id);
		
		query.executeUpdate();
		
		transaction.commit();
		session.close();
		
		return true;
		
		
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
}
