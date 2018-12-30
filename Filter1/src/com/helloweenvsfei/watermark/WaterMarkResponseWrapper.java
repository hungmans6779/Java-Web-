package com.helloweenvsfei.watermark;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class WaterMarkResponseWrapper extends HttpServletResponseWrapper{

	private String waterMarkFile;
	private HttpServletResponse response;
	
	
	// �ۭq servletOutputStream ,�Ω�w�ĹϹ����
	private WaterMarkOutputStream waterMarkOutputStream = new WaterMarkOutputStream();
	
	public WaterMarkResponseWrapper(HttpServletResponse response,String waterMarkFile) throws IOException{
	  super(response);
	  this.response=response;
	  this.waterMarkFile=waterMarkFile;
	}
	
	
	// �л\ getOutputStream(),�Ǧ^�ۭq��waterMarkOutputStream
	public ServletOutputStream getOutputStream() throws IOException{
		return waterMarkOutputStream;
	}
	
	
	public void flushBuffer() throws IOException{
		waterMarkOutputStream.flush();	
	}
	
	
	//  �N�Ϲ���ƼW�[�B���L�A�ÿ�X��Τ���s����
	public void finishResponse() throws IOException{
	  
	  // ��Ϥ����
	  byte [] imageData = waterMarkOutputStream.getByteArrayOutputStream().toByteArray();
	  
	  // �W�[�B���L�᪺�Ϥ����
	  byte [] image =ImageUtil.waterMark(imageData, waterMarkFile);
	  
	  // �]�w��X���e����ڪ���
	  response.setContentLength(image.length);
	  
	  // �N�v����X���s����
	  response.getOutputStream().write(image);
	  
	  // ����waterMarkOutputStream �y
	  waterMarkOutputStream.close();
	  
	}
	
	
	
}
