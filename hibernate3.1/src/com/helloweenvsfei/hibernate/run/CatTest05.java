package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest05 {


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
  
    
    // �Ǧ^Map����
    /*
     *  �Ǧ^���G�٥i�H���List<List>���A�d�߮�HQL �ĥ� " select new List(a,b,c) from ... "���Φ��C
     *  �P�˻ݭn�ˬdList ����o�Ǧ^��List�A�A�ˬd�Ǧ^��List ��o�d�ߪ����G�A�Ҧp�G
     */
    List listMap = session.createQuery("select new map(c.name as name,c.mother as mother,c.createDate as createDate) from Cat c ").list();
    for(Map map:(List<Map>)listMap){
      System.out.println("Name:"+map.get("name"));
      System.out.println("Mother�G"+map.get("mother"));
      System.out.println("createDate�G"+map.get("createDate"));
    } // end for(Map map:(List<Map>)listMap){
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
