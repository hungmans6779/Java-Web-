package com.helloweenvsfei.orm.dao.impl;

import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatDao;

public class CatDaoImpl extends HibernateDaoSupport implements ICatDao {
 

  // �x�s����	
  public void createCat(Cat cat){
    this.getHibernateTemplate().persist(cat);  // �ϥ�Template �x�s����
  }

 
  // �d�ߩҦ�����
  public List<Cat> listCats(){
	return this.getHibernateTemplate().find("select c from Cat c "); // �ϥ� Template �d��
  }
  

  // �Ǧ^����ƶq
  public int getCatsCount(){
	return Integer.valueOf(this.getSession(true).createQuery("select count(c) from Cat c ").uniqueResult().toString());
  }
  
  

  // �ھڦW�r�d�ߪ���(�ھڦW�r�d��Cat)
  public Cat findCatByName(String name){
	List <Cat> catList = this.getHibernateTemplate().find("select c from Cat c where c.name = ? ",name); // �ϥ� Template
	if(catList.size()>0){      // �p�G�����
      return catList.get(0);   // �Ǧ^�Ĥ@��
	} 
	return null;
  }
	
   



  
  
}
