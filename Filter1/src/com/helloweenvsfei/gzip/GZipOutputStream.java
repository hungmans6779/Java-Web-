package com.helloweenvsfei.gzip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class GZipOutputStream extends ServletOutputStream{
  
	// ��response 
	private HttpServletResponse response;
	
	// �N���Y�᪺��Ʀs��� ByteArrayOutputStream
	private ByteArrayOutputStream byteArrayOutputStream;
	
	// JDK ���a��GZIP���Y��ƪ����O
	private GZIPOutputStream gzipOutputStream;
	
	public GZipOutputStream(HttpServletResponse response) throws IOException{
      this.response=response;
      byteArrayOutputStream =new ByteArrayOutputStream();
      gzipOutputStream=new GZIPOutputStream(byteArrayOutputStream);
	}
	

	// ��X��JDK��GZIP��X���O��
	public void write(int b) throws IOException{
	  gzipOutputStream.write(b);
	}
	
	

	
	
	// �������Y�A�ñN��ƿ�X���s����
	public void close() throws IOException{
	  
      // �������Y�@�w�n�I�s�Ӥ�k
	  gzipOutputStream.finish();
	  
	  // �N���Y�᪺��ƿ�X��Τ��
	  byte [] content =byteArrayOutputStream.toByteArray();

	  // �]�w���Y�覡��GZIP,�Τ���s�����|�۰ʱN������Y
	  response.addHeader("Content-Encoding","gzip");
	  response.addHeader("Content-Length",Integer.toString(content.length));
	  
	  // ��X���s����
	  ServletOutputStream out=response.getOutputStream();
	  out.write(content);
	  out.close();
	}
	
	
	public void flush() throws IOException{
	  gzipOutputStream.flush();
    }
		
	
	public void write(byte [] b,int off,int len)throws IOException{
	  gzipOutputStream.write(b,off,len);
	}
		
	public void write(byte [] b) throws IOException{
	  gzipOutputStream.write(b);	
	}
		
		


}

