package com.helloweenvsfei.logging;

import java.util.logging.ConsoleHandler;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDKLogTest {
  
  public static Logger log = Logger.getLogger(JDKLogTest.class.toString());
  
  static{
    Handler console=new ConsoleHandler(); // �W�[�@�ӱ���x����X
    console.setLevel(Level.FINE);         // �]�w��FINE�ŧO
    log.addHandler(console);              // �W�[��log ��
  }
  
  
  public static void main(String [] args){
	log.setLevel(Level.FINE);
	
	log.finest("first");
	log.finer("finer");
	log.fine("fine");
	log.config("config");
	log.info("info");
	log.warning("warning");
	log.severe("severe");
  }
  
  
}
