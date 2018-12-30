package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Person3;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXMLPerson3Email {


  public static void main(String[] args) {
   
	Person3 person1 = new Person3();
	person1.setName("kevin");
	person1.getEmails().add("kevinhung@eztravel.com.tw");
	person1.getEmails().add("hungmans6779@msn.com");
	person1.getEmails().add("kevinhungs@gmail.com");
	
	
	
	Person3 person2 = new Person3();
	person2.setName("kk");
	person2.getEmails().add("kk@gmail.com");
	
	
	// �}�Ҷ��q
	Session session = HibernateXMLUtil.getSession();
	
	// �}�ҥ�� 
	Transaction trans = session.beginTransaction();
	
	session.persist(person1);  // �x�s person1 ����A�|�۰ʦ��p�x�s  Email ����
	session.persist(person2);
	
	
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("   select p from Person3 p left join fetch p.emails e   \n");
	sqlStr.append("    where e like '%@gmail.com%'                         \n");
	
	
	List list = session.createQuery(sqlStr.toString()).list();
	for(Person3 p:(List<Person3>)list){
      System.out.println("Person�G"+p.getName());
      for(String email:p.getEmails()){
        System.out.println("\t Email�G"+email);	  
      } // end for(String email:p.getEmails()){
	} // end for(Person3 p:(List<Person3>)list){
	
	
	// session.delete(person1);   // �R�� Person ����A�|�۰ʦ��p�R�� Email ���
	// session.delete(person2);
	
	// �ǰe���
	trans.commit();
	
	// �������
	session.close();  
	  
  } // end mail

}
