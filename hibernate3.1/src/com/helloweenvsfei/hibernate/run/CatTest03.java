package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest03 {


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
  
    
    // �Ǧ^ Object[] �} �C
    // �d�ߦh���ݩʮɡAHibernate �N�P�ɶǦ^�h�Ӫ���(�HObject[] �����Ǧ^)�C�Ǧ^���}�C�O���List<Object[]> �����A
    // �o��Ǧ^���}�C�ݭn�ˬdList ����A
    // �Ҧp�G
    List<Object []> list = session.createQuery("select c.name,c.mother.name,c.createDate from Cat c ").list();
    for(Object[] row:list){
      for(Object obj:row){
    	System.out.println(""+obj);  
      }
    }
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
