package com.spring.orm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.spring.orm.dao.ICatDao;
import com.spring.orm.entity.Cat;


/*
 *  ��{ ICatDao ����
 *  
 *  
 *  �bSpring �̡AHiberate ���귽�n�浹 Spring �޲z�CHibernate �Ψ� SessionFactory ���u�O Spring �@�ӯS�� Bean �A
 *  �� Spring �t�d���͹���P�P���C�]���ADAO �h�u�n�~�� org.springframework.orm.hibernate3.support.HibernateDaoSupport �A
 *  �Ӥ��ݭn�P Hibernate �� API ����D�A���ݭn�}�ҡB���� Hibernate �� Session�BTransaction �BSpring �|�۰ʺ��@�o�Ǫ���C
 */
public class CatDaoImpl extends HibernateDaoSupport implements ICatDao {

	
  /*
   *  �x�s����
   *  @param Cat ����
   */
  public void createCat(Cat cat) {
    this.getHibernateTemplate().persist(cat);  // �ϥ� Template �x�s
  } // end createCat

  
  
  
  
  /*
   *  �d�ߩҦ�����
   *  @return Cat List ����
   */
  public List<Cat> listCats() {
	List list = this.getHibernateTemplate().find("select c from Cat c ");

	return list;
  } // end listCats()

  
  
  
  
  /*
   *  �Ǧ^����ƶq
   *  @param int �ƶq
   */
  public int getCatsCount() {
	Number n = (Number) this.getSession(true).createQuery("select count(c) from Cat c ").uniqueResult();

	return n.intValue();
  } // end getCatsCount()

  
  
  
  
  /*
   *  �ھڦW�r�d�ߪ���(�ھڦW�r�d��Cat)
   *  @return Cat ����
   */
  public Cat findCatByName(String name){
    List<Cat> catList = this.getHibernateTemplate().find("select c from Cat c where c.name = ? ",name);
    
    if(catList.size() > 0 ){
      return catList.get(0);  // �Ǧ^�Ĥ@��	
    }else{
      return null;
    }  
  } // end findCatByName

  
  
  
}