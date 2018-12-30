package com.hibernate.test;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.bean.Cat;
import com.hibernate.util.HibernateUtil;

public class CatTest {
  
	
  public static void main(String args[]){
	  
	Cat monther = new Cat();
	monther.setName("Mary White");
	monther.setDescription("The Mama cat.");
	monther.setCreateDate(new Date());
	
	
	Cat kitty = new Cat();
	kitty.setMother(monther);
	kitty.setName("Kitty");
	kitty.setDescription("Hello Kitty.");
	kitty.setCreateDate(new Date());
	
	
	Cat mimmy = new Cat();
	mimmy.setMother(monther);
	mimmy.setName("Mimmy");
	mimmy.setDescription("Kitty's little twin sister.");
	mimmy.setCreateDate(new Date());
	
	
	
	
	// �}�Ҥ@�� Hibernate ���
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	// �}�Ҥ@�ӥ��
	Transaction trans = session.beginTransaction();
	
	session.persist(monther);  // �N monther �x�s�i��Ʈw
	session.persist(kitty);    // �N kitty �x�s�i��Ʈw
	session.persist(mimmy);    // �N mimmy �x�s�i��Ʈw
	
	
	// �d�߸�Ƥ����Ҧ�����
	@SuppressWarnings("all")
	List <Cat> catList = session.createQuery(" from Cat").list();
	
	
	// ��X�d�ߵ��G
	StringBuffer result = new StringBuffer();
	result.append("��Ʈw�̪��Ҧ����ߡG\r\n\r\n");
	
	// �ˬd
	for(Cat cc:catList){
	  result.append("�� �G"+cc.getName()+" , "); 
	  result.append("�߶����G"+(cc.getMother()==null?" �S������":cc.getMother().getName()));
	  result.append("\r\n");
	} // end for(Cat cc:catList){
	
	
	trans.commit();    // �ǰe���
	session.close();   // ���� Hibernate ���
	
	
	// �� Swing ��ܬd�ߵ��G
	JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
	JOptionPane.showMessageDialog(null,result.toString());
	
  }
  
  
}
