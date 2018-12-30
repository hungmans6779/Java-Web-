package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat1;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.util.HibernateUtil;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class CatTest15 {


  public static void main(String[] args) {
    
	   
	Cat1 catMother = new Cat1(); 
	catMother.setName("Sue");
	catMother.setDescription("����");
	catMother.setCreateDate(new Date());
	    
	Cat1 catChild1=new Cat1();
	catChild1.setName("kevin");
	catChild1.setDescription("�p��'name is kevin ");
	catChild1.setMother(catMother);
	catChild1.setCreateDate(new Date());
	    
    Cat1 catChild2=new Cat1();
	catChild2.setName("kent");
	catChild2.setDescription("�p��'name is kent");
	catChild2.setMother(catMother);
    catChild2.setCreateDate(new Date());
	    
	Cat1 catChild3=new Cat1();
	catChild3.setName("joe");
	catChild3.setDescription("�p��'name is joe ");
	catChild3.setMother(catMother);
	catChild3.setCreateDate(new Date());
	    

    
    // �}�Ҷ��q
    Session session = HibernateXMLUtil.getSession();
    
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
    Query q = session.getNamedQuery("cat by name").setParameter("name","kevin");
    List<Cat1> catList = q.list();
    for(Cat1 c:catList){
      System.out.println("�ߦW�G"+c.getName()); 	
    }
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
