package com.helloweenvsfei.core.service.impl;

import com.helloweenvsfei.core.dao.IDao;
import com.helloweenvsfei.core.service.IService;

// ��{ IService ��������k
public class ServiceImpl implements IService {

  // �w�q�@��IDao ����
  private IDao dao;
  
  // ��{ service()��k
  public void service(String name) {
    System.out.println(dao.sayHello(name));  // �I�sIDao ��������k
  }

  
  /**
   * @return the dao
   */
  public IDao getDao() {
	return dao;
  }

  
  /**
   * @param dao the dao to set
   */
  public void setDao(IDao dao) {
	this.dao = dao;
  }
  
 
  
  
	
}
