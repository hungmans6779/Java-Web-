package com.helloweenvsfei.aop.filter;

import java.lang.reflect.Method;


import org.springframework.aop.MethodBeforeAdvice;

import com.helloweenvsfei.aop.dao.impl.AOPServiceImpl;

/*
 * �m��k�e�d�I���n
 *  ��k�e�d�I���ˬdname �O�_�� null
 *  ��k�e�d�I���A��{�� MethodBeforeAdvice �����C
 *  ��k�e�d�I���b������w��k�e�Q�I�s�A�ѼƤ��O���Q�I�s����k�B����ɳQ�ǤJ���ѼơA�Q�d�I��Bean�C
 *  �Q�d�I�������k�b applicationContext-aop.xml ���]�w�C
 */
public class MethodBeforeInterceptor implements MethodBeforeAdvice {

	
  // �I�s���󪺤�k�e�N����Ӥ�k�A�ѼƤ��O���Q�I�s����k�A�Q�I�s��k���ѼơB����
  public void before(Method method, Object[] args, Object instance) throws Throwable {
	System.out.println(MethodBeforeInterceptor.class.getName()+",before() �Y�N�n�����k�G"+method.getName());
	
	if(instance instanceof AOPServiceImpl){
	  String name = ((AOPServiceImpl) instance).getName();  // ��oname
	  if(name==null){
		throw new NullPointerException(MethodBeforeInterceptor.class.getName()+" , name �ݩʤ��ରnull...");
	  }
	} // end if(instance instanceof AOPServiceImpl){
	
  } // end before

}
