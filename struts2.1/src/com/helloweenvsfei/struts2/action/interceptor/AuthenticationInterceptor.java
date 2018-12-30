package com.helloweenvsfei.struts2.action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/*
    �ۭq���\�i�v�����d�I��
    �d�I���i�H�ۥ��X�R�C�Ҧ����d�I������{��Interceptor �����C��{�ۭq�d�I���]�n��{ Interceptor �����C
    �@�몽���~�� AbstractInterceptor �y�H���O�Y�i�C    
 */
public class AuthenticationInterceptor extends AbstractInterceptor{

	
	@Override
	@SuppressWarnings("all")
	public String intercept(ActionInvocation invocation) throws Exception {
		
	  // �z�L invocation ��o�����I�s���W�U��
	  Map<String,Object> sessionValues = invocation.getInvocationContext().getSession();
	  
	  String account = (String) sessionValues.get("account");
	  System.out.println("kevintest account = "+account);
	  
	  
	  if(account==null){
		return "globalLogin";
	  }
	  
	  return invocation.invoke();  // �_�h�A���`����
	} // end public String intercept(ActionInvocation invocation) 

	
	
	
	@Override
	public void destroy() {
	  super.destroy();
	}

	
	@Override
	public void init() {
	  super.init();
	}


  	
}
