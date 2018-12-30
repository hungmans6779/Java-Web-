package com.spring.dao.transaction;

import java.util.Date;
import java.util.List;

import com.spring.dao.IPersonDao;
import com.spring.entity.Person;

/*
 *  Spring �ϥ� org.springframework.jdbc.datasource.DataSourceTransactionManager �@�� JDBC ������޲z�̡A
 *  �P�ɧ�Q�޲z������ϥ� org.springframework.transaction.interceptor.TransactionProxyFactoryBean �]�w�C
 *  �o�O�@�ӥ���N�z Bean�A����ϥ� IoC�BAOP ���ӤJ����޲z�{���X�C�Ҧp�� TransactionRun �� run() ��k�]�w����C
 */
public class TransactionRun {

  // DAO ��������
  private IPersonDao personDao;

  public IPersonDao getPersonDao() {
	return personDao;
  }

  public void setPersonDao(IPersonDao personDao) {
	this.personDao = personDao;
  }

  
  
  
  
  // �D��k�A�� Spring �I�s
  public void run(){
	  
	Person person = new Person();
	person.setName("����_��");
	person.setAge(30);
	person.setSex("�k");
	person.setBirthday(new Date());
	
	// �W�[Person ����
	personDao.addPerson(person); 
	
	// �Ǧ^�Ҧ�Person ���ƥ� 
	int count = personDao.getPersonsCount();
	System.out.println("count = "+count);
	
	// �ھ� id ��oPerson �m�W   
	String name = personDao.getPersonName(Integer.MAX_VALUE);  // �ߥX�ҥ~���a��
	System.out.println("name = "+name);
	
    // �Ǧ^�Ҧ���Person 
	System.out.println("�Ǧ^�Ҧ���Person");
	List<Person> personList = personDao.findAllPersons();
	for(Person p:personList){
	  System.out.println("id       = "+p.getId());
	  System.out.println("name     = "+p.getName());
	  System.out.println("age      = "+p.getAge());
	  System.out.println("sex      = "+p.getSex());
	  System.out.println("birthday = "+p.getBirthday());
	  
	  System.out.println("\n");
	} // end for(Person p:personList){
	
	
  }
  
  
  
}
