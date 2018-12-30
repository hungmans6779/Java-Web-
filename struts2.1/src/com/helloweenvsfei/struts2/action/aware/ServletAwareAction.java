package com.helloweenvsfei.struts2.action.aware;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;



/*
 *  Struts2.x ���C�� Action ��ҷ|�Q���ШϥΡC�� Struts 2 ���C�� Action ���|���h�ӹ�ҡA�B�z�@���ШD���ͤ@�ӹ�ҡA
 *  �o�ǹ�ҩ����W�ߡA�B�z�����Y�P���C
 *  �ҥH Struts 2 �O������w�����C�ѩ� Action ���S����L�S��귽�A�ϥΧ�����K�Q�����߱�A�Ӥ��|�y�����O�C
 *  
 *  ActionSupport ����{�F��L����k�A�Ҧp������ҵ��A�~�� ActionSupport ���n�B�O�i�H�����ϥθ�����ҵ�  Struts2 ��X��k�C
 *  
 *  Struts2 ���ѤF Aware �����CAware ��"�P��"���N��A��{�F����  Aware ������Action ����P���������귽�C
 *  Struts �b���͹���@�� Action ��ҮɡA�p�G�o�{����{�F������ Aware �����A�|��������귽�z�L Aware ������k�`�g�i�h�C
 *  �o�ؤ覡�]�i�H�s���g�覡(IoC�覡)�C 
 *  
 *  Aware �������O�@���d�I���A�d�I���{���X�|�b���� Action ���e����A�N������Servlet ����]�w�i�ӡC
 */
public class ServletAwareAction extends ActionSupport implements ServletContextAware,SessionAware,ServletRequestAware,ServletResponseAware{

	private ServletContext application;     // Servlet �W�U��
	private Map session;                    // session ����
	private HttpServletRequest request;     // request ����
	private HttpServletResponse response;   // response ����

	
	
	public void setServletContext(ServletContext application) {
      this.application = application;		
	}

	public void setSession(Map sessionValues) {
      this.session = sessionValues;
	}

	public void setServletRequest(HttpServletRequest request) {
	  this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
      this.response = response;
	}

	
	
	
    // �D��k
	public String execute(){
	  
	  System.out.println("********************************************");
	  System.out.println(ServletAwareAction.class.getName());
	  System.out.println("application.getRealPath('upload') = "+application.getRealPath("upload"));	
	  System.out.println("session.get('account')            = "+session.get("account"));  
	  System.out.println("request.getRemoteAddr()           = "+request.getRemoteAddr());
	  System.out.println("response.getContentType()         = "+response.getContentType());
	  System.out.println("********************************************");
	  
	  return Action.SUCCESS;
	} // end  execute()
		
		
  	
  	
}
