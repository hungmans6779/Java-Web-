package com.helloweenvsfei.hibernate.run;

import java.awt.Font;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Cat;
import com.helloweenvsfei.hibernate.util.HibernateUtil;

public class CatTest01 {


  public static void main(String[] args) {
	
	Cat mother1 = new Cat();
	mother1.setName("Mary White");
	mother1.setDescription("The Mother's cat1.");
	mother1.setCreateDate(new Date());

	Cat mother2 = new Cat();
	mother2.setName("Helen Pink");
	mother2.setDescription("The Mother's cat2.");
	mother2.setCreateDate(new Date());
	
	
	Cat kitty = new Cat();
	kitty.setName("Kitty");
	kitty.setDescription("Hello Kitty.");
	kitty.setMother(mother1);   // �]�w�P mother1 �����k���Y(�h��@�����Y)
	kitty.setCreateDate(new Date());
		
	
	Cat mimmy = new Cat();
	mimmy.setName("Mimmy");
	mimmy.setDescription("Kitty's little twin sister. ");
	mimmy.setMother(mother1);  // �]�w�P mother1 �����k���Y(�h��@�����Y)
	mimmy.setCreateDate(new Date());
	
	
	Cat kevin = new Cat();
	kevin.setName("Kevin");
	kevin.setDescription("Kevin boy cat.");
	kevin.setMother(mother2);  // �]�w�P mother2 �����k���Y(�h��@�����Y)
	kevin.setCreateDate(new Date());
	
	
	
	
	
	// �}�Ҥ@�� Hibernate ���
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	// �}�Ҥ@�ӥ��
	Transaction trans = session.beginTransaction();
	
	
	// �N������cat �����x�s�ܸ�Ʈw
	session.persist(mother1);   // �N  mother1 �x�s�i��Ʈw
	session.persist(mother2);   // �N  mother2 �x�s�i��Ʈw
	session.persist(kitty);     // �N  kitty  �x�s�i��Ʈw
	session.persist(mimmy);     // �N  mimmy  �x�s�i��Ʈw
	session.persist(kevin);     // �N kevin  �x�s�i��Ʈw
	
	
	// �d�߸�ƪ����Ҧ���
	// �]�O�@�y (HQL �y�k�GHibernate Query Language�AHibernate �d�߱ԭz)�A
	// ������SQL�A���P���OHQL �̨ϥΪ��O Entiry ���O�W(Cat)
	@SuppressWarnings("all")
	// List<Cat> catList = session.createQuery(" from Cat").list();
	List<Cat> catList = session.createQuery("select c from Cat c").list();
	
	StringBuffer result = new StringBuffer();
	result.append("��Ʈw�̪��Ҧ��ߡG\r\n\r\n");
	for(Cat cat:catList){
	  result.append("�ߡG"+cat.getName()+", ");	
	  result.append("�߶����G"+(cat.getMother()==null?"�S���O��":cat.getMother().getName()));
	  result.append("\r\n");
	} // end for(Cat cat:catList){
	
	
	
	// �ǰe���
	trans.commit();
	
	// ����  Hibernate ���
	if(session!=null){ session.close();  }
	
	
	// �� Swing ��ܬd�ߵ��G
	JOptionPane.getRootFrame().setFont(new Font("Arial",Font.BOLD,14));
	JOptionPane.showMessageDialog(null,result.toString());

  } // end void main

  
}
