package com.helloweenvsfei.hibernate.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 *  Sailor �������O�]�A3���ݩʡGid �D��Bname �m�W�Bship �Ҧb����Cname �m�W�ݩʬO���q�� String �����ݩʡA
 *  �]�w�ϥιw�]�]�w�Cship �O�Ӧh��@���ݩʡB�� @ManyToOne �]�w�A��@JoinColumn �{�w�~��(�]�N�O��Ӫ��������p��)�C
 */


// �������O
@Entity
@Table(name="tb_sailor")
public class Sailor {

  @Id                                                // �D��]�w
  @GeneratedValue(strategy=GenerationType.AUTO)      // �D�䲣�͵����]�w
  private Integer id;  
  
  
  private String name;                                // ����m�W(name �ϥιw�]�]�w)
  
  
  @ManyToOne(cascade=CascadeType.PERSIST)           
  @JoinColumn(name="ship_id")                          // �~�䬰 ship_id
  private Ship ship;                                   // �����ĥ��O�h��@
  
  
  @OneToOne(mappedBy="captain")    
  private Ship captainedShip;                          // �����ĥ��O�@��@

  
  
  

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

  public Ship getShip() {
	return ship;
  }

  public void setShip(Ship ship) {
	this.ship = ship;
  }

  public Ship getCaptainedShip() {
	return captainedShip;
  }

  public void setCaptainedShip(Ship captainedShip) {
	this.captainedShip = captainedShip;
  }
  
   
  
  
}
