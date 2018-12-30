package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 *  Person2 ��id �D��Aname �ݩʡB�H�Τ@��List<Email> �������@��h�ݩʡCPerson2 ������x�s�b�� tb_person2�C 
 *  Person2 �������O���ϥ� @OneToMany �]�w�@��h���p�ʡCfetch �]�w���J�覡(������J(FetchType.LAZY)�Ϊ̧Y�ɸ��J(FetchType.EAGER) )�C
 *  
 *  targetEntity ���]�w���X�ݩʤ��������A�ѩ�emails �ݩ������� List<Email>�A�Ϊx�����w�F���X���� Email ����A�]�� targetEntity �i�H�ٲ��C
 *  
 *  cascade �]�w���p���覡�A���ҳ]�w��PERSIST�BREMOVE�BMERGE�BREFRESH�A��ܦb�x�s�B�R���B�ק�B��s Person2 ���O�ɡA�|�۰ʦb��ƪ��x�s�B�R���B�ק�B��s�ݩʥ���Email ����C
 *  �]�w���p���Y��A�i�H�z�L�ާ@ Person ���O�Ӿާ@ Email ���O�C�ӳ]�w�]���P�� CascadeType.ALL�C
 *  
 *  @OrderBy �]�w�ƧǪ��覡�A���ұNEmail ���� email �C�����ƦC�C
 */



@Entity                                           // �ŧi���������O
@Table(name="tb_person2")                         // �ŧi��W
public class Person2 {
 
  @Id                                             // �ŧi�D��
  @GeneratedValue(strategy=GenerationType.AUTO)   // �ŧi�D�䲣�ͳW�h
  private Integer id;
  
  
  private String name;
 
  
  @OneToMany(fetch=FetchType.EAGER,targetEntity=Email.class,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
  // ���d�� TestLazyInitializationException ���թ��ɸ��J�ҥX�{��Exception
  // @OneToMany(fetch=FetchType.LAZY,targetEntity=Email.class,cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH})
  @JoinColumns(value={@JoinColumn(name="person_id",referencedColumnName="id")})
  @OrderBy(value="email desc")
  private List<Email> emails = new ArrayList<Email>();


  public Integer getId() {
	return id;
  }


  public void setId(Integer id) {
	this.id = id;
  }


  public String getName() {
	return name;
  }


  public void setName(String name) {
	this.name = name;
  }


  public List<Email> getEmails() {
	return emails;
  }


  public void setEmails(List<Email> emails) {
	this.emails = emails;
  }



  
  
  
}
