package com.helloweenvsfei.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class ApplicationConstants {
	
	public static Map<String, HttpSession> SESSION_MAP = new HashMap<String, HttpSession>(); // �Ҧ��� Session
	public static int CURRENT_LOGIN_COUNT = 0;             // �ثe�n�J���ϥΪ��`��
	public static int TOTAL_HISTORY_COUNT = 0;             // ���v�X���`��
	public static Date START_DATE = new Date();            // �A�Ⱦ��Ұʮɶ�
	public static Date MAX_ONLINE_COUNT_DATE = new Date(); // �̰��b�u�ɶ�
	public static int MAX_ONLINE_COUNT = 0;                // �̰��b�u�H��
	
}
