package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/*
 *      Customer �Ȥ�������O�����@��id �D��B�@��name �m�W�ݩ� �H�Τ@��Adress ��}�ݩʡC�䤤 Adress �ݩʦ�}�PCustomer �Ȥ�������O�����O�@��@���ݩʡA
 *  ��̤����ϥάۦP���D��A�ӨS���ϥζǲΥ~������C��@OneToOne ���w  adress �ݩʬ��@��@���A��@PrimaryKeyJoinColumn ���w��ӹ���ϥάۦP���D��C
 */

@Entity
@Table(name="tb_customer")
public class Customer {

  @Id                                            // id �]�w
  @GeneratedValue(strategy=GenerationType.AUTO)  // �D�䲣�ͳW�h�]�w
  private Integer id;                                   
  
  
  private String name;                            // name �ϥιw�]�]�w
  
  
  @OneToOne                                       // �ŧi�@��@���p��
  @PrimaryKeyJoinColumn                           // �@��@���骺�D��ۦP
  private Address address;                        // ��}�ݩ�


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


  public Address getAddress() {
	return address;
  }


  public void setAddress(Address address) {
	this.address = address;
  }
  
  
  
  
  
  
}
