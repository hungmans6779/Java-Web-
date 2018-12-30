package com.helloweenvsfei.hibernate.run;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Article;
import com.helloweenvsfei.hibernate.bean.Type;
import com.helloweenvsfei.hibernate.util.HibernateXMLUtil;

public class TestXMLTypeArticle {


  public static void main(String[] args) {
	
	Type type = new Type();
	type.setName("�ǳN�פ�");

	Article article = new Article();
	article.setType(type);
	article.setName("���M�ɥN�j��p����s");
	article.setContent("���M�ɥN�O����j��p�������p�ɴ��A��{�F�@��g�媺�p���C�|�j�W�۫K�O����o�Ӯɴ��C");
	
	
	// �}�Ҷ��q
	Session session = HibernateXMLUtil.getSession();
	
	// �}�ҥ��
	Transaction trans = session.beginTransaction();
	
	
	session.persist(article);
	
	
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("  select a from Article a       \n");
	sqlStr.append("   where a.name like '%���M%'   \n");
	
	
	
	List<Article> list = session.createQuery(sqlStr.toString()).list();
	for(Article a:list){
	  System.out.println("���O�G"+a.getType().getName());
	  System.out.println("���D�G"+a.getName());
	  System.out.println("���n�G"+substring(a.getContent(),50));
	} // end for(Article a:list){
	
	
	// �������
	trans.commit();
	
	// �}�����q
	session.close();
		
  } // end main
  
  
  private static String substring(String content,int i){
	return content==null?"":content.length()<(i+1)?content:content.substring(0,i);  
  }

}
