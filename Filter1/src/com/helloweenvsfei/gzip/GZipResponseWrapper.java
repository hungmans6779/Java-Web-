package com.helloweenvsfei.gzip;

import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipResponseWrapper extends HttpServletResponseWrapper {
 
  // �w�]��response	
  private HttpServletResponse response;
  
  // �ۭq��outputStream,����close()���ɭԹ������Y�A�ÿ�X
  private GZipOutputStream gzipOutputStream;
  
  // �ۭq printWriter,�N���e��X�� GZipOutputStream �� 
  private PrintWriter writer;
  
  
  public GZipResponseWrapper(HttpServletResponse response) throws IOException{
	super(response);
	this.response=response;
  }
  
  
  
  // �л\getOutputStream()��k,�B�z�G�i�줺�e
  public ServletOutputStream getOutputStream() throws IOException{
	if(gzipOutputStream ==null){
	  gzipOutputStream=new GZipOutputStream(response);	
	}
	return gzipOutputStream;
  }
  
  
  
  // �л\ getWriter() ��k�A�B�z�r�����e
  public PrintWriter getWriter() throws IOException{
	if(writer==null){
	  writer=new PrintWriter(new OutputStreamWriter(new GZipOutputStream(response),"UTF-8"));	
	}
	return writer;  
  }
  
  
  // ���Y���ƪ��׷|�o���ܤơA�]���N�Ӥ�k���e�M��
  public void setContentLength(int contentLength){
  }
  
  
  public void flushBuffer() throws IOException{
    gzipOutputStream.flush();
  }
  
  // ����Ӥ�k�N���ƶi��GZIP���Y�A�ÿ�X���s�����C
  public void finishResponse() throws IOException{

    if(gzipOutputStream!=null){	
      gzipOutputStream.close();
    }
    
    if(writer!=null){
	  writer.close();
    }
    
  }
  
  
  
  
}
