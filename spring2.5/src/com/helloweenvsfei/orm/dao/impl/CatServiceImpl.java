package com.helloweenvsfei.orm.dao.impl;

import java.util.List;

import com.helloweenvsfei.orm.bean.Cat;
import com.helloweenvsfei.orm.dao.ICatDao;
import com.helloweenvsfei.orm.dao.ICatService;

// Service ������{
public class CatServiceImpl implements ICatService {

  private ICatDao catDao;  // DAO ����
    
  public ICatDao getCatDao() {
	return catDao;
  }

  public void setCatDao(ICatDao catDao) {
	this.catDao = catDao;
  }

  
  

  // ���[��Cat ����(�x�sCat ����)
  public void createCat(Cat cat) {
    if(catDao.findCatByName(cat.getName())!=null){  // �ˬd�P�W��Cat �O�_�s
      throw new RuntimeException("�ߡG"+cat.getName()+",�w�g�s�b�C");  // �ߥX�ҥ~
    }else{                                          // �p�G���s�b�h�إ�
      catDao.createCat(cat);
    }
  } // end public void createCat(Cat cat) {

  
  
  
  // �C�X�Ҧ���Cat
  public List<Cat> listCat() {
	return catDao.listCats();      // �d�ߩҦ�Cat ����
  } // end public List<Cat> listCat() {

  
  
  
  // �d��Cat �ƶq
  public int getCatsCount() {
	return catDao.getCatsCount();   // �Ǧ^�w���`��
  } // end public int getCatsCount() {

}
