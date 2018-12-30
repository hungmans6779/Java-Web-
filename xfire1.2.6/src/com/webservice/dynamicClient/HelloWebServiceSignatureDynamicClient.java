package com.webservice.dynamicClient;

import java.net.URL;
import java.util.Properties;

import org.apache.ws.security.handler.WSHandlerConstants;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.security.wss4j.WSS4JOutHandler;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.webservice.signature.PasswordHandler;


/*
 *  �iDynamicClient �覡���Τ�ݡj
 *  
 *  �� �m�Ʀ�ñ��(Signature)�n�i�樭�������Ҫ��d��
 *  
 *  ���A�ȴ��Ѫ̡A�i�H�u���ѪA�ȩM������WSDL�A�O���Ǳ��p�U�A�A�ȴ��Ѫ̷|����SDK�A
 *  �o�˶}�o�̴N�i�H�ϥΪA�ȴ��Ѫ̪��@�����O�C�Ҧp yahoo ��Web �A�Ȥ��ȴ��ѤF�A�ȡA
 *  �ٴ��ѤF�}�o�M�� SDK�A�U���N�ݤ@�U�o�ؤ覡���Τ�ݦp��ϥΡC
 * 
 */
public class HelloWebServiceSignatureDynamicClient {


  public static void main(String[] args) {
	try{		
	  Client client = new Client(new URL(" http://3w.eztravel.com.tw:8080/xfire1.2.6/services/HelloWebServiceSignature?wsdl"));
			  
	  
	  // ***********************************************************************************************
	  //  �m�Ʀ�ñ��(Signature)�n�i�樭��������
	  
      // �t�d�ѪR DOM ��Ƭ�StAX
	  client.addOutHandler(new DOMOutHandler());
	  
	  Properties properties = new Properties();
	  
	  // �]�w�Ʀ�{���������Ʀ���Ҥ覡
	  properties.setProperty(WSHandlerConstants.ACTION,WSHandlerConstants.SIGNATURE);
	  
	  // �W�[�ϥΪ̦W��
	  properties.setProperty(WSHandlerConstants.USER,"admin");
	  
	  // �ھڨϥΪ̦W�٬d�ߥX�������K�X
	  properties.setProperty(WSHandlerConstants.PW_CALLBACK_CLASS,PasswordHandler.class.getName());

	  
	  properties.setProperty(WSHandlerConstants.SIG_PROP_FILE,"META-INF/xfire/outsecurity.properties");
	  
	  
	  properties.setProperty(WSHandlerConstants.SIG_KEY_ID,"IssuerSerial"); 
	  
	  
	  client.addOutHandler(new WSS4JOutHandler(properties));
	  // ***********************************************************************************************
	  
	  
 
	  
	  
	  Object [] results = client.invoke("sayHello",new Object[] {"kevin.... Demo dynamicClient �I�s�覡�I�I�I"});
	  System.out.println(HelloWebServiceSignatureDynamicClient.class.getName());
	  System.out.println((String) results[0]);
			  
	}catch(Exception e){
	  e.printStackTrace();
	}	  
  }

}
