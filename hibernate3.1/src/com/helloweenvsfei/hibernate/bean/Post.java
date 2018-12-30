package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/*
 *      Post ���l�������O���� id �D��A���D�B���e�����q�ݩʡA�٦��@��Set <Tag> �������h��h���X�ݩ�tags�C�q Java �{���X�W�ݡA
 *  �@��h�ݩʻP�h��h�ݩʨS����ϧO�A���OSet �Ϊ̬OList ���������X�����ݩʡC���O���̪�Hibernate �]�w�O�������@�˪��A�x�s����]�O�������@�˪��C
 *      id �D��ϥθ�Ʈw�ۼW�������A���Dtitle �ϥ�Hibernate �w�]�]�w�A���e content �ϥ� @Column �� columnDefinition ���w�b��Ʈw���ϥ� text �j��r�����C
 *      �Ӧb�h��h�ݩ� tags �W�A�ϥ� @ManyToMany ���w�ӦC���h��h�ݩʡAfetch �]�w���J�覡�Acascade �]�w�h�p�x�s�ݩʡC�h��h�ݩʥ��M�ϥ� @JoinTable ���w�������]�w�A
 *  �䤤 name ���w��W�AjoinColumn ���w�Ӫ�(�]�N�OPost ��������)
 *  �P�������������Y�AinverseJoinColumns ���w�t�@��(�]�N�OTag ��������)�P�������������Y�C
 */

@Entity                                                 // �������O�]�w
@Table(name = "tb_post")                                // Table �]�w
public class Post {

	
	@Id                                                 // id �]�w
	@GeneratedValue(strategy = GenerationType.AUTO) 	// �ۼW��
	private Integer id;

	
	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.PERSIST})
	@JoinTable(                                         // ���������Y
	  name="tb_tag_post",
	  joinColumns = @JoinColumn(name = "post_id",referencedColumnName="id"),
	  inverseJoinColumns = @JoinColumn(name="tag_id",referencedColumnName="id")
	)
	private Set<Tag> tags = new HashSet<Tag>();

		
 	private String tilte;                               // ���D�A�ϥιw�]�]�w                         

	@Column(columnDefinition = "text")                  // ��Ʈw���ӦC�� text ����
	private String content;                             // ���e

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public String getTilte() {
		return tilte;
	}

	public void setTilte(String tilte) {
		this.tilte = tilte;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
