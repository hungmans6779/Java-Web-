package com.webservice.sdk;

import java.net.MalformedURLException;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;

import com.webservice.auth.ClientAuthenticationHandler;
import com.webservice.xfire.IHelloWebServiceAuth;


/*
 *  �iSDK �覡���Τ�ݡj
 *  
 *   ���mWeb �A�Ȧw���nSOAP Header ���i�樭�����Ҫ��d��
 *   
 *  ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|����SDK�A
 *  �o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C�Ҧp yahoo ��Web �A�Ȥ��ȴ��ѤF�A�ȡA
 *  �ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 * 
 */
public class HelloWebServiceAuthClient {


  private static IHelloWebServiceAuth service;   // Service ����
	 
	  
  // �p���غc�l
  private HelloWebServiceAuthClient(){}
	  
	  
  
	  
	  
  // �z�L WSDL ���o IHelloWebServiceAuth �����A�H�ϥά۹�������k
  public static IHelloWebServiceAuth getService(String serviceURL) throws MalformedURLException {
		  	  
	if(service == null){
	    	
	  // �إ�IHelloWebService���A��
      Service srvcModel = new ObjectServiceFactory().create(IHelloWebServiceAuth.class);
			
	  // �إ�XFire�ﹳ
	  XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());
			
	  // �I�sWeb�A��
	  service = (IHelloWebServiceAuth) factory.create(srvcModel,serviceURL);

	  
	  // �]�w�Ȥ�ݩI�s���ݩ�
	  Client client = Client.getInstance(service);
		  
	  // ���U soap �T�����W�[������T
	  client.addOutHandler(new ClientAuthenticationHandler("admin","1234"));
		  
       
	  client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT,"300");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_KEEP_ALIVE,"true");
	  client.setProperty(CommonsHttpMessageSender.DISABLE_EXPECT_CONTINUE,"true");
			
	  // �p�G�ݭn�]�w�N�z
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_HOST,"10.10.1.71");
	  client.setProperty(CommonsHttpMessageSender.HTTP_PROXY_PORT,"8080");
			
	} // end if(service == null){
		  
	return service;
  } // end getService
	  
	  
  
  
  
	  
	  
	  
	  
  public static void main(String[] args) {

	try{
			
	  // �I�s�Τ��
	  IHelloWebServiceAuth service = HelloWebServiceAuthClient.getService("http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceAuth");
	  
	  
	  System.out.println("***************************************************");
	  System.out.println(HelloWebServiceAuthClient.class.getName());
	  String result = service.sayHello("kevin,Demo SDK �I�s�覡�I�I�I");  
	  System.out.println("result = "+result);
	  System.out.println("***************************************************");
	  
	}catch(MalformedURLException e){
	  e.printStackTrace(); 	
	}
		  
  } // end main

  
}


