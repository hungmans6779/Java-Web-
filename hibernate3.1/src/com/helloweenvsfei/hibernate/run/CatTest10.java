package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.bean.Event;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest10 {


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
    
    Event event1 = new Event();
    event1.setDescription("event'1 description");
    event1.setCreateDate(new Date());
    event1.setCat(catMother);
    
    Event event2 = new Event();
    event2.setDescription("event'2 description");
    event2.setCreateDate(new Date());
    event2.setCat(catChild1);
    
    Event event3 = new Event();
    event3.setDescription("event'3 description");
    event3.setCreateDate(new Date());
    event3.setCat(catChild2);
    
    Event event4 = new Event();
    event4.setDescription("event'4 description");
    event4.setCreateDate(new Date());
    event4.setCat(catChild3);
    
    
    // �}�Ҷ��q
    Session session = HibernateUtil.getSession();
    
    // �}�ҥ��
    Transaction trans = session.beginTransaction();
    
    
   
    
    session.persist(catMother);
    session.persist(catChild1);
    session.persist(catChild2);
    session.persist(catChild3);
    session.persist(event1);
    session.persist(event2);
    session.persist(event3);
    session.persist(event4);
    
    
    /*
     * ���d��
     * ���@�몺���d�ߡA��s���N�����F�CHibernate �䴩�� "." �@���ާ@�����ݩʡA�Ϊk������ JSP ����EL�B�⦡�C
     * ��s���d�߾A�Ω�D���X�ݩʡA�ҦpEvent �� cat �ݩʡAStudent �� clazz �ݩʵ��C
     * �Ҧp�G
     */
    List<Event> list = session.createQuery("select e from Event e where e.cat.name= 'kevin' ").list();
    for(Event e:list){
      System.out.println("�ߦW�G"+e.getCat().getName());	
    } // end for(Cat c:list){
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
