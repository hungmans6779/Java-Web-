package com.helloweenvsfei.struts.bean;

/*
 * ��POJO �����n���[����
     �iPOJO�j(Plain Old Java Object): �㦳�~���޿�B�z���W�h�� Java ��H�]regular java objects�^
       �Ѿ\�Ghttp://supermand9362787.wordpress.com/
   Java ��H���O JavaBean�BEntityBeans�]EJB���@�ء^�C
   POJO�@�ӥ��W��Java��H�]���OJavaBean�AEntityBean���^�A�]�������󪺯S������A�]����{����Java�ج[���w�����f�C
		 
   POJO ���Ӥ��O�ڭ̶}�l�{���� JavaBean�A��M�󤣬O EJB�A�������Ө̿��ج[�Y�~�өι�{�Y�Ǯج[���α��f�C
        �Ҧp�GStruts1���� Action �M ActionForm ��M���ݩ�POJO�F�A
        �Ӧb Struts2 ���� Action �ѩ�i�H���~�ӥ��󪺱��f�A�ҥH�b�o�ر��p�U Action �O POJO�A
       ���O Struts2 ���� Action �]�i�H�~�� ActionSupport ���N���A�ݩ�POJO�F�C
   POJO �̭��O�i�H�]�t�~���޿�B�z�M���[���޿�A�]�i�H�]�t�����PJavaBean�ݩʩM���ݩʳX�ݪ� set �M get ��k���C
        �̫�A�ڭ��`���@�U���@�өw�q
   POJO �O�@��²�檺�B���WJava��H�A���]�t�~���޿�B�z�Ϋ��[���޿赥�A
        �����OJavaBean�BEntityBean���A���㦳����S����M���~�өΤ���{����䥦Java�ج[�����O�α��f�C
		 
   http://dev.firnow.com/course/3_program/java/javashl/200845/108451.html
 */


// POJO
public class Person {

	private String name;       // �b��
	private String account;    // �m�W

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

}
