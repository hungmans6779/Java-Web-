package com.helloweenvsfei.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CacheFilter implements Filter {

  private ServletContext servletContext;
  private File temporalDir;
  private long cacheTime=Long.MAX_VALUE;
  
  public void init(FilterConfig config) throws ServletException{
	  
	// Tomcat �u�@��Ƨ�
	temporalDir=(File)config.getServletContext().getAttribute("javax.servlet.context.tempdir");  // C:\Program Files\Apache Group\Apache Tomcat 6.0.32\work\Catalina\localhost\Filter1
	
	servletContext=config.getServletContext();
	cacheTime=new Long(config.getInitParameter("cacheTime"));  // �֨��O���骺�ɶ�
  }
  
  
  
  public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws IOException,ServletException{
	 
	 HttpServletRequest request = (HttpServletRequest)req;
	 HttpServletResponse response = (HttpServletResponse) res;
	 
	 // �p�G��POST �h���g�L�֨��O����
	 if("POST".equals(request.getMethod())){
	   chain.doFilter(request, response);
	   return;
	 }
	 
	 
	 String uri=request.getRequestURI();

	 // �����S��r��
	 uri=uri==null?"":uri;
	 uri=uri.replace(request.getContextPath()+"/","");
	 uri=uri.trim().length()==0?"index.jsp":uri;
	 uri=request.getQueryString()==null?uri:(uri+"?"+request.getQueryString());
	 
	 // �������֨��ɮ�
	 File cacheFile=new File(temporalDir,URLEncoder.encode(uri,"UTF-8"));
	 System.out.println("cacheFile = "+cacheFile);
		
	 // �p�G�֨��ɮפ��s�b �Ϊ̤w�g�W�X�֨��O����ɶ�  �h�ШD Servlet
	 if(!cacheFile.exists() || cacheFile.length()==0 
			                || cacheFile.lastModified() < System.currentTimeMillis() - cacheTime){
		 
		// �ۭqresponse�A�Ω�֨��O�����X���e
		CacheResponseWrapper cacheResponse = new CacheResponseWrapper(response);
		
		chain.doFilter(request,cacheResponse);
		
		// �N�֨��O���骺���e�g�J�֨��ɮ� 
		char [] content =cacheResponse.getCacheWriter().toCharArray();
		
		temporalDir.mkdirs();       // �إ߸�Ƨ�
		cacheFile.createNewFile();  // �إߧ֨��ɮ�
		
		
		// ��X���ɮפ�
		Writer writer=new OutputStreamWriter(new FileOutputStream(cacheFile),"UTF-8");
		writer.write(content);
		writer.close();
	 }
	 
	 
	 // �]�w�ШD��ContentType
	 String mimeType=servletContext.getMimeType(request.getRequestURI());
	 System.out.println("request.getRequestURI() = "+request.getRequestURI());
	 System.out.println("mimeType = "+mimeType);
	 response.setContentType(mimeType);
	
	 
	 // Ū���֨��ɮת����e�A�g�J�Τ���s����
	 Reader ins=new InputStreamReader(new FileInputStream(cacheFile),"UTF-8");
	 StringBuffer buffer =new StringBuffer();
	 char [] cbuf=new char[1024];
	 int len;
	 while((len=ins.read(cbuf))>-1){
	   buffer.append(cbuf,0,len);	 
	 } // end while((len=ins.read(cbuf))>-1){
	 ins.close();
	 
	 
	 // ��X��Τ��
	 response.getWriter().write(buffer.toString());
  }
  
  
  
  public void destroy(){

  }
  
  
  
  
}
