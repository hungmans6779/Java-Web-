package com.helloweenvsfei.hibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/*
 *  Student ���O�����@��id �D��A�H�� name �m�W�Bsex �ʧO����Ӵ��q�ݩʡA�٦��@�� Clazz ���O���ݩ�clazz �A�N��Ҧb���Z�šC
 *  ���ݩʻP Clazz ����List<Student>���X�ݩʬO�������C�q�޿�W���A�Ystudent �� clazz �ݩʬ��Yclazz �A�h��clazz �� List<Student>�����w�t����student�C
 *  �]�w�FmappedBy ��AHibernate ��۰ʺ��@�o�����Y�C
 *  
 *  Student �P Clazz �O�@��h�����Y�A�@�Ӧh�ϥ�@ManyToOne �]�w�A�t�~��@JoinColumn �]�w���p���C�W�C
 *  �o�̥� tb_student ��class_id �C�P tb_class �� id �D��C�s���C�o�̦P�ɳ]�w�F���p�x�s������PERSIST�A
 *  �إ�student �ɡA�|�۰ʱNclazz �]�g�i��Ʈw�C
 *   
 */

@Entity                                               // Entity
@Table(name = "tb_student")                           // Table
public class Student {

	@Id                                               // ID
	@GeneratedValue(strategy = GenerationType.AUTO)   // GeneratedValue �]�w
	private Integer id;

	
	// �Z���ݩ�
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "class_id")  // �~�䪺�ݩʡC(�o�̧ⱱ���v�浹�F�h��A�]�i�H�浹�@��C��@�豱��ɡA�@�誺�]�w�P���䪺�@��h���p�ʳ]�w�����ۦP�C)
	private Clazz clazz;
	
	
	// �m�W
	private String name;

	
	// �ʧO
	private String sex;

	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
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
	
	

}
