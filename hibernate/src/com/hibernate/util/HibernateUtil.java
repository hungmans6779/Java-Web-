package com.hibernate.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;

import org.hibernate.SessionFactory;


public class HibernateUtil {
	
	// XML �]�w�ɨϥ�
	// private  static Configuration configuration = new Configuration();    
	
	// @ �]�w�ɨϥ� 
	private static Configuration configuration = new AnnotationConfiguration();
	

	// ��@���A�Ҧ��� SessionFactory
	private static final SessionFactory sessionFactory;
	
	
	// static �{���X�϶��A���O���J�ɪ�l�� Hibernate
	static{
	  
	  try{	
		configuration.configure("hibernate.cfg.xml");
	      		
		// �q hibernate.cfg.xml �����J�]�w
		sessionFactory = configuration.buildSessionFactory();	
	  }catch (Throwable ex) {
		System.err.println("Initial SessionFactory creation failed." + ex);
		throw new ExceptionInInitializerError(ex);
	  }
	  
	} // end static{

	
	
	public static SessionFactory getSessionFactory() {
	  return sessionFactory;
	}
	
}
