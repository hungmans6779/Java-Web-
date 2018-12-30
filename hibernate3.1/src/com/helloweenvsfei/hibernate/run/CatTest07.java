package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest07 {


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
  
    
    // �Ǧ^ Java ���骫��
    /*
     *  ���u�d�߳����ݩʪ��d�ߡA�Ǧ^�}�C�BList�BMap �ɡA�ܤ�K�A���O�ާ@Object[] �}�C�AList�BMap �����p�ާ@���骫���K�C
     *  ��ڤW�d�߳����ݩʮɡA�]�i�H�Ǧ^���骫��CHQL���]�i�H�ϥΫغc��ơC
     */
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select c from Cat c                   \n");
    sqlStr.append("   where c.mother.name != null          \n");
    sqlStr.append("     and c.createDate < :createDate     \n");
        
    List<Cat> catList = session.createQuery(sqlStr.toString()).setParameter("createDate",new Date()).list();
    System.out.println("catList size = "+catList.size());
    for(Cat c:catList){
      System.out.println("*******************************************");
      System.out.println("�ߦW�G"+c.getName());
      System.out.println("�y�z�G"+c.getDescription());
      System.out.println("�إߤ���G"+c.getCreateDate());
      System.out.println("���ߪ��W�r�G"+(c.getMother()!=null?c.getMother().getName():""));
      System.out.println("*******************************************");
    }
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
