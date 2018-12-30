package com.helloweenvsfei.itext;

import java.awt.Color;
import java.io.FileOutputStream;


import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class FirstPDF {
  
	
  public static void main(String [] args){
	
	  Document document=new Document(PageSize.A4);
	  try{
		  
		// ��X��󪫥�,A4�Ȥj�p  
	    PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\iText\\generateDoc\\FirstPDF.pdf"));	
	    
		document.addAuthor("kevin");                 // �]�w���@��
		document.addTitle("This is itext PDF file"); // �]�w�����D
		document.addSubject("First pdf");            // �]�w�D�D
		document.addKeywords("iText");               // �]�w����r
		
	   
	    document.open();  // �}�Ҥ��
	    
	    document.add(new Paragraph("Hello World,Hello iText")); // �b pdf �ɮפ��g�J��r
	    
	    
		// �]�w�r�骺��r
		document.add(new Paragraph("Hello World, Hello iText",FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLDITALIC)));
		
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
		Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
		// �]�w������
		Paragraph pragraph=new Paragraph("�A�n,�o�O����", FontChinese);  
		document.add(pragraph);
		

		//�إ߹Ϥ���H�A�ѼƬ��Ϥ����ɮצW
		Image bmp = Image.getInstance("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\iText\\WebRoot\\mudan.jpg");
		bmp.scalePercent(25f);
	   
	    document.close();  // �������
	    
	  }catch(Exception e){
		e.printStackTrace();  
	  }
	  
  }
  
  
}
