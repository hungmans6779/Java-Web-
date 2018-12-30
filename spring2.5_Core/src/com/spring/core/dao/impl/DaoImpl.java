package com.spring.core.dao.impl;

import java.util.Calendar;

import com.spring.core.dao.IDao;

/*
 *  ��{ IDao ����
 */
public class DaoImpl implements IDao {

  // ��{ sayHello()
  public String sayHello(String name) {
	System.out.println(DaoImpl.class.getName() + ",sayHell()  execute...");

	int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

	if (hour < 6)
	  return "��᦭," + name;
	if (hour < 12)
	  return "���W�n," + name;
	if (hour < 13)
	  return "���Ȧn," + name;
	if (hour < 18)
	  return "�U�Ȧn," + name;
	return "�ߤW�n," + name;
  } // end sayHello
  
}
