package com.hibernate.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity                // @Entity ��ܸ����O��Q Hibernate ���[��
@Table(name="tb_cat")  // ���w�� Entity ��������ƪ�W
public class Cat1 {

	
  @Id // ���w�ӦC���D��C�D�������̦n���n�ϥ� int ����l����(�D�侨�q�ϥΥi�H�� null ���A�����O�B�ҦpInteger�BLong�BString ��)
  @GeneratedValue(strategy=GenerationType.AUTO) // �D������ auto ����Ʈw�ۼW������
  private Integer id;
  
  @Column(name="name")  // ���w�ݩʹ�������Ʈw���C��"name"
  private String name;
  
  @Column(name="description")  // @Column �P name ���i�ٲ�
  private String description;
  
  
  @Temporal(TemporalType.TIMESTAMP)  // ������O(DATE,TIME �٬O TIMESTEMP)
  private Date createDate;


  /**
   * @return the id
   */
  public Integer getId() {
	return id;
  }


  /**
   * @param id the id to set
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
   * @param name the name to set
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
   * @param description the description to set
   */
  public void setDescription(String description) {
	this.description = description;
  }


  /**
   * @return the createDate
   */
  public Date getCreateDate() {
	return createDate;
  }


  /**
   * @param createDate the createDate to set
   */
  public void setCreateDate(Date createDate) {
	this.createDate = createDate;
  }
  
  
  
}
