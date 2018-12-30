package com.helloweenvsfei.hibernate.run;

import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest08 {


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
  
    
    // �έp���
    /*
     *  ��SQL �@�ˡAHibernate �]���Ѥ@�t�C���έp��ơCHibernate �|��HQL ���έp�����Ƭ����h��ƮwSQL�䴩����ơC
     *  SQL �`�Ϊ��έp��ƨҦp�Acount()�Bsum()�Bmin()�Bmax()�Bavg()�Bcount(distinct...) ���]����ΦbHQL �A�y�k�PSQL�@�ˡC
     */
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select count(c) from Cat c       \n");
    sqlStr.append("   where c.mother != null          \n");
 
    Number num = (Number)session.createQuery(sqlStr.toString()).uniqueResult();
    int count = num.intValue();
    System.out.println("�ߪ��`�� count = "+count);
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
