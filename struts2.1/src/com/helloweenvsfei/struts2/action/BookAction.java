package com.helloweenvsfei.struts2.action;

import java.util.List;
import java.util.ArrayList;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.helloweenvsfei.struts2.action.bean.Book;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.DateRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;




public class BookAction extends ActionSupport {

	public static List <Book> bookList = new ArrayList<Book>();  // static �� List�A������Ʈw
	private String title;                                        // JSP �������D
	private Book book;                                           // Book ����(�����n�b�o new �X�@�Ӫ���A�p�G�S������A�|�b����ɳz�L�Ϯg���͹���@�Ӫ���A)
             
	// �]�����|�ߥX NullPointerException
	
	
	
	// ��ܼW�[���y����
	@SkipValidation
	public String initAdd(){
	  System.out.println(BookAction.class.getName()+",initAdd()....");
	 
	  return "initAdd";	  // �Ǧ^�W�[����
	} // end initAdd
	

	
	
	

	public String add(){
	  System.out.println("*********************************");
	  System.out.println(BookAction.class.getName()+",add()...");
	  System.out.println("01.Name          = "+book.getName());
	  System.out.println("02.Author        = "+book.getAuthor());
	  System.out.println("03.publishedDate = "+book.getPublishedDate());
	  System.out.println("*********************************");
	  
	  bookList.add(book);  // ��� List ��
	  System.out.println("add() bookList size = "+bookList.size());
	  title="<br><br>�W�[���y���\<br><br>";   // �]�w���D
	  
	  return "success";    // �Ǧ^���\����
	} // end add
	
	
	
	
	
	
	// ���y�C��
	@SkipValidation
	public String list(){
	  System.out.println(BookAction.class.getName()+",list()... bookList.size = "+bookList.size()); 
 
	  return "list";       // �Ǧ^�M�歶��	
	} // end list
	
	
	
	
	
	
	
	// �M�Ů��y�C��
	@SkipValidation
	public String clear(){
	  System.out.println(BookAction.class.getName()+",clear()... bookList.size = "+bookList.size()); 
		  
	  bookList.clear(); // �M�ũҦ���Book 
	  title="<br><br>�M�Ů��y�C���\<br><br>";    // �]�w���D
	  
	  return "list";        // �Ǧ^�M�歶��
	}  // end clear
	
	
	
	
	
	
	

	public List<Book> getBookList() {
	  return bookList;  
	}

	public String getTitle() {
	  return title;
	}

	public void setTitle(String title) {
	  this.title = title;
	}

	public Book getBook() {
	  return book;
	}

	public void setBook(Book book) {
	  this.book = book;
	}

}
