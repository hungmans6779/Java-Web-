package com.helloweenvsfei.hibernate.bean;

import java.util.ArrayList;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * �������O(Entity)�O���P��Ʈw���M�g���Y��Java ���O�A�@����˨ϥ�POJO�C�Ҧp�����O�O���q��JavaBean ���O�A
 * �Ҧ��ݩʳ��O������getter�Bsetter ��k�C���O�ϥ� @Entity �]�w��ACat ���O�N�Q�ŧi���F�@�ӹ������O�C
 * �������O�ٻݭn�]�w��������W(��@Table �]�w)�B�D��(��@Id�]�w)�B���q�ݩ�(��@Column �]�w)�������C�W���C�{���X�p�U�G
 */


/*
 * �Ҧ��� @�������O javax.persistence.* �U���A�Ӥ��O org.hibernate.* �U�Cjavax.persistence.* �U��������  JPA �W�d�W�w�������A
 * �Ω�аO�������O�P��Ʈw���M�g���Y�A�� org.hibernate.* �U�������ȥΩ�ɥR�A��Y�ӥ\�� JPA �Ȯɤ��䴩�� Hibernate �䴩�ɨϥΡC
 */


// �ϥ� @�����]�w�������O�ɡA�n�ϥ�@�����]�w�R�W�d�ߡA�Ψ쪺Java ������ @NamedQuery �P @NamedNativeQuery �C
// �䤤�A@NamedQuery �Ω�]�w�R�W��HQL�d�ߡC@NamedNativeQuery �Ω�]�w�R�W�����h��ƮwSQL �d�ߡC
// @NamedQuery(name="all cat",query="select c from tb_cat" )               // �R�W�d��
// @NamedNativeQuery(name="all cat",query="select * from tb_cat ")

// �]�w�d���X�R
// �R�W�d�ߤ��A���\�ϥ� @QueryHint ��R�W�d�߳]�wJPA �X�R�CJPA �W�d���\JPA ������(�Ҧp�GHibernate�BTopLink�BOpenJPA �� ORMFramework)
// �� JPA �i��@�ǥ\��W���X�R�A�H�[�t�d�ߩʯ�B���Ѩ�L�\��C�Ҧp�G
// @NamedQuery(name="cat by name",query="select c from Cat c where c.name = :name",hints={@QueryHint(name="org.hibernate.callable",value="true")})


// �]�w�h�өR�W�d��
// �@�ӹ������O����]�w�h��@NamedQuery�C�p�G���h�өR�W�d�ߡA�ݭn�ϥ� @NamedQuerties �]�w�C@NamedQuerties ���i�H�]�w�h��@NameQuery �A�Ҧp�G
/*
@NamedQueries(value={ 
  @NamedQuery(name="all cat",query="select c from Cat c"),
  @NamedQuery(name="cat by name",query="select c from Cat c where c.name = :name"),
  @NamedQuery(name="cat by mother",query="select c from Cat c where c.mother.name =:name")
})
*/

@Entity                                          // ���� Entiry ��ܸ����O��Q Hibernate ���[��
@Table(name="tb_cat")                            // ���w�� Entity ��������ƪ�W
public class Cat {

  public Cat(){}
  
  public Cat(String name,String description,Date createDate,Cat mother){
    this.name=name;
    this.description=description;
    this.createDate=createDate;
    this.mother=mother;
  }
	
  
  
  @Id                                            // ���w�ӦC���D��C�D�������̦n���n�ϥ�int ����l�����C
  @Column(name="id")                             // ���w�ݩʹ�������Ʈw���C�� �uid�v
  @GeneratedValue(strategy=GenerationType.AUTO)  // �D�������A auto ����Ʈw�ۼW������ 
  private Integer id;
  
  
  @Column(name="name")                           // ���w�ݩʹ�������Ʈw���C�� �uname�v
  private String name;    
  
  
  @Column(name="description")                    // ���w�ݩʹ�������Ʈw���C�� �udescription�v
  private String description;
  
  
  @ManyToOne                                     // ���wPOJO���������Y�A���Ҭ��h��@���Y
  @JoinColumn(name = "mother_id")                // ���w�ݩʹ�������Ʈw���C�� �umother_id�v
  private Cat mother;                            // ���ݩʹ������C
  
  
  @Temporal(TemporalType.TIMESTAMP)              // �������(DATE,TIME �٬O TIMESTEMP)
  @Column(name="createDate")  
  private Date createDate;
  
  

  @OneToMany(mappedBy ="cat")
  private List<Event> events = new ArrayList<Event>();


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


  public String getDescription() {
	return description;
  }


  public void setDescription(String description) {
	this.description = description;
  }


  public Cat getMother() {
	return mother;
  }


  public void setMother(Cat mother) {
	this.mother = mother;
  }


  public Date getCreateDate() {
	return createDate;
  }


  public void setCreateDate(Date createDate) {
	this.createDate = createDate;
  }

  
  

  public List<Event> getEvents() {
	return events;
  }


  public void setEvents(List<Event> events) {
	this.events = events;
  }

  
  
}
