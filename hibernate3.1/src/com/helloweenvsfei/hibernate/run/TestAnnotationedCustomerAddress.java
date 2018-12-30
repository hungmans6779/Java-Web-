package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Address;
import com.helloweenvsfei.hibernate.bean.Customer;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class TestAnnotationedCustomerAddress {

  @SuppressWarnings("all")	
  public static void main(String[] args) {
   
	// **************************************************************************  
	// �Ĥ@��Ȥ���
	Customer customer1 = new Customer();
	customer1.setName("kevin");
	
	Address address1 = new Address();
	address1.setAddress("�x�_�����ͪF���T�q49��4��");
	address1.setZip("104");
	address1.setTelephone("02-25010888 #607");
	// **************************************************************************
	

	// **************************************************************************  
	// �ĤG��Ȥ���
	Customer customer2 = new Customer();
	customer2.setName("hungmans6779");
	
	Address address2 = new Address();
	address2.setAddress("�x�n���w�n�ϰp�w��xx��xx��");
	address2.setZip("777");
	address2.setTelephone("06-xxxxxxx");
	// **************************************************************************
	
	
	
	// �}�Ҷ��q 
	Session session = HibernateUtil.getSession();
	
	// �}�ҥ��
	Transaction trans = session.beginTransaction();
	
	// �x�s  customer1�Bcustomer2 ����, ��Ʈw�|�� customer �۰ʤ��tID
	session.persist(customer1);
    session.persist(customer2);

	// �Τ�u�]�w address1�Baddress2 �� ID �O�Ҩ��ID �@�P
	address1.setId(customer1.getId());
    address2.setId(customer2.getId());
	
    
	// ���[�ƪ���,�x�s address1�Baddress2
	session.persist(address1);
	session.persist(address2);
	
	
	// ��X��Τ���s����
	session.flush();
	
	
	// �d�ߦW��kevin ����ơA�Ǧ^ list ����
	List<Customer> list1= session.createQuery("select c from Customer c where c.name = :name").setParameter("name","kevin").list();
	for(Customer c:list1){  // �ˬd Customer
      session.refresh(c);  // ����֨��O����A�q��Ʈw��s
      System.out.println("�Ȥ�m�W�G"+c.getName());
      System.out.println("\t �q�ܡG"+c.getAddress().getTelephone());
      System.out.println("\t �l���ϸ��G"+c.getAddress().getZip());
      System.out.println("\t �a�}�G"+c.getAddress().getAddress());
	} // end for(Customer c:list){
	
	
	
	// �d�ߦW��hungmans6779 ����ơA�Ǧ^ list ����
	List<Customer> list2= session.createQuery("select c from Customer c where c.name = :name").setParameter("name","hungmans6779").list();
	for(Customer c:list2){  // �ˬd Customer
      session.refresh(c);  // ����֨��O����A�q��Ʈw��s
      System.out.println("�Ȥ�m�W�G"+c.getName());
      System.out.println("\t �q�ܡG"+c.getAddress().getTelephone());
      System.out.println("\t �l���ϸ��G"+c.getAddress().getZip());
      System.out.println("\t �a�}�G"+c.getAddress().getAddress());
	} // end for(Customer c:list){
	
	
	
	// �ǰe���
	trans.commit();
	
	// �������q
	session.close();
	
  } // end main

}
