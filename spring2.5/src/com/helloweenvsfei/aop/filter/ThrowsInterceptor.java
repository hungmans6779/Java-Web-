package com.helloweenvsfei.aop.filter;

import java.lang.reflect.Method;
import javax.security.auth.login.AccountException;
import org.springframework.aop.ThrowsAdvice;

/*
 * �m�ҥ~�ߥX�d�I���n
 *  ��{�� ThrowsAdvice �����C�p�G���w����k�����ҥ~�Q�ߥX�A�h��Q�I�s�C�P�W����d�I���������P�A
 *  ThrowsAdvice �����S���w�q�����k�A�]�����ݭn��{�����k�C���O�p�G�w�q�F�F�Φp�G
 *  afterThrowing ([Method],[args],[target],subclassOfThrowable)����k�A�o�Ǥ�k�|�Q�I�s�C
 *  �ѼƤ��O���G�Q�I�s����k�B��k���ѼơB�Q�d�I��Bean �H�ΩߥX���ҥ~���C�o�̭��u���̫�@��O�������C
 *  Spring ���ҥH�o�˳]�p�A�O���F�϶}�o�̥i�H�F���a�w�q�h�Ӯ������P���ҥ~...
 */
public class ThrowsInterceptor implements ThrowsAdvice {
	
  public void afterThrowing(Method method,Object [] args,Object instance,AccountException ex) throws Throwable{
	System.out.println(ThrowsInterceptor.class.getName()+"��k �G"+method.getName()+" �ߥX�ҥ~�G"+ex);  
  }
  
  
  public void afterThrowing(NullPointerException ex) throws Throwable{
    System.out.println(ThrowsInterceptor.class.getName()+",�ߥX�ҥ~�G"+ex);	  
  }
  
  
}
