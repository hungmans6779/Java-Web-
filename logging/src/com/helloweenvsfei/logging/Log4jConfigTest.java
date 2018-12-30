package com.helloweenvsfei.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


public class Log4jConfigTest {
  
  public static Logger log=Logger.getLogger(Log4jConfigTest.class);	
	
  public static void main(String [] args){

	log.trace("trace ��T");
	
	if(log.isEnabledFor(Priority.DEBUG))  
	  log.debug("debug ��T");
	
	if(log.isEnabledFor(Priority.INFO))
	  log.info("info ��T");
	
	if(log.isEnabledFor(Priority.WARN))
	  log.warn("warn ��T");
	
	if(log.isEnabledFor(Priority.ERROR))
	  log.error("error ��T");
	
	if(log.isEnabledFor(Priority.FATAL))
	  log.fatal("fatal ��T");
	
	try{
	  String s=null;
	  s.length();
	}catch(Exception e){
		
	  if(log.isTraceEnabled())
	    log.trace("trace �@�Өҥ~",e);
	  
	  if(log.isDebugEnabled())
	    log.debug("debug �@�Өҥ~",e);
	  
	  if(log.isInfoEnabled())
	    log.info("info �@�Өҥ~",e);
	  
	  log.warn("warn �@�Өҥ~",e);  
	  log.error("error �@�Өҥ~",e);
	  log.fatal("fatal �@�Өҥ~",e);
	}
	
  }
  
  
  
}
