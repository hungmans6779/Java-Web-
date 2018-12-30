package com.helloweenvsfei.hibernate.util;

import java.sql.Date;

import java.sql.Time;
import java.text.NumberFormat;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.helloweenvsfei.hibernate.bean.Employee;

public class StringUtil {

	
  // �üƲ��;�
  private static Random random = new Random();
  
  
  // �H������ Employee ���
  public static Employee getRandomEmployee(){
	 
	String name = "";  // �m�W�A�H������
	// ���� 2�B3 �Ӥ���r
	for(int i=0,n=2+(random.nextInt(8)==0?0:1);i < n;i++){
	  try{
	    name += getChineseCharacter(System.currentTimeMillis()+i);  // �Ǧ^�H������r
	  }catch(Exception e){
		e.printStackTrace();  
	  }
	} // end for(int i=0,n=2+(random.nextInt(8)==0?0:1);i < n;i++){
	
	int year = 1950 + random.nextInt(40);               // �H���~�G1950 - 1990
	int month = 1 + random.nextInt(12);                 // �H����G1-12
	int day = 1 +random.nextInt(31);                    // �H����G1-31
	int hh = 7 + random.nextInt(2);                     // �H���p�ɡG7��9
	int mm = random.nextInt(60);                        // �H�������G0��59
	int ss = random.nextInt(60);                        // �H����     �G0��59
	int hhh = 16 + random.nextInt(2);                   // �H���p�ɡG16��18
	
	double salary = 1000 + random.nextDouble() * 5000;  // �H���~��:1000 �� 6000
	
	System.out.println("name = "+name);
	System.out.println("year = "+year+",month = "+month+",day = "+day);
	System.out.println("hh   = "+hh+",mm = "+mm+",ss = "+ss+",hhh = "+hhh);
	
	Employee employee = new Employee();
	employee.setName(name);
	employee.setAge(20+random.nextInt(40));                       // �]�w�H���~�֡G20-60
	employee.setBirthday(Date.valueOf(year+"-"+month+"-"+day));   // �]�w�H���ͤ� 
	employee.setDateCreated(new java.util.Date());                // �إ߮ɶ�
	employee.setDescription("");                                  // �Ƶ�
	employee.setDisabled(random.nextInt(10)==9);                  // �O�_�Q����A10% �����v
	employee.setSex(random.nextInt(3)==2?"�k":"�k");              // �m�W�A�k�k��ҡG 2:1
	employee.setStartTime(Time.valueOf(hh+":"+mm+":"+ss));        // �H���W�Z�ɶ�
	employee.setEndTime(Time.valueOf(hhh+":"+mm+":"+ss));         // �H���U�Z�ɶ�
	employee.setSalary(salary);
	
	
	return employee;
  } // end getRandomEmployee
  
  
  
  
  
  
  
  // �Ǧ^�H������r
  private static String getChineseCharacter(long seed) throws Exception{
	String str = null;                             // �x�s���G
	int highPos,lowPos;                            // ���줸�A�C�줸
	
	Random random = new Random(seed);              // �üƲ��;�
	highPos = 176 + Math.abs(random.nextInt(39));  // �p�Ⱚ�줸
	lowPos = 161 + Math.abs(random.nextInt(93));   // �p��C�줸
	System.out.println(StringUtil.class.getName()+",seed = "+seed+",highPos = "+highPos+",lowPos = "+lowPos);
	
	byte [] b = new byte[2];                       // ��Ƭ� B ����
	b[0] = (new Integer(highPos)).byteValue();     // ���줸��
	b[1] = (new Integer(lowPos)).byteValue();      // �C�줸��
	str = new String(b,"GBK");                     // ��Ƭ�����r
	
	return str;
  } // end getChineseCharacter
  
  
  
  

  public static boolean isNull(Object obj) {
	return obj == null;
  }

  
  public static boolean isNull(String obj) {
	return obj == null || obj.trim().length() == 0;
  }
  
  
  
  public static String getURL(HttpServletRequest request){
	String requestURI = request.getRequestURI();
	String queryString = request.getQueryString();
	String url = requestURI +"?"+filterQueryString(queryString);
    
    return url;
  } // en 
  
  
  
  
  
  
  // �ϥΥ��W�B�⦡�L�o���w�Ѽ�
  public static String filterQueryString(String queryString){
	if(queryString==null)
	  return "";

	// �L�o sort
	queryString = queryString.replace("[^&]sort=[^&]*","");
	
	// �L�o order
	queryString = queryString.replace("[^&]order=[^&]*","");
	
	// �L�o action
	queryString = queryString.replace("[^&]action=[^&]*","");
	
	// �L�o���� &&
	queryString = queryString.replace("&{2,}","&");

	// �L�o�}�l�r�� &
	queryString = queryString.replace("^&","");
	
	// �L�o�����r�� &
	queryString = queryString.replace("&$","");
	
	return queryString;  
  } // end filterQueryString(String queryString){
  
  
  
  
  
  
  public static void main(String args[]){  
	Employee e1 = getRandomEmployee();
	Employee e2 = getRandomEmployee();
	
	System.out.println("�üƲ���  e1 name = "+e1.getName());
	System.out.println("�üƲ��� e2 name = "+e2.getName());
  } // end main
  
  
  

  
  
}
