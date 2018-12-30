package com.helloweenvsfei.util;


import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.helloweenvsfei.util.ApplicationConstants;

public class MyContextListener implements ServletContextListener {

	// �ҰʮɡA�O���A�Ⱦ��Ұʮɶ�
	public void contextInitialized(ServletContextEvent event) {
	  ApplicationConstants.START_DATE = new Date();    // �O���A�Ⱦ��Ұʮɶ�
	}

	
	// �����ɡA�N���G�M���C�]�i�H�N���G�x�s��w�ФW�C
	public void contextDestroyed(ServletContextEvent event) {	
	  ApplicationConstants.START_DATE = null;              // �M�ŪA�Ⱦ��Ұʮɶ�
	  ApplicationConstants.MAX_ONLINE_COUNT_DATE = null;   // �M�ų̰��b�u�ɶ�
	}
	
	
	
}
