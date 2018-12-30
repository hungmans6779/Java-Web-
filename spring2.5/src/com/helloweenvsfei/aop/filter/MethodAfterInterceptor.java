package com.helloweenvsfei.aop.filter;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/*
 * �m��k���d�I���n
 * �Ǧ^�d�I���A��{��AfterReturningAdvice �����C�Ǧ^���d�I���b���槹���w��k�B�öǦ^����Q�I�s�C
 * �p�G���Ǧ^�ȡA�i�H���^�Ǧ^�ȡA�_�h ��null �C�Ѽƥo���O����k�Ǧ^�ȡB�Q �I�s����k�B����ɳQ�ǤJ���ѼơB�Q�d�I��Bean�C
 */
public class MethodAfterInterceptor implements AfterReturningAdvice {

  public void afterReturning(Object value, Method method, Object[] args, Object instance) throws Throwable {
	System.out.println(MethodAfterInterceptor.class.getName()+",��k "+method.getName()+" ���槹���A�Ǧ^�ǡG"+value);
  }
  
}
