package com.helloweenvsfei.aop.dao.impl;

import javax.security.auth.login.AccountException;

import com.helloweenvsfei.aop.dao.IAOPService;

public class AOPServiceImpl implements IAOPService {

  private String name;
  
  // �N�|�Q�d�I
  public void withAOP() throws Exception {
    System.out.println("�� AOP ����ư���Cname�G"+name);
    if(name.trim().length()==0){
      throw new AccountException("name �ݩʤ��ର��...");	
    }
  }

  
  // �N���|�Q�d�I
  public void withoutAOP() throws Exception {
    System.out.println("�S�� AOP ����ư���");
  }


  /**
   * @return the name
   */
  public String getName() {
	return name;
  }


  /**
   * @param name the name to set
   */
  public void setName(String name) {
	this.name = name;
  }

  
  
  
  
}
