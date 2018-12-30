package com.spring.dao.client;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.spring.dao.IPersonDao;
import com.spring.entity.Person;


public class Client {

	
  public static void main(String[] args) {
	
	// ���J�]�w��
	XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
	
	// ��o Peson DAO ����
	IPersonDao personDao = (IPersonDao)factory.getBean("personDao");

	// ���� Peson ����
	Person person  = new Person();
	person.setName("kevin"); 
	person.setAge(35);
	person.setSex("�k");
	person.setBirthday(new Date());
	
	
	// �W�[���Ʈw
	personDao.addPerson(person);
	
	
	// �Ǧ^�Ҧ�Person ���ƥ� 
	int count = personDao.getPersonsCount();
	System.out.println("�Ǧ^�Ҧ�Person ���ƥ�,count = "+count);

	
	// �ھ� id ��oPerson �m�W   
	String name = personDao.getPersonName(1);
	System.out.println("�ھ� id ��oPerson �m�W,name = "+name);

	
	// �Ǧ^�Ҧ���Person 
	List<Person> personList = personDao.listPersons();
	System.out.println("�Ǧ^�Ҧ���personList    \n");
	for(Person p:personList){
	  System.out.println("Name�G"+p.getName());	
	} // end for(Person p:personList){
	
	
	
	System.out.println("\n");
	List<Person> personList1 = personDao.findAllPersons();
	System.out.println("�Ǧ^�Ҧ���personList1    \n");
	for(Person p:personList1){
	  System.out.println("Name�G"+p.getName());	
    } // end for(Person p:personList){
		
	
	
	System.out.println("\n");
	int count1 = personDao.sqlUpdate(8,"�k");
	System.out.println("count1 = "+count1);
	
	
	
	System.out.println("\n");
	String name1 = personDao.testTransactions(15);
	System.out.println("name1 = "+name1);
	
  } // end main

   
}