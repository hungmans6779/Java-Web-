package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;

public class TestAnnotationPersonEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
	  Person2 person1 = new Person2();               // ���͹��骺�@��Person 
      person1.setName("kevin");                      // �]�w�W��
      List<Email> emails1 = person1.getEmails();

      
      Person2 person2 = new Person2();
      person2.setName("KK");
      List<Email> emails2 = person2.getEmails();
      
      
      
     
      
      Email email = null;
      
      email = new Email();                           // ���͹��骺�@��Email                      
      email.setEmail("kevinhung@eztravel.com.tw");   // �]�w Email(kevinhung@eztravel.com.tw)
      // person2.getEmails().add(email);             // �W�[�� Person ����
      emails1.add(email);                            // �W�[�� Person ����
      
      email = new Email();                           // ���͹��骺�@��Email    
      email.setEmail("hungmans6779@msn.com");        // �]�w Email(hungmans6779@msn.com)
      // person2.getEmails().add(email);             // �W�[�� Person ����
      emails1.add(email);                            // �W�[�� Person ����
      
      email = new Email();                           // ���͹��骺�@��Email        
      email.setEmail("kevinhungs@gmail.com");        // �]�w Email(kevinhungs@gmail.com)
      // person2.getEmails().add(email);             // �W�[�� Person ����
      emails1.add(email);                            // �W�[�� Person ����
     
      
      
      email = new Email();
      email.setEmail("KK@eztravel.com.tw");
      emails2.add(email);
      
      email = new Email();
      email.setEmail("KK@msn.com");
      emails2.add(email);
      
      email = new Email();
      email.setEmail("KK@gmail.com");
      emails2.add(email);
      
      
     
      
      // �}�Ҥ@��Session 
      Session session = HibernateSessionFactory.getSession();  
     
      // �}�l���
      Transaction trans = session.beginTransaction();
      
      // �x�s Person2 ����A�|�۰ʦ��p�x�sEmail ����
      session.persist(person1);
      session.persist(person2);
      
      
      
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("   select p from Person2 p left join fetch p.emails e         \n");
      sqlStr.append("    where e.email like '%@msn.com%'                           \n");
      

      System.out.println("�Ұ��檺  sqlStr = \n"+sqlStr.toString());
      List list = session.createQuery(sqlStr.toString()).list();
      for(Person2 p:(List<Person2>)list){
    	System.out.println("person1�G"+p.getName());
    	for(Email e:p.getEmails()){
          System.out.println("\t person1 like '@msn.com@'  Email�G   "+e.getEmail());		
    	} 
      } // end for(Person2 p:(List<Person2>)list){
      
      // session.delete(person2);             // �R��  Person2 ����A�|�۰ʦ��p�R���ݩ󥦪� Email �O��
      
      // session.getTransaction().commit();
      trans.commit();                         // �ǰe���
      
      
      session.close();                        // �������
      
	}

}
