package com.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtility {

    private static Configuration hibernateConfigurationAnnotation() {
    	//try {
          
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Got connector details");
        	
        	return configuration;
        //}
        /*catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
	}*/
    }
	
    private static SessionFactory SessionFactoryHelper(Configuration configuration){
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	System.out.println("In session factory");
        return sessionFactory;
    }
    public static SessionFactory getSessionFactoryHelper(Configuration configuration) {
    	System.out.println("Returning SessionFactory building through Annotated function");
    	SessionFactory sessionFactory = SessionFactoryHelper(configuration);
        return sessionFactory;
    }
    
    public static Configuration gethibernateConfigurationAnnotation(){
    	System.out.println("Returning Configuration Object");
    	return hibernateConfigurationAnnotation();
    }
    
   
}