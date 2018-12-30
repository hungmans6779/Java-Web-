package com.helloweenvsfei.hibernate.bean;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * �`�N�Gbirthday �ݩʬO java.sql.Date �������A�w�g�ܩ��T�u���~ �� �� ��T�A�]�����ݭn�A�� @Temporal(TemporalType.DATE) �S�O�ŧi�C
 * �P�z�AstartTime�BendTime �]���ݭn�S�O�ŧi�C���O dateCreated �ݩʬO java.util.Date �����A�ݭn�ϥ� @Temporal(TemploralType.TIMESTAMP) �ŧi�C 
 */

@Entity
@Table(name="tb_employee")
public class Employee {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)                 // �D�䵦���A�۰ʲ���
  private Integer id;                                           // �D��
  
  private String name;                                          // �m�W
  
  private String sex;                                           // �ʧO
  
  private Integer age;                                          // �~��
  
  private Date birthday;                                        // �ͤ�A java.sql.Date ����
  
  private Time startTime;                                       // �W�Z�ɶ��ATime ����
  
  private Time endTime;                                         // �U�Z�ɶ��ATime ����
  
  private double salary;                                        // �~���Adouble ����
  
  @Basic(fetch=FetchType.LAZY)                                  // �Ƶ��A�j��쩵����J
  @Column(columnDefinition="longtext")                          // ��Ʈw�ϥ� LONGTEXT ����
  private String description;                                   // �Ƶ�
  
  @Temporal(TemporalType.TIMESTAMP)                             // �ɶ��W�O����
  private java.util.Date dateCreated;                           // �إ߮ɶ��Ajava.util.Date ����
  
  private boolean disabled;                                     // �O�_�Q����Aboolean ����

  
  @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
  @JoinColumn(name="department_id")                             // ���p�~��C
  private Department department;                                // �����ݩ�
  
  
  
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

  public String getSex() {
	return sex;
  }

  public void setSex(String sex) {
	this.sex = sex;
  }

  public Integer getAge() {
	return age;
  }

  public void setAge(Integer age) {
	this.age = age;
  }

  public Date getBirthday() {
	return birthday;
  }

  public void setBirthday(Date birthday) {
	this.birthday = birthday;
  }

  public Time getStartTime() {
	return startTime;
  }

  public void setStartTime(Time startTime) {
	this.startTime = startTime;
  }

  public Time getEndTime() {
	return endTime;
  }

  public void setEndTime(Time endTime) {
	this.endTime = endTime;
  }

  public double getSalary() {
	return salary;
  }

  public void setSalary(double salary) {
	this.salary = salary;
  }

  public String getDescription() {
	return description;
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public java.util.Date getDateCreated() {
	return dateCreated;
  }

  public void setDateCreated(java.util.Date dateCreated) {
	this.dateCreated = dateCreated;
  }

  public boolean isDisabled() {
	return disabled;
  }

  public void setDisabled(boolean disabled) {
	this.disabled = disabled;
  }

  public Department getDepartment() {
	return department;
  }

  public void setDepartment(Department department) {
	this.department = department;
  }
  

  
}
