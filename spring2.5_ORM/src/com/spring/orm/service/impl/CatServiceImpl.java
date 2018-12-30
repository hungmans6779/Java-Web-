package com.spring.orm.service.impl;

import java.util.List;

import com.spring.orm.dao.ICatDao;
import com.spring.orm.entity.Cat;
import com.spring.orm.service.ICatService;


/*
 *  CatServiceImpl ��{�FICatService �����C�{���X���w�F�@�� DAO �����ݩʡA�H�� getter�Bsetter ��k�C
 *  Spring �N�z�L getter�Bsetter ��k�`�g�b DAO ����CService �h�z�L DAO �����{�~���޿�C
 *  
 *  DAO �h�G�t�d��ƪ��x�s�B�x�s;
 *  Service �h�G�t�d�ˬd��ƪ�����ʡA�Ҧp�ˬd�O�_���W��;
 */
public class CatServiceImpl implements ICatService {

	public CatServiceImpl() {

	}

	
	// Cat DAO ����
	private ICatDao catDao;

	public ICatDao getCatDao(){
		return catDao;
	}

	public void setCatDao(ICatDao catDao) {
		this.catDao = catDao;
	}

	
	
	
	/*
	 * �x�s Cat ����
	 * 
	 * @param Cat ����
	 */
	public void createCat(Cat cat) {
	  System.out.println(CatServiceImpl.class.getName()+",createCat() execute...");
	  Cat catObj = catDao.findCatByName(cat.getName());
	  System.out.println("catObj mm= "+catObj);
	  
      if(catObj !=null ){
    	throw new RuntimeException("�� "+cat.getName()+", �w�g�s�b�I�I�I");  
      }
      catDao.createCat(cat); 
	} // end createCat(Cat cat)

	
	
	/*
	 * �C�X�Ҧ� Cat
	 * 
	 * @return int Cat �ƶq
	 */
	public List<Cat> listCats(){
	  return this.catDao.listCats();
	} // end listCats()

	
	
	/*
	 * �d�� Cat �ƶq
	 * 
	 * @return int �ƶq
	 */
	public int getCatsCount() {
	  return this.catDao.getCatsCount();
	} // end getCatsCount()

	
}
