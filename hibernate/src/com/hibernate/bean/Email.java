package com.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                   // �������O�]�w
@Table(name="tb_email")   // ��������ƪ�
public class Email {      // Email ���O

  @Id                                            // �D��
  @GeneratedValue(strategy=GenerationType.AUTO)  // �ۼW������
  private Integer id;
 
  private String email;                          // �q�l�l��

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
   * @return the email
   */
  public String getEmail() {
	return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
	this.email = email;
  }
  
  
}
