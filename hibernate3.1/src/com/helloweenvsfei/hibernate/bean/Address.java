package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/*
 *     Address ��}�������O�㦳id �D��BCustomer �Ȥ��ݩʥH��address ��}�Bzip �l���ϸ��Btelephone �q�ܸ��X��3�Ӵ��q�ݩʡC
 *  id �D��� @Id �аO�C�]�����鶡�ϥάۦP��id �A�]������ϥΥ��󪺥D�䲣�͵����CCustomer �ݩʤW��@OneToOne ���w���@��@�ݩʡA
 *  �å� @PrimaryKeyJoinColumn �ŧi�ϥάۦP�D��C 
 */

@Entity
@Table(name = "tb_address")
public class Address {

	@Id                                                 // �D��
	// @GeneratedValue(strategy = GenerationType.AUTO)  // ����ϥθ�Ʈw�۰ʤ��t id
	private Integer id;

	@OneToOne                                           // �@��@���p��
	@PrimaryKeyJoinColumn                               // �@��@���骺�D��ۦP 
	private Customer customer;

	// ��}�A�ϥιw�]�]�w
	private String address;

	// �l���ϸ��A�ϥιw�]�]�w
	private String zip;

	// �q�ܸ��X�A�ϥιw�]�]�w
	private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
