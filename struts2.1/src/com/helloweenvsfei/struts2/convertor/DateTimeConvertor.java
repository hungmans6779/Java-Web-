package com.helloweenvsfei.struts2.convertor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;

import ognl.DefaultTypeConverter;


/*
 *  �t�X /WEB-INF/classes/xwork-conversion.properties ���]�w�ɨϥ�
 *  ���ഫ�������O�����~�� DefaultTypeConverter ���O�ù�{ convertValue() ��k�N�i�H�F�C
 *�@convertValue() ��3�ӰѼơA�Ѽ�value �����ഫ����ơA�Ѽ� toType ���n�����������C
 *  �`�N JSP �ǰe��ƮɡA�Ѽ� value �� request.getParmaeterValues(String name) �Ǧ^�� String[] ��������A�Ӥ��O String�C
 */
public class DateTimeConvertor extends DefaultTypeConverter{

  // ����榡�ƾ�
  private DateFormat [] dateFormat = {
     new SimpleDateFormat("yyyy-MM-dd"),
     new SimpleDateFormat("yyyy/MM/dd"),
     new SimpleDateFormat("yy-MM-dd"),
  };
	
  
  // �ɶ��榡�ƾ�
  private DateFormat [] timeFormat = {
	new SimpleDateFormat("HH:mm:ssss"),
	new SimpleDateFormat("HH:mm"),
  };
  
  
  
  public Object convertValue(Map context,Object value,Class toType){
	
	if(toType.equals(java.sql.Date.class)){           // �p�G�O  java.sql.Date ����	
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => java.sql.Date ,value = "+Arrays.toString((String[])value));
		
	  String [] parameterValues = (String [])value;   // ��l�r����
	  for(DateFormat format:dateFormat){              // �ϥ�3�ؤ���榡�ƾ��ഫ���
		try{
		  return new java.sql.Date(format.parse(parameterValues[0]).getTime());	
		}catch(Exception e){}
	  }
	}else if(toType.equals(java.sql.Time.class)){     // �p�G�O java.sql.Time ���� 
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => java.sql.Time ,value = "+Arrays.toString((String[])value));
	  
	  String [] parameterValues = (String[])value;    // ��l�r����
	  for(DateFormat format:timeFormat){              // �ϥ�2�خɶ��榡�ƾ��ഫ�ɶ�
		try{
		  return new java.sql.Time(format.parse(parameterValues[0]).getTime());	
		}catch(Exception e){}
	  }
	}else if(toType.equals(java.util.Date.class)){    // �p�G�O  java.util.Date ����
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => java.util.Date ,value = "+Arrays.toString((String[])value));
		
	  String [] parameterValues = (String[])value;    // ��l�r����
	  for(DateFormat format:dateFormat){              // �ϥ�3�ؤ���榡�ƾ��ഫ���
		try{
		  return format.parse(parameterValues[0]);	 
		}catch(Exception e){}
	  }
	}else if(toType.equals(String.class)){            // �p�G�O�r��
	  System.out.println(DateTimeConvertor.class.getName()+",convertValue()...,toType => String ,value = "+value);
		
	  if(value instanceof java.sql.Date){
	  }else if(value instanceof java.sql.Time){  
	  }else if(value instanceof java.util.Date){
	    return dateFormat[0].format((java.util.Date)value); // �N Date �ഫ�� String	  
	  }
	}
	
	 System.out.println(DateTimeConvertor.class.getName()+",convertValue()...");
	 return super.convertValue(context, value, toType); // �_�h�I�s�����O����k
  } // end convertValue
 
 
  
  
  
  /**
   * @param args
   */
  public static void main(String[] args) {

  }

  
  
  
}
