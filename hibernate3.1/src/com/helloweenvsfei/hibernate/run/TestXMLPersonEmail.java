package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Email;
import com.helloweenvsfei.hibernate.bean.Person2;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXMLPersonEmail {


	
	
  public static void main(String[] args) {
	
	Person2 person1 = new Person2();
	person1.setName("kevin");
	List<Email> emails1 = person1.getEmails();
	
	
	Person2 person2 = new Person2();
	person2.setName("kk");
	List<Email> emails2 = person2.getEmails();
	
	
	Email email = null;
	
	email = new Email();
	email.setEmail("kevinhung@eztravel.com.tw");
	emails1.add(email);

	email = new Email();
	email.setEmail("hungmans6779@msn.com");
	emails1.add(email);
	
    
	email = new Email();
	email.setEmail("KK@gmail.com");
	emails2.add(email);
	
	
	email = new Email();
	email.setEmail("kevinhungs@gmail.com");
	emails1.add(email);
	

	
	// �}�Ҥ@��Session 
	Session session = HibernateXMLUtil.getSession();
	
	// �}�l���
	Transaction trans = session.beginTransaction();
	
	// �x�s Person2 ����A�|�۰ʦ��p�x�sEmail ����
	session.persist(person1);
	session.persist(person2);
	
	
	
	StringBuffer sqlStr = new StringBuffer(); 
    sqlStr.append("   select p from Person2 p left join fetch p.emails e           \n");
    sqlStr.append("    where e.email like '%@gmail.com%'                           \n");
    System.out.println("�Ұ��檺  sqlStr = \n"+sqlStr.toString());
    
    List list = session.createQuery(sqlStr.toString()).list();
    for(Person2 p:(List<Person2>)list){
      System.out.println("person :"+p.getName());
      for(Email e:p.getEmails()){
        System.out.println("\t person like '%@msn.com%' Email�G"+e.getEmail());	  
      }	
    } // end 
    
      
	// �ǰe���
	trans.commit();
	
	// �������
	session.close();
	

  }
  

}
