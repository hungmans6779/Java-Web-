package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Clazz;
import com.helloweenvsfei.hibernate.bean.Student;
import com.helloweenvsfei.hibernate.util.HibernateSessionFactory;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXMLClazzStudent {


  @SuppressWarnings("all")
  public static void main(String[] args) {
	    

    // ******************************************************************************
	// �T�~�@�Z�ǥ�
	Clazz clazz31 = new Clazz();            // ���͹��骺�@�ӯZ��
	clazz31.setName("�T�~�@�Z");             // �Z�ŦW��
	    
	Student student311 = new Student();     // ���͹��骺�@�Ӿǥ�
	student311.setName("�P�N��");           // �m�W
	student311.setSex("�k");                // �ʧO
	   
	Student student312 = new Student();
	student312.setName("���̵Y");
	student312.setSex("�k");
	// ******************************************************************************
	    
	    
	    
	       
	// ******************************************************************************
	// �T�~�G�Z�ǥ�
	Clazz clazz32 = new Clazz();  // ���͹��骺�@�ӯZ��
	clazz32.setName("�T�~�G�Z");
	   
	Student student321 = new Student();
	student321.setName("���ٯu");
	student321.setSex("�k");
	    
	Student student322 = new Student();
	student322.setName("�s�f�̵�");
	student322.setSex("�k");
	    
	Student student323 = new Student();
	student323.setName("�@���a�R");
	student323.setSex("�k");
	// ******************************************************************************
	    
	    
	    
	    
	    
	    
	    
	    
	    
    // �}�Ҷ��q
	Session session = HibernateXMLUtil.getSession();
	    
	// �}�ҥ��
	Transaction trans = session.beginTransaction();
	    
	// ���[�ƪ���
	session.persist(clazz31);
	session.persist(student311);
	session.persist(student312);
	   
	session.persist(clazz32);
	session.persist(student321);
	session.persist(student322);
	session.persist(student323);
	    
	    
	    
	// �]�w�Z�šA�ѩ󱱨��v�]�w�b�h��A�]���n�z�L  student ���x�s���鶡�����p
	// �T�~�@�Z���ǥ�
	student311.setClazz(clazz31);
	student312.setClazz(clazz31);
	    
	// �T�~�G�Z���ǥ�
	student321.setClazz(clazz32);
	student322.setClazz(clazz32);
	student323.setClazz(clazz32);
	    
	    
	    
	// �x�s�ۨ����Y
	// �T�~�@�Z
	session.save(student311);     
	session.save(student312);    
	
	// �T�~�G�Z
	session.save(student321);
	session.save(student322);
	session.save(student323);
	    
	   
	// �ǰe���
	trans.commit();
	    
	    
	   
	    
	    
	    
    // �}�ҥ��
    trans = session.beginTransaction();
	 
	    
	    
	// *************************************************************************************************************************************************
	// �d�ߦW��"�T�~�@�Z"���Z��
	Clazz c1 = (Clazz)session.createQuery("select c from Clazz c where c.name = :name ").setParameter("name","�T�~�@�Z").uniqueResult();  // �Ǧ^��@����  
	    
	// ���s�q��Ʈw��o���
	session.refresh(c1);

	System.out.println("(1)�T�~�@�Z���Ҧ��ǥ�");
	for(Student s:c1.getStudents()){
	  System.out.println("\t �m�W�G"+s.getName()+",�ʧO�G"+s.getSex());
	} // end for(Student s:c.getStudents()){
	    
	// �d�߯Z��
	List<Student> students1 = session.createQuery("select s from Student s where s.clazz.name = :name ").setParameter("name","�T�~�@�Z").list();
	System.out.println("(2)�T�~�@�Z���Ҧ��ǥ�");
	for(Student s:students1){
	  System.out.println("\t �m�W�G"+s.getName()+",�m�W�G"+s.getSex());	
	} // end for(Student s:students){
	// *************************************************************************************************************************************************
	    
	    
	    
	    
	    
	// *************************************************************************************************************************************************
    // �d�ߦW��"�T�~�G�Z"���Z��
	Clazz c2 = (Clazz)session.createQuery("select c from Clazz c where c.name = :name ").setParameter("name","�T�~�G�Z").uniqueResult(); // �Ǧ^��@�ӹ���
	    
	// ���s�q��Ʈw��o���
	session.refresh(c2);
	    
	System.out.println("(3)�T�~�G�Z���Ҧ��ǥ�");
	for(Student s:c2.getStudents()){
	  System.out.println("\t �m�W�G"+s.getName()+",�ʧO�G"+s.getSex());	
	} // end for(Student s:c2.getStudents()){
	    
	// �d�߯Z��
	List<Student> students2 = session.createQuery("select s from Student s where s.clazz.name = :name ").setParameter("name","�T�~�G�Z").list();
	System.out.println("(4)�T�~�G�Z���Ҧ��ǥ�");
	for(Student s:students2){
	  System.out.println("\t �m�W�G"+s.getName()+",�m�W�G"+s.getSex());	
	} // end for(Student s:students2){
	// *************************************************************************************************************************************************
	    
	    
	// �ǰe���
	trans.commit();
	    
	// �������q
	session.close();
	     
  }

}
