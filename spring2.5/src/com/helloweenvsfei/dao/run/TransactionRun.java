package com.helloweenvsfei.dao.run;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.helloweenvsfei.dao.bean.Person;
import com.helloweenvsfei.dao.dao.IPersonDAO;

public class TransactionRun {
  
  private IPersonDAO personDao;	
  
  public IPersonDAO getPersonDao() {
	return personDao;
  }

  public void setPersonDao(IPersonDAO personDao) {
	this.personDao = personDao;
  }

  
  
  
  public void run(){
    
	Person person = new Person();
    person.setName("����ɦ^");
    person.setAge(999);
    person.setSex("��3��");
    person.setBirthday(new Date());
    
    personDao.addPerson(person);                                        // �x�s
    System.out.println("���o�`����  Count:"+personDao.getPersonsCount()); // ���o�`����
    
    // �|�]��Ʈw�S���ӵ������өߥX�ҥ~���a��A����transaction ���
    System.out.println(personDao.getPersonName(Integer.MAX_VALUE));
    
    List<Person>personList = personDao.findAllPersons();
    for(Person p:personList){
      System.out.println("Name = "+p.getName());	
    } // end for(Person p:personList){ 
    
  } // end public void run(){
  

  
  
  
  // Spring �ϥ� DataSourceTransactionManager �@��JDBC ������޲z�̡A�P�ɧ�Q�޲z������ϥ� TransactionProxyFactoryBean �]�w�C
  // �o�O�@�ӥ���N�zBean�A����ϥ�IoC�BAOP ���ӤJ����޲z�{���X�C�Ҧp��  TransactionRun �� run() ��k�]�w����C
  public static void main(String[] args) {
	  
    /*
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");		
    TransactionRun tr = (TransactionRun)context.getBean("transactionRun");
    */
	  
    // ���J�]�w��
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext-dao.xml"));
    // �q�]�w�ɤ���o����
    TransactionRun tr = (TransactionRun)factory.getBean("transactionRun");
   
    tr.run();    // ���� run�C�Ӥ�k�w�g�Q�[�W���
  } // end run

  
  
  
  
}
