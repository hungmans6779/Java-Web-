package com.helloweenvsfei.orm.dao;

import java.util.List;

import com.helloweenvsfei.orm.bean.Cat;

public interface ICatService {
	
  // ���[��Cat ����
  public void createCat(Cat cat); 
  
  // �C�X�Ҧ���Cat
  public List<Cat>listCat();   
  
  // �d��Cat �ƶq
  public int getCatsCount();  
}
