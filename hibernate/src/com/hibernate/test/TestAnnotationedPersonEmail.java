package com.hibernate.test;

import java.util.List;


import org.hibernate.Session;

import com.hibernate.bean.Email;
import com.hibernate.bean.Person2;
import com.hibernate.util.HibernateSessionFactory;

public class TestAnnotationedPersonEmail {

	
  public static void main(String [] args){
	
    Person2 person = new Person2();             // ���͹���@��Person 
    person.setName("Jane");                     // �]�w�W��
    
    Email email = new Email();                  // ���͹���@�� Email
    email.setEmail("yahoo@yahoo.com.tw");       // �]�w Email
    person.getEmails().add(email);              // �W�[�� Person ����
    
    email = new Email();                        // ���͹���@�� Email
    email.setEmail("163@163.com");              // �]�w Email
    person.getEmails().add(email);              // �W�[�� Person ����
    
    
    
    Session session = HibernateSessionFactory.getSession();  // �}�Ҥ@��Session
    session.beginTransaction();                              // �}�l���
    session.persist(person);                                 // �x�s Person ����A�|�۰ʦ��p�x�s Email ����
    
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("select p from Person2 p left join fetch p.emails e   \n");
    sqlStr.append("   where e.email like '%@yahoo.com.tw'               \n");

    List list = session.createQuery(sqlStr.toString()).list();
    for(Person2 p:(List<Person2>) list){
      System.out.println("Person: "+p.getName());
      for(Email e:p.getEmails()){
    	System.out.println("\t id: "+e.getId()+", Email: "+e.getEmail()); 
      } // end for(Email e:p.getEmails()){
    } // end for(Person2 p:(List<Person2>) list){
   
    // session.delete(person);                      // �R�� Person ����A�|�۰ʦ��p�R���ݩ󥦪� Email �O��
    
    session.getTransaction().commit();           // �ǰe���
    session.close();                             // �������
    
  } // end main
  
  
}
