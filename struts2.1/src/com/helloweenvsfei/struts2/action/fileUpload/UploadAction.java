package com.helloweenvsfei.struts2.action.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


/*
 *     Strust1.x�BStruts2.x �����ѹ�W���ɮת��䴩�CStruts1.x ��W�ǫ᪺�ɮ׫ʸˬ� FormFile ����A
   �ݭn��FileInputStream Ū���C��Struts2.x �h������W�ǫ᪺�ɮ׫ʸˬ� java.io.File ����C
   �}�o�̥u�ݦb Action ���w�q�@��File �������ܼơA�M�᪽���ϥθ� File ����A�N���ƻs��ت��ؿ��Y�i�C    
 */
public class UploadAction extends ActionSupport{

  /*
   *     �ݩʡG picture �w�q�GFile �������ݩʡA�Ω󱵨����Ǫ��Ϥ��ɮסCStruts2.x �|�N�Ϥ��x�s����Ȧs�ɮק����A
   * �M�����|�]�w�� picture �ݩʤW�C�b Action �����ѦҧY�i�C
   * 
   * 
   *     �ݩʡGpictureFileName�A  Struts2.x �ɮץu�O�{�ɪ��A�W�ǵ����� Struts2.x �|�N�ɮקR���A�]�� UploadAction ���ݭn�N�ɮ׽ƻs�X�ӡC
   * �ӼȦs�ɮת��W�٤��O�ɮת���W�١A�ӬO Struts2.x �ھڮɶ��W�O�H�����ͪ��A���ɦW��".tmp" �A
   * �ت��O�O�ҫ��s�ɮק������ɮצW���|�����СC
   * �p�G�n��o���ɮת���l�W�١A�ٻݭn�w�q�@�� String �������ݩʡA�ݩʦW������ xxxFileName�A
   * �䤤 xxx �� File �ݩʪ��W��(�Y���Ҥ���picture)�CStruts2.x �|�N���ɮצW�W�]�w����ݩʤW�C�Ҧp�GpictureFileName�C
   * 
   *     �ݩʡGpictureContentType�A�p�G�n��o���ɮת���lMIME �����A�ݭn�w�q�@�� String �������ݩʡA�ݩʦW�����w�q��xxxContentType�A
   * �䤤xxx �]��File �ݩʪ��W��(�Y���Ҫ�picture)�CStruts2.x �|�N����MIME �����]�w����ݩʤW�C�Ҧp�GpictureContentType�C
   *
   *  �ɥR�G xxxFileName�BxxxContentType �ݩʤ��O�������C�p�G���AStruts2.x �|�N������T�]�w�i�h�A�p�G�S���A�N���]�w�C
   */
	
  private File picture;                // �W�Ǫ��ɮסCStruts2.x �|�N�ɮ׫ʸˬ� File ����
  private String pictureFileName;      // �ɮצW�١CStruts2.x �|�N�ɮצW�ٳ]�w����ܼ� 
  private String pictureContentType;   // �ɮ������CStruts2.x �|�N�ɮ������]�w����ܼ�
 
  
  private String uploadFilePath; 
  
  
  // �D��k
  public String execute(){
	System.out.println(UploadAction.class.getName()+",execute()....."); 
	return "input";  
  } // execute()


   
  
  
  // �ɮפW�� 
  public String upload() throws Exception{
	  
	ServletContext application = ServletActionContext.getServletContext();
	String uploadPath = application.getRealPath("upload");
	
	uploadFilePath = uploadPath;
	
	System.out.println(UploadAction.class.getName()+",upload()....."); 
	System.out.println("File       = "+picture);
	System.out.println("FileName   = "+pictureFileName);
	System.out.println("uploadPath = "+uploadPath);
	
	
	
	// �̫�N�ɮ��x�s��/upload �ؿ��U
	File saved = new File(uploadPath,pictureFileName);
	
	InputStream ins = null;
	OutputStream ous = null;
	try{
	  // �T�O��Ƨ� /upload �s�b
	  boolean isMkdir = saved.getParentFile().mkdirs();
	  System.out.println("isMkdir = "+isMkdir);
		
	  ins = new FileInputStream(picture);  // Ū�J�Ȧs�ɮ�
	  ous = new FileOutputStream(saved);   // �g�J��upload �U
	  
	  byte [] b =  new byte[1024];  // �줸�է֨��O����
	  int len = 0 ;
	  while((len = ins.read(b))!=-1){
		ous.write(b,0,len);   // �g�J�ɮ�
	  } // end while((len = ins.read(b))!=-1){
	  
	}catch(Exception e){
	  e.printStackTrace();	
	}finally{
	  if(ous!=null) { ous.close(); ous = null; }
	  if(ins!=null) { ins.close(); ins = null; }
	}
	
	return "list"; 
  } // uplad()
  

  
  
  
  
  
  public File getPicture() {
	return picture;
  }

  public void setPicture(File picture) {
	this.picture = picture;
  }

  public String getPictureContentType() {
	return pictureContentType;
  }

  public void setPictureContentType(String pictureContentType) {
	this.pictureContentType = pictureContentType;
  }

  public String getPictureFileName() {
	return pictureFileName;
  }

  public void setPictureFileName(String pictureFileName) {
	this.pictureFileName = pictureFileName;
  }



  public String getUploadFilePath() {
	return uploadFilePath;
  }


  
  
}
