package com.helloweenvsfei.dao.dao;

import java.util.List;
import com.helloweenvsfei.dao.bean.Person;

// Person �� DAO ����
public interface IPersonDAO {
   
  // �W�[Person ����
  public void addPerson(Person person);
	    
  // �Ǧ^�Ҧ�Person ���ƥ� 
  public int getPersonsCount();
  
  // �ھ� id ��oPerson �m�W  
  public String getPersonName(Integer id);
    
  // �Ǧ^�Ҧ���Person 
  public List<Person>listPersons();
  
  
  public List findAllPersons();
	
  
  public String testTransactions(Integer id);
  
  
  public int sqlUpdate(Integer id,String sex);
  
  
  public int countRows();
  
}
