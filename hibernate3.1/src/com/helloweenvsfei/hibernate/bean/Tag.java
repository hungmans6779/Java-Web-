package com.helloweenvsfei.hibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/*
 *      Tag ���ҹ������O�u���@��id �D���String ������name ���q�ݩʡCTag �������� tb_tag�A
 *  �D��ϥθ�Ʈw�ۼW�������Cname ��ܬ���Tag ���W�١A @Basic�B@Column �����ҳ��Q�ٲ��A
 *  �ϥιw�]���]�w(�w�]���C�W��name)�C�]���Y�Ӭy�檺Tag �i�঳�D�`�h�����l�A�]���X��Ĳv�Ҽ{�A
 *  Tag ���S���]�w�恵�l���h��h�ݩʡC
 */


@Entity                        // Entity �]�w
@Table(name = "tb_tag")        // Table �]�w
public class Tag {             // �������O

	@Id                        // id �]�w
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;        // �D��

	private String name;       // ���ҦW��,�ϥιw�]�]�w

	@ManyToMany(mappedBy="tags")
	private Set<Post> posts = new HashSet<Post>();

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

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
