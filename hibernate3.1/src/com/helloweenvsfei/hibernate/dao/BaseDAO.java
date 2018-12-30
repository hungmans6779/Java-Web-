package com.helloweenvsfei.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;
import com.helloweenvsfei.hibernate.util.HibernateUtil;


/* 
 *  DAO �h�G�M���t�d��ƪ�Ū�g�C�ѩ󤣥μgSQL�ԭz�ADAO �h�N²��o�h�F�C
 *  Hibernate ����޲z�Ҧ��� Entity ���O�A�]���i�H�g�@�ӳq�Ϊ� DAO �A�ާ@�Ҧ���Entity�C
 *  �p�G�Y�� Entity Bean �ݭn��L�S�O���ާ@�A�i�H�~�� BaseDAO�A�ù�{�ۤv���ާ@�A�F�� BaseDAO �{���X���Ϊ��ت��C
 */

public class BaseDAO<T> {
  	
	
	
 /**
  * ���J��ƪ�
  * @param object
  */
  public void create(T object){
	  
	// �}�Ҥ@�� Hibernate ���  
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction trans = null;
    try{ 
      trans = session.beginTransaction();       // �}�Ҥ@�ӥ��
      session.persist(object);                  // �N�����x�s�i��Ʈw
      trans.commit();                           // �ǰe���
    }catch(Exception e){
      trans.rollback();                         // �p�G���ҥ~�ߥX�A�h�^�Х��
    }finally{
      if(session!=null) { session.close();  }	// ����  Hibernate ���q
    }
  } // end void create
  
  
  
  
  
  
 /**
  * ��s��ƪ�
  * @param object
  */
  public void update(T object){
	
	// �}�Ҥ@�� Hibernate ���    
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = null;
	try{
      trans = session.beginTransaction();      // �}�Ҥ@�ӥ��
      session.update(object);                  // ��sobject ��������Ʀ�
      trans.commit();                          // �ǰe���
	}catch(Exception e){       
	  trans.rollback();	                       // �p�G���ҥ~�ߥX�A�h�^�Х��
	}finally{
	  if(session!=null) { session.close();  }  // ����  Hibernate ���q
	}
  } // end void update
  
  
  
  
  
  
 /**
  * �q��Ʈw���R��
  * @param object
  */
  public void delete(T object){
	
	// �}�Ҥ@�� Hibernate ��� 
    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    Transaction trans = null;
    try{
      trans = session.beginTransaction();     // �}�Ҥ@�ӥ��
      session.delete(object);                 // �R�� object ��������Ʀ�
      trans.commit();                         // �ǰe���
    }catch(Exception e){
      trans.rollback();	                      // �p�G���ҥ~�ߥX�A�h�^�Х��
    }finally{
      if(session!=null) { session.close();  } // ����  Hibernate ���q
    }
    
  } // end void delete
  
  
  
  
  
    
 /**
  * �M���@Entity Bean
  * 
  * @param clazz
  * @param id
  * @return
  */
  @SuppressWarnings("unchecked")
  public T find(Class<? extends T> clazz,Serializable id){
	  
	// �}�Ҥ@�� Hibernate ���  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = null;
	try{
	  trans = session.beginTransaction();     // �}�Ҥ@�ӥ��
	  return (T)session.get(clazz,id);
	}finally{
	  // session.getTransaction().commit();
	  trans.commit();                         // �ǰe���            
	  if(session!=null){ session.close(); }   // ����  Hibernate ���q
	}
  } // end T find
  
  
  
  
  
   
 /**
  * �M��h��Entity Bean
  * 
  * @param hql
  * @return
  */  
  @SuppressWarnings("unchecked")
  public List <T> list(String hql){
	  
	// �}�Ҥ@�� Hibernate ���  
	Session session = HibernateSessionFactory.getSessionFactory().openSession();
	Transaction trans = null;
	try{	  
	  trans = session.beginTransaction();   // �}�Ҥ@�ӥ��
	  return session.createQuery(hql).list();
	}finally{
	  // session.getTransaction().commit();
	  trans.commit();                          // �ǰe���          
	  if(session!=null) { session.close();  }  // ����  Hibernate ���q
	} 
  } // end List<T>
  
	

  
}
