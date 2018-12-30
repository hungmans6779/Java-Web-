package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




/*
 *  �����������O
 *  �h�� Employee ���u�ݩ�Y�� Department �����A�@�� Department �����]�i�H���h�� Employee ���u�C
 *  Employee �P Department �����O�h��@�����Y�C�t�~�ADepartment �����������O���@�� lineManager �ݩʡA
 *  ��ܸӳ������g�z�A���ݩʻP Employee �O�@��@���C 
 */


@Entity
@Table(name="tb_department")
public class Department {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;                                           // �D��
  
  private String name;                                          // �����W��
  
  private String description;                                   // �����y�z
  
  @OneToOne                                               
  @JoinColumn(name="line_manager_id")                           // ���p���~��C
  private Employee lineManager;                                 // �g�z�ݩ�
  
  @OneToMany(mappedBy="department")                             // ���� Employee �� department �ݩ�
  private Set<Employee> employees = new HashSet<Employee>();    // �������u���X���O

  
  
  
  
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

  public String getDescription() {
	return description; 
  }

  public void setDescription(String description) {
	this.description = description;
  }

  public Employee getLineManager() {
	return lineManager;
  }

  public void setLineManager(Employee lineManager) {
	this.lineManager = lineManager;
  }

  public Set<Employee> getEmployees() {
	return employees;
  }

  public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
  }
	
 
  
}
