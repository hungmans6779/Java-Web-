package com.helloweenvsfei.core.dao.impl;

import java.util.Calendar;
import com.helloweenvsfei.core.dao.IDao;

// �� �{ IDao ����
public class DaoImpl implements IDao {

  // ��{ sayHello() 
  public String sayHello(String name){
	
	int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	if(hour<6){
	  return "���n,"+name;
	}else if(hour < 12){
	  return "���W�n,"+name;
	}else if(hour<13){
	  return "���Ȧn,"+name;	
	}else if(hour < 18){
      return "�U�Ȧn,"+name;		
	}else{
	  return "�ߤW�n,"+name;	
	}
	
  } // end public String sayHello(String name) 

  
  
}
