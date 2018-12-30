package com.webservice.dynamicClient;

import java.net.URL;


import org.codehaus.xfire.client.Client;

import com.webservice.auth.ClientAuthenticationHandler;

/*
 *  �iDynamicClient �覡���Τ�ݡj
 *  
 *  �� �m�@��I�s�n���d��
 *  
 *  ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|����SDK�A
 *  �o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C�Ҧp yahoo ��Web �A�Ȥ��ȴ��ѤF�A�ȡA
 *  �ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 * 
 */
public class HelloWebServiceDynamicClient {


  public static void main(String[] args) {
	try{
		
	  Client client = new Client(new URL("http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebService?wsdl"));
	  
	  Object [] results = client.invoke("sayHello",new Object[] {"kevin.... Demo dynamicClient �I�s�覡�I�I�I"});
	  System.out.println(HelloWebServiceDynamicClient.class.getName());
	  System.out.println((String) results[0]);
	  
	}catch(Exception e){
	  e.printStackTrace();
    }	  
  } // end main

}
