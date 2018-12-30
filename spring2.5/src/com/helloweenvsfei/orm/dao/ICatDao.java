package com.helloweenvsfei.orm.dao;

import java.util.List;

import com.helloweenvsfei.orm.bean.Cat;

// DAO ����
public interface ICatDao {  

  // �x�s����	
  public void createCat(Cat cat);

  // �d�ߩҦ�����
  public List<Cat> listCats();
 
  // �Ǧ^����  
  public int getCatsCount();
 
  // �ھڦW�r�d�ߪ���
  public Cat findCatByName(String name);
  
}
