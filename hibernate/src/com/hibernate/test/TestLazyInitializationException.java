package com.hibernate.test;

import java.awt.Font;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.hibernate.bean.Email;
import com.hibernate.bean.Person2_1;
import com.hibernate.util.HibernateSessionFactory;

public class TestLazyInitializationException {
  
  static int createID = 0;
  
  static{  // ���O���J���ɭ��x�s�@�� Person
	
	Person2_1 person = new Person2_1();              // ��l�Ƥ@�� Person ���
	person.setName("kevin");          
	
	Email email = new Email();                       // ���͹���@��Email
	email.setEmail("kevinhung@eztravel.com.tw");     // �]�w email �ݩ�
	person.getEmails().add(email);                   // �W�[�� person ��
	
	
	email = new Email();                              
	email.setEmail("hungmans6779@msn.com");
	person.getEmails().add(email);
	
	
	Session session = HibernateSessionFactory.getSession();  // �}�Ҷ��q
	session.beginTransaction();                              // �}�ҥ��
	
	session.persist(person);                                 // �x�s���Ʈw
	createID = person.getId();                               // �N id �x�s�_��
	
	
	session.getTransaction().commit();                       // �ǰe���
	session.close();                                         // �������q
	
  }
  
	
  
  public static void main(String [] args) throws Exception{
	
	  Session session = HibernateSessionFactory.getSession();     // �u�d���ζ}�ҥ��
	  
	  Person2_1 p = (Person2_1) session.get(Person2_1.class,createID);  // �d��
	  session.close();                                            // ����
	  
	  
	  try{
		List<Email> list = p.getEmails();                           // ���J��ơA �N�|�ߥX�ҥ~
		System.out.println(p.getName()+" ���q�l�l��:");
		for(Email mail:list){    // �`����XEmail
	      System.out.println("\t"+mail.getEmail());		 
		}
	  }catch(Exception e){
		String title = e.getClass().getName();  // ���~��T
		String msg = e.getMessage().replace(",","\r\n").replace(":",":\r\n");
		
		System.out.println("kevintest title = "+title);
		System.out.println("kevintest msg = "+msg);

		// �� Swing ��ܬd�ߵ��G
		JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
		JOptionPane.showMessageDialog(null,msg,title,JOptionPane.ERROR_MESSAGE);
	  }  
  }
  
}