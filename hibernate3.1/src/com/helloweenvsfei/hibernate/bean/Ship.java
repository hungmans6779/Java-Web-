package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 *  Ship ĥ��������O���]�t4���ݩʡGid�D��Bname ��W�Bcaptain ����Bsailors ����C
 *  �䤤 caption ����O�@��@�����Y�A�@�Ӳ���u��@����(ship)�A�@����]�u���@�Ӳ��(caption)�C
 *  �@��@�ݩʥ� @OneToOne �]�w �A�����~��C��@JoinColumn �]�w�C�`�N unique �ݩʭn�]�w�� true�A
 *  �Q�θ�Ʈw��unique �����O�Ҥ@�Ӳ�����|�Q�⿴��ϥΡCsailors �O�Ӥ@��h�ݩʡA
 *  �ϥ�@OneToMany �]�w�A�� mappedBy="ship" ���w��ڳ]�w�b���������O(�]�N�OSailor)��ship �ݩʤ��C
 */

// ĥ�����O
@Entity
@Table(name="tb_ship")
public class Ship {

	
  @Id                                                            // �D��]�w
  @GeneratedValue(strategy=GenerationType.AUTO)                  // �D�䲣�͵����]�w
  private Integer id;                            
  
  private String name;                                           // ĥ��W��
  
  @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REFRESH}) 
  @JoinColumn(name="captain_id",unique=true)                     // �~�䬰 captain_id(�Q�θ�Ʈwunique �����O�Ҳ���O�ߤ@��) 
  private Sailor captain;                                        // ���
  
  @OneToMany(mappedBy="ship",cascade=CascadeType.PERSIST)        // �ϥΤϦV�]�w
  private Set<Sailor> sailors = new HashSet();                   // ���(�Ҧ�������)

  
  
  
  
  
  
  
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

  public Sailor getCaptain() {
	return captain;
  }

  public void setCaptain(Sailor captain) {
	this.captain = captain;
  }

  public Set<Sailor> getSailors() {
	return sailors;
  }

  public void setSailors(Set<Sailor> sailors) {
	this.sailors = sailors;
  }
  
  
  
  
  
  
  
}
