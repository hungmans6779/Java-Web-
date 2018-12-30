package com.spring.dao;

import java.util.List;

import com.spring.entity.Person;

/*
 *  Person �� DAO ����
 */
public interface IPersonDao {
 
  // �ھ� id ��oPerson �m�W   
  public String getPersonName(Integer id);
	      
  // �W�[Person ����
  public void addPerson(Person person);
		    
  // �Ǧ^�Ҧ�Person ���ƥ� 
  public int getPersonsCount();
	  
  // �Ǧ^�Ҧ���Person 
  public List<Person>listPersons();

  
  public List findAllPersons();
	
  
  public String testTransactions(Integer id);
	
  
  public int sqlUpdate(Integer id,String sex);
	
  
  public int countRows();
  
}
