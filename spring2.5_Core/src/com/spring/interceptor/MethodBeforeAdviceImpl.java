package com.spring.interceptor;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;


/*
 *  �b�Y�Ǥ�k�e���檺�d�I��
 */
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {

	
  public void before(Method method, Object[] args, Object obj) throws Throwable {
	System.out.println(MethodBeforeAdviceImpl.class.getName()+",before()  execute...");
    System.out.println("����e�ˬd");
    System.out.println("Method�G"+method.getName());    // ��X��T
    System.out.println("Args�G"+Arrays.asList(args));   // ��X�Ѽ�
    System.out.println("Object�G"+obj);                 // ��X����
  } // end before

  
}
