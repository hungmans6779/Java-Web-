package com.webservice.xfire;

/*
 *  HelloWebServiceEnc ����@���O
 */
public class HelloWebServiceEncImpl implements IHelloWebServiceEnc {
	
	
  public String sayHello(String message) {
		
	return "Hello,"+message;
  } // end sayHello
	
}