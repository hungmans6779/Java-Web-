package com.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.hibernate.util.HibernateUtil;
import com.hibernate.util.HibernateSessionFactory;



public class BaseDAO<T> {

	
	
  /**
   * ���J���
   * 
   * @param object
   */
  public void create(T object){
	  
	// �}�Ҥ@�� Hibernate ���q  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  Transaction trans = session.beginTransaction();   // �}�Ҥ@�ӥ��
	  session.persist(object);                          // �N�����x�s�i��Ʈw
	  trans.commit();                                   // �ǰe���
	 /*
	  session.beginTransaction();
	  session.persist(object);
	  session.getTransaction().commit();
	  */
	}catch(Exception e){
	  e.printStackTrace();	
	  session.getTransaction().rollback();  // �p�G�ߥX�ҥ~�A�h�^�_���
	}finally{
	  session.close();	                    // ���� Hibernate ���q
	}
  } // end create(T object)
	
  

  
  
  
  
  
 /**
  * ��s��Ʈw
  * 
  * @param object
  */
  public void update(T object){
	  
	// �}�Ҥ@�� Hibernate ���q  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  Transaction trans = session.beginTransaction();  // �}�ҥ��
	  session.update(object);                          // ��sobject ��������Ʀ�
	  trans.commit();                                  // �ǰe���
	/*  
	  session.beginTransaction();
	  session.update(object);
	  session.getTransaction().commit();
	  */
	}catch(Exception e){
	  e.printStackTrace();	
	  session.getTransaction().rollback();  // �p�G�ߥX�ҥ~�A�h�^�_���
	}finally{
	  session.close();	                    // ���� Hibernate ���q
	}
  } // end update(T object)
	
  
  
  
  
  
  
  
  /**
   * �q��Ʈw���R��
   * 
   * @param object
  */
  public void delete(T object){
	  
	// �}�Ҥ@�� Hibernate ���q  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();  
	try{
	  Transaction trans = session.beginTransaction();  // �}�ҥ��
	  session.delete(object);                          // �R�� object ��������Ʀ�
	  trans.commit();                                  // �ǰe���
	  /*
	  session.beginTransaction();
	  session.delete(object);
	  session.getTransaction().commit();
	  */
	}catch(Exception e){
	  e.printStackTrace();
	  session.getTransaction().rollback();  // �p�G�ߥX�ҥ~�A�h�^�_���
	}finally{
	  session.close();                      // ���� Hibernate ���q
	}
  } // end delete(T object)
	
  
  
  
  
  
 /**
  * �ھ� id �M���@Entity Bean
  * 
  * @param clazz
  * @param id
  * @return
  */
  @SuppressWarnings("unchecked")
  public T find(Class<? extends T> clazz, Serializable id) {
	
	// �}�Ҥ@�� Hibernate ���q  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  session.getTransaction();             // �}�ҥ��
	  return (T) session.get(clazz,id);     // �ھ� id �d�߹������O����
	}finally{
	  session.close();                      // ���� Hibernate ���q
	}
  }
	
  
  
  
  
  
  
  
  /**
   * �M��h��Entity Bean
   * 
   * @param hql
   * @return
   */
  @SuppressWarnings("unchecked")
  public List <T> list(String hql){
	
	// �}�Ҥ@�� Hibernate ���q  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	try{
	  session.beginTransaction();               // �}�ҥ��
	  return session.createQuery(hql).list();   // �d�� hql ���G�A�Ǧ^List ����
	}finally{
      session.getTransaction().commit();        // �ǰe���
      session.close();                          // ���� Hibernate ���q
	}
  } // end list(String hql)
  
  
  
  
  
  
}
