package com.helloweenvsfei.hibernate.run;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {


  static int createId = 0;
  
  // ���O���J���ɭ��x�s�@��Person
  static{
	  
	// ��l�Ƥ@�� Person ��� 
    Person2 person1 = new Person2();	  
	person1.setName("Kevin");
	List<Email> emails1 = person1.getEmails();
	

	Email email = new Email();                       // ���ͤ@��Email ���
	email.setEmail("kevinhung@eztravel.com.tw");     // �]�wemail �ݩ�
	emails1.add(email);                              // �W�[��person �� 
	

	// �}�Ҷ��q
	Session session = HibernateSessionFactory.getSession();
	
	// �}�ҥ��
	Transaction trans = session.beginTransaction();
	
	// �x�s���Ʈw
	session.persist(person1);
	
	// �N id �x�s�_��
	createId = person1.getId();
	

	// �ǰe���
	trans.commit();             
	
	// �������q
	session.close();            	
  } // end static
  
  
  
  public static void main(String[] args) {
    
	// �}�Ҷ��q 
	Session session = HibernateSessionFactory.getSession();
    
	// �u�d�ߡA���}�ҥ��
    Person2 person = (Person2)session.get(Person2.class,createId);
    
    // �}�����q
    session.close();    
   
    try{
      List<Email> list = person.getEmails();
      System.out.println("person Name = "+person.getName());
      for(Email mail:list){
    	System.out.println("\t"+mail.getEmail());  
      }
    }catch(Exception e){
      String title = e.getClass().getName();
      String msg = e.getMessage().replace(",",",\r\n").replace(":",":\r\n");
      JOptionPane.showMessageDialog(null,msg,title,JOptionPane.ERROR_MESSAGE);
    }
    
    
  } // end main
  
  

}
