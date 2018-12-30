package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest13 {


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
     * �Ǧ^�������O��
     * SQLQuery �P Query �@�ˡA���i�H�]�w�ѼơB������ܵ��CSQLQuery �Ǧ^�����G��List<Object[]> �����C
     * �]�i�H�]�w���������O�A�Ϭd�ߵ��G�����Ǧ^�������O����C 
     * �Ҧp�G
     */
    SQLQuery sqlQuery = session.createSQLQuery("select * from tb_cat ");
    sqlQuery.addEntity(Cat.class);
    List<Cat> catList = sqlQuery.list();
    System.out.println("catList size = "+catList.size());
    for(Cat c:catList){
      System.out.println(c.getName());	   // ��X�ݩʭ�
    }
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
