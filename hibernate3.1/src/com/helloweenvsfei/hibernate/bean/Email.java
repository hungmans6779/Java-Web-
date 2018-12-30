package com.helloweenvsfei.hibernate.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *  Email �������O���²��A�ѩ�O�������Y�M�g�AEmail ���S���ϥΪ̹��骺�ѦҡA�u�O�@��²�檺POJO�C
 *  ���`�N�A�P�ϥΪ̪��M�g���Y��ڤW�x�s�b�Ӫ�W�� person_id �C���C 
 */


@Entity                                                  // �������O�]�w
@Table(name = "tb_email")                                // ��������ƪ�
public class Email {                     

	@Id                                                  // �D��
	@GeneratedValue(strategy=GenerationType.AUTO)        // �ۼW������
	private Integer id;

	private String email;                                // �q�l�l��

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	


}
