package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.beans.Person;
import com.beans.Users;

public class PersonDaoImpl {
public Long addperson(Long user_id, String person_name){
	
	System.out.println("In class to save data to table---");
	try{HibernateUtility hibernateutility = new HibernateUtility();
	Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
	configuration.addAnnotatedClass(Users.class); 
	configuration.addAnnotatedClass(Person.class); 
	
	SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
	Session session = session_factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Person person = new Person();
	Users user = new Users();
	
	person.setPk_person_id(null);
	person.setPerson_name(person_name);
	person.setFk_user_id(user_id);
	
	
	Long id = (Long) session.save(person);
	
	
	transaction.commit();
	session.close();
	
	return id;
	
	
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
	
}

public ArrayList<Person> getPersons(Long fk_user_id){

	System.out.println("In class to get data---");
	try{HibernateUtility hibernateutility = new HibernateUtility();
	Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
	
	configuration.addAnnotatedClass(Person.class); 
	
	SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
	Session session = session_factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Person person = new Person();
	
	String hql = "from Person where fk_user_id =:fk_user_id";
	Query query = session.createQuery(hql);
	query.setParameter("fk_user_id", fk_user_id);
	
	ArrayList<Person> results = (ArrayList<Person>) query.list();
	System.out.println(results.get(0).getPerson_name());
	
	transaction.commit();
	session.close();
	
	return results;
	
	
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}

public ArrayList<Person> getPersonsDetails(Long pk_person_id){

	System.out.println("In class to get data---");
	try{HibernateUtility hibernateutility = new HibernateUtility();
	Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
	
	configuration.addAnnotatedClass(Person.class); 
	
	SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
	Session session = session_factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Person person = new Person();
	
	String hql = "from Person where pk_person_id =:pk_person_id";
	Query query = session.createQuery(hql);
	query.setParameter("pk_person_id", pk_person_id);
	
	ArrayList<Person> results = (ArrayList<Person>) query.list();
	System.out.println(results.get(0).getPerson_name());
	
	transaction.commit();
	session.close();
	
	return results;
	
	
	}
	catch(Exception e) {
		System.out.println(e);
		return null;
	}
}

public Integer getPassCode(Long pk_person_id, String passcode){

	System.out.println("In class to get data---");
	try{HibernateUtility hibernateutility = new HibernateUtility();
	Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
	
	configuration.addAnnotatedClass(Person.class); 
	
	SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
	Session session = session_factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Person person = new Person();
	
	String hql = "from Person where pk_person_id =:pk_person_id";
	Query query = session.createQuery(hql);
	query.setParameter("pk_person_id", pk_person_id);
	
	ArrayList<Person> results = (ArrayList<Person>) query.list();
	
	
	transaction.commit();
	session.close();
	if(results.get(0).getPasscode().equals("") || results.get(0).getPasscode().equals(null))
		return 0 ;
	if(results.get(0).getPasscode().equals(passcode))
		return 1;
	else return 2;
	
	
	
	}
	catch(Exception e) {
		System.out.println(e);
		return 3;
	}
}

public boolean addpasscode(Long pk_person_id, String passcode) {
	// TODO Auto-generated method stub
	System.out.println("In class to set passcode---");
	try{HibernateUtility hibernateutility = new HibernateUtility();
	Configuration configuration = hibernateutility.gethibernateConfigurationAnnotation();
	
	configuration.addAnnotatedClass(Person.class); 
	
	SessionFactory session_factory = hibernateutility.getSessionFactoryHelper(configuration);
	Session session = session_factory.openSession();
	Transaction transaction = session.beginTransaction();
	
	Person person = new Person();
	
	String hql = "update Person set passcode =:passcode where pk_person_id =:pk_person_id ";
	Query query = session.createQuery(hql);
	query.setParameter("pk_person_id", pk_person_id);
	query.setParameter("passcode", passcode);
	
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
