package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Post;
import com.helloweenvsfei.hibernate.bean.Tag;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;




@SuppressWarnings("all")
public class TestXmlTagPost {
	
  public static void main(String[] args) {
	  
	  
    Tag tag1 = new Tag();
    tag1.setName("���q");                               // �]�w�W��
	
    Tag tag2 = new Tag();
    tag2.setName("����");                               // �]�w�W��
    
    
   
    Post post = new Post();                             // �إ�Post
    post.setTilte("���ˤ@�Ӧn�����s�i�A�ܦ������𮧳�");  // �]�w���D
    post.setContent("�����T�A�ۤv�ݧa");                 // �]�w���e
    
    // �]�w��Ӽ���
    post.getTags().add(tag1);
    post.getTags().add(tag2);
    
    
    
    
    
    
    
    // �}�Ҷ��q
    Session session = HibernateXMLUtil.getSession();
    
    
    // �}�ҥ��
    Transaction trans = session.beginTransaction();
    
    // ���[�ƪ���
    session.persist(post);  // �x�s�i��Ʈw
    
    
    // �d�߼��Ҭ�"���q"�����l 
    // �`�N�{���X����h��h�ݩʪ��d�ߡA�ϥΪ��OLEFT JOIN�C½Ķ����Ʈw��SQL�ԭz��A�o�O�@�Ӹ�T�Ӫ�(���Ҫ�B������B���l��)�������d�ߡC
    List<Post> list = session.createQuery("select p from Post p left join fetch p.tags t where t.name =:name ").setParameter("name","���q").list();
    
    System.out.print("�P���ҡu���q�v���������l");
    // ��X���l�D�D�ΩҦ���������
    for(Post p:list){
      System.out.println("���D�G"+p.getTilte());
      System.out.println("���ݼ��ҡG");
      // ��X�Ҧ�������
      for(Tag t:p.getTags()){
        System.out.println(t.getName()+",");	  
      } // end for(Tag t:p.getTags()){
      System.out.print("");
    } // end for(Post p:list){
    
    
    
    
    
    // ���s�q��Ʈw����o���
    session.refresh(tag1);
    
    
    
    
    System.out.println("���Ҭ��u"+tag1.getName()+"�v�U�����l�G");
    for(Post p:tag1.getPosts()){
      System.out.println("���D�G"+p.getTilte());
      System.out.println("���ݼ��ҡG");
      for(Tag t:p.getTags()){
    	System.out.println(t.getName()+",");
      }
      System.out.println();
    } // end for(Post p:tag1.getPosts()){
    
    
    // ������
    trans.commit();
    
    
    // �������q
    session.close();
    
    
  } // end main

}
