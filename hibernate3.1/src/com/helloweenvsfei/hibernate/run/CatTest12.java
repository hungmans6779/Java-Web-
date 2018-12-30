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

public class CatTest12 {


  public static void main(String[] args) {
    

    
    // �}�Ҷ��q
    Session session = HibernateUtil.getSession();
    
    // �}�ҥ��
    Transaction trans = session.beginTransaction();

    
    
    /*
     * �ϥ� SQL ��Ʈw
     * HQL �i�H�ݰ��O��Ҧ�SQL��Ʈw���ʸˡCHQL���Ѫ��\��O���h��ƮwSQL�䴩���AHQL�u�O�N�\��"½Ķ"���F���hSQL���\��C
     * ���Ǳ��p�U�A���h��Ʈw�|���ѬY�إ\��A���O�i��HQL���䴩�C�o�ɥi�H�ϥΩ��hSQL�A�b�M�~�N�y�W�s������SQL(Native SQL)
     * �Ҧp�G
     */
    
    
    SQLQuery sqlQuery = session.createSQLQuery(" show variables ");
    List<Object[]> list = sqlQuery.list();
    for(Object[] obj:list){
      System.out.println(obj[0]+", "+obj[1]+",");	   // ��X�ݩʭ�
    }
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
  } // end main
  

}
