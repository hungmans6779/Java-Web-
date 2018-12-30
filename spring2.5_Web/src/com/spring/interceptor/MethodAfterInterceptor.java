package com.spring.interceptor;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/*
 *  ��k���d�I��
 *  
 *  ��{��AfterReturningAdvice�����C�Ǧ^���d�I���b���槹���w��k�B�öǦ^����Q�I�s�C
 *  �p�G���Ǧ^�ȡA�i�H����Ǧ^�ȡA�_�h�� null �C�ѼƤ��O����k�Ǧ^�ȡB�Q�I�s����k�B����ɳQ�ǤJ���ѼơB�Q�d�I�� Bean�C
 *  
 */
public class MethodAfterInterceptor implements AfterReturningAdvice {

  public void afterReturning(Object value,Method method,Object[] args,Object object) throws Throwable {
	System.out.println(MethodAfterInterceptor.class.getName()+",afterReturning()  execute...");
	System.out.println("��k "+method.getName()+" ���槹���A�Ǧ^�ǡG"+value);
  } // end afterReturning

	
}
