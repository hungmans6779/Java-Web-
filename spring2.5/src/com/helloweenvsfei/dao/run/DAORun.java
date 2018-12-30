package com.helloweenvsfei.dao.run;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.dao.dao.IPersonDAO;
import com.helloweenvsfei.dao.bean.Person;

public class DAORun {

	 
	/**
	 * @param args
	 */
	public static void main(String[] args){
	  
	  XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-dao.xml"));	
	  
	  IPersonDAO personDao = (IPersonDAO)factory.getBean("personDAO");
	  
	  Person person = new Person();
	  person.setName("kevin - "+(personDao.getPersonsCount()+1));
	  person.setAge(35);
	  person.setSex("�k");
	  person.setBirthday(new Date());
	  
	  personDao.addPerson(person);  // �W�[���Ʈw
	  System.out.println("Count�G"+personDao.getPersonsCount());
	  System.out.println(personDao.getPersonName(1)); // �d��Person �m�W
	  
	  List <Person> personList = personDao.listPersons();
	  int count = 0;
	  for(Person p:personList){
		System.out.println("�� "+(++count)+"�� , Name�G"+p.getName());  
	  }
	  
	  
	  
	  // ��@�ϥ� MappingSqlQuery ����H���O�ʸ� Java ����
	  System.out.println("��@�ϥ� MappingSqlQuery ����H���O�ʸ� Java ����");  
	  List<Person>personList1 = personDao.findAllPersons();
	  for(Person p:personList1){
		System.out.println("Names = "+p.getName());  
	  }
	  
	  System.out.println("testTransactions(1) = "+personDao.testTransactions(1));
	 
	  
	  // ��@�ϥ� SqlUpdate
	  int updateResult = personDao.sqlUpdate(1,"�j���k");
	  
	  
	  // �ϥ� SqlFunction ���O
	  int countRows = personDao.countRows();
	  System.out.println("�`���� countRows = "+countRows);
	}
	

}
