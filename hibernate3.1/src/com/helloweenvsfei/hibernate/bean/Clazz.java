package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
/*
 *  Clazz ���O�����@�� id �D��A�@�� name �ݩʡB�t�~�٦��@��List<Student> ���O�����X�ݩʡA�N��Z�Ť����ǥ͡C
 *  �Z�ŻP�ǥͪ����Y�O�@��h���A�o�̨ϥ� @OneToMany �]�w�A�å� mappedBy �ݩʳ]�w�P�� List<Student>�ݩʹ������O Student ���O���� clazz �ݩʡC
 *  ��ڤW�����p�]�w���b Student �� clazz �ݩʤW�C 
 */


@Entity                     // Entity �]�w
@Table(name = "tb_class")   // Table �]�w
public class Clazz {

	
	// id �]�w
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	// �Z�ŦW�A�ϥιw�]�]�w
	private String name;

	
	// �Ҧ��ǥ�
	// �Z�ŻP�ǥͪ����Y�O�@��@
	@OneToMany(mappedBy = "clazz")  // OneToMany,�ϥΤϦV�]�w
	@Cascade(value = CascadeType.DELETE_ORPHAN)
	private List<Student> students = new ArrayList<Student>();
    
	
	/*
	@OneToMany(mappedBy="clazz")
	@MapKey(name="name")
	private Map<String,Student> students = new HashMap<String,Student>();
	*/
	
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	
}
