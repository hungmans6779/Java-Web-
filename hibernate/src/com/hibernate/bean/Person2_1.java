package com.hibernate.bean;

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


@Entity
// �ŧi���������O
@Table(name = "tb_person2")
// �ŧi��ƪ�W
public class Person2_1 {

	@Id                                               // �ŧi�D��
	@GeneratedValue(strategy = GenerationType.AUTO)   // �ŧi�D�䲣�ͳW�h
	private Integer id;

	
	
	private String name; // name �ݩʨϥιw�]�]�w

	
	// �@��h���]�w�A�ó]�w�æC���Y
	// fetch = FetchType.EAGER ������J
	// fetch = FetchType.LAZY ������J
	@OneToMany(fetch = FetchType.LAZY,targetEntity = Email.class,			
			   cascade = {
			               CascadeType.PERSIST, 
			               CascadeType.REMOVE, 
		   	               CascadeType.MERGE,
			               CascadeType.REFRESH 
			             }
               )			
	@JoinColumns(value = { @JoinColumn(name = "person_id",referencedColumnName = "id") })
	@OrderBy(value = "email desc")  // �]�w�ƧǤ覡
	private List<Email> emails = new ArrayList<Email>();

	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the emails
	 */
	public List<Email> getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

}