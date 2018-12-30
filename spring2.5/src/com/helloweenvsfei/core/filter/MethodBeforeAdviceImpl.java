package com.helloweenvsfei.core.filter;

import java.util.Arrays;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

// ��{�d�I��������
public class MethodBeforeAdviceImpl implements MethodBeforeAdvice {
	
  public void before(Method method,Object[] args, Object obj) throws Throwable {
    System.out.println("����e�ˬd... ");
    System.out.println("Method: " + method.getName());
    System.out.println("Args: " + Arrays.asList(args));
    System.out.println("Object: " + obj);
  }
  
}
