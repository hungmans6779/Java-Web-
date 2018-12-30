package com.helloweenvsfei.itext;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFServlet extends HttpServlet {

	private static final long serialVersionUID = -1770041214313726383L;

	public PDFServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	              throws ServletException, IOException {

		// �إߤ���H�AA4�Ȥj�p
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try{
		  PdfWriter writer = PdfWriter.getInstance(document,stream);
		  document.open();  // �}�Ҥ��
		  document.add(new Paragraph("Hello Kevin, Hello iText")); // �b pdf �ɮפ��g�J��r			
		  document.close(); // �������
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		response.setContentType("application/pdf");            // �]�w�T�����������pdf
		response.setContentLength(stream.size());              // �]�w�T����Ƥj�p		
		ServletOutputStream out = response.getOutputStream();  // ��o�T����Ƭy
		stream.writeTo(out);                                   // �Npdf��Ƭy�g�J���T����Ƭy��
		
		out.flush();
		if(out!=null){ out.close(); out=null;  }
		
	} // end doPost

	
}
