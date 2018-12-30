package com.hibernate.bean;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
// @Entity ��ܸ����O��Q Hibernate ���[��
@Table(name = "tb_cat")
// ���w�� Entity ��������ƪ�W
public class Cat {

	
	@Id
	// ���w�ӦC���D��
	@GeneratedValue(strategy = GenerationType.AUTO)
	// �D�������Aauto ���۰ʼW������
	private Integer id;

	
	
	@Column(name = "name")
	// ���w�ݩʹ�������Ʈw���C�� name
	private String name;

	
	
	
	@Column(name = "description")
	// ���w�ݩʹ�������Ʈw���C�� description
	private String description;

	
	
	@ManyToOne
	// ���w�������O���������Y�A���Ҭ��h��@���Y
	@JoinColumn(name = "mother_id")
	// ���ݩʹ������C
	private Cat mother;

	
	
	@Temporal(TemporalType.TIMESTAMP)
	// �������(DATE�ATIME �٬OTIMESTEMP)
	@Column(name = "createDate")
	private Date createDate;

	
	
	
	
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the mother
	 */
	public Cat getMother() {
		return mother;
	}

	/**
	 * @param mother
	 *            the mother to set
	 */
	public void setMother(Cat mother) {
		this.mother = mother;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
