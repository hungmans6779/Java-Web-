package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Sailor;
import com.helloweenvsfei.hibernate.bean.Ship;
import com.helloweenvsfei.hibernate.util.HibernateUtil;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;



//���䪺�@��@���p�ʡGĥ��޲z
@SuppressWarnings("all")
public class TestXMLShipSailor {

	
  public static void main(String[] args) {
	
	// *********************************************************************
	// �Ĥ@�� :�ز��y��  
	
	// ĥ��  
	Ship ship1 = new Ship();  
    ship1.setName("�ز��y��");
	
    // ���
    Sailor captain1 = new Sailor();
	captain1.setName("�v�K��");
    captain1.setShip(ship1);
	
 
    // ���1
    Sailor sailor11 = new Sailor();
    sailor11.setName("�ǧJ");
    sailor11.setShip(ship1);
 
    // ���2
    Sailor sailor12 = new Sailor();
    sailor12.setName("����");
    sailor12.setShip(ship1);
 
    // ���3
    Sailor sailor13 = new Sailor();
    sailor13.setName("�ͥ���h�y");
    sailor13.setShip(ship1);
 
 
    ship1.setCaptain(captain1);
    ship1.getSailors().add(sailor11);
    ship1.getSailors().add(sailor12);
    ship1.getSailors().add(sailor13);
    // *********************************************************************
 
 
 
    // *********************************************************************
    // �ĤG�� :�˨}�渹
    Ship ship2 = new Ship();
    ship2.setName("�˨}�渹");
 
    // ��� 
    Sailor captain2 = new Sailor();
    captain2.setName("kevin");
    captain2.setShip(ship2);
 
    // ���1
    Sailor sailor21 = new Sailor();
    sailor21.setName("�@���a�R");
    sailor21.setShip(ship2);
 
    // ���2
    Sailor sailor22 = new Sailor();
    sailor22.setName("�s�f�̤l");
    sailor22.setShip(ship2);    
 
    ship2.setCaptain(captain2);
    ship2.getSailors().add(sailor21);
    ship2.getSailors().add(sailor22);
    // *********************************************************************   
 
 
 
    // �}�Ҷ��q 
    Session session  = HibernateXMLUtil.getSession();
 
    // �}�ҥ��
    Transaction trans =session.beginTransaction(); 

    // ���[�ƪ���
    session.persist(ship1);
    session.persist(ship2);
 
    
    
    
    System.out.println("�d�ߡi�ز��y���j ���Ҧ����\n");
    // �d�ߡi�ز��y���j ���Ҧ����
    List<Sailor> list1 = session.createQuery(" select s from Sailor s where s.ship.name = :name").setParameter("name","�ز��y��").list();
    for(Sailor s:list1){
      System.out.print("***************************************************\n");
      System.out.println("����G"+s.getName());
      System.out.println("ĥ�� �G"+s.getShip().getName());
      System.out.println("����G"+s.getShip().getCaptain().getName());
      System.out.print("***************************************************\n");
    } // end for(Sailor s:list){
 
 
 
    System.out.println("�d�ߡi�˨}�渹�j ���Ҧ����\n");
 
 
    // �d�ߡi�˨}�渹�j ���Ҧ����
    List<Sailor> list2 = session.createQuery(" select s from Sailor s where s.ship.name = :name").setParameter("name","�˨}�渹").list();
    for(Sailor s:list2){
      System.out.print("***************************************************\n");
      System.out.println("����G"+s.getName());
      System.out.println("ĥ�� �G"+s.getShip().getName());
      System.out.println("����G"+s.getShip().getCaptain().getName());
      System.out.print("***************************************************\n");
    } // end for(Sailor s:list){
 
 
    // �������
    trans.commit();
 
    // �������q
    session.close();
 
  } // end main

}
