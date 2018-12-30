package com.helloweenvsfei.struts2.action;

import java.sql.Date;
import java.sql.Time;

import com.opensymphony.xwork2.ActionSupport;


/*
 *  Struts2.x ���C�� Action ��ҷ|�Q���ШϥΡC�� Struts 2 ���C�� Action ���|���h�ӹ�ҡA�B�z�@���ШD���ͤ@�ӹ�ҡA
 *  �o�ǹ�ҩ����W�ߡA�B�z�����Y�P���C
 *  �ҥH Struts 2 �O������w�����C�ѩ� Action ���S����L�S��귽�A�ϥΧ�����K�Q�����߱�A�Ӥ��|�y�����O�C
 *  
 *  ActionSupport ����{�F��L����k�A�Ҧp������ҵ��A�~�� ActionSupport ���n�B�O�i�H�����ϥθ�����ҵ�  Struts2 ��X��k�C
 */
public class ConvertorAction extends ActionSupport {

	private Date sqlDate;
	private Time sqlTime;
	private java.util.Date utilDate;

	
	
	// �D��k
	public String execute(){
	  System.out.println(ConvertorAction.class.getName()+",execute().....");
		
	  return INPUT;
	} // end execute()
	
	
	
	
	public String convert(){
	  System.out.println(ConvertorAction.class.getName()+",convert().....");
	  
	  return SUCCESS;	
	} // end convert()
	
	
	
	
	
	
	
	
	
	public Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public Time getSqlTime() {
		return sqlTime;
	}

	public void setSqlTime(Time sqlTime) {
		this.sqlTime = sqlTime;
	}

	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	
}