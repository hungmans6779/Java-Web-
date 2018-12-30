package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest09 {


  public static void main(String[] args) {
    
	Cat catMother = new Cat(); 
    catMother.setName("Sue");
    catMother.setDescription("����");
    catMother.setCreateDate(new Date());
    

    Cat catChild1=new Cat();
    catChild1.setName("kevin");
    catChild1.setDescription("�p��'name is kevin ");
    catChild1.setMother(catMother);
    catChild1.setCreateDate(new Date());
    
    Cat catChild2=new Cat();
    catChild2.setName("kent");
    catChild2.setDescription("�p��'name is kent");
    catChild2.setMother(catMother);
    catChild2.setCreateDate(new Date());
    
    
    Cat catChild3=new Cat();
    catChild3.setName("joe");
    catChild3.setDescription("�p��'name is joe ");
    catChild3.setMother(catMother);
    catChild3.setCreateDate(new Date());
    
    
    
    
    
    // �}�Ҷ��q
    Session session = HibernateUtil.getSession();
    
    // �}�ҥ��
    Transaction trans = session.beginTransaction();
    
    
    session.persist(catMother);
    session.persist(catChild1);
    session.persist(catChild2);
    session.persist(catChild3);
  
    
    /*
     * HQL �������
     *   ������ܬO Web ��Ʈw�{�����ƪ��\��C���P����Ʈw�ϥΤ��P���覡��{�����A�Ҧp�GMySQL �ϥ� limit�BOracle �ϥ� rownum�C
     * Hibernate ���äF�Ҧ����Ӹ`�A�u�ݭn�]�w�ثe���ƧY�i�C
     *   ������ܤ@����d�߰O���`�ơA�M��d�ߥ�����ܪ��O���CHibernate �z�L Query �d�߰O���AQuery �z�L setFirstResult() �]�w�������Ĥ@���O���A
     * �z�L setMaxResults() �]�w����������ƼơA
     * �Ҧp�G
     */
    long count  = (Long)session.createQuery("select count(c) from Cat c").uniqueResult();
    System.out.println("�ߪ��`�� count = "+count);
    
    List<Cat> list = session.createQuery(" from Cat").setFirstResult(0).setMaxResults(10).list();
    for(Cat c:list){
      System.out.println("�ߦW�G"+c.getName());	
    } // end for(Cat c:list){
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
