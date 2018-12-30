package com.helloweenvsfei.struts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.helloweenvsfei.struts.bean.Person1;

public class PersonDAO {

	
  // �x�s�ϥΪ̸�T
  public void addPerson(Connection conn,Person1 person) throws SQLException {
	  
	// ���J�H����T�W��
    StringBuffer personSQL = new StringBuffer();
    personSQL.append("  insert into tb_person                                  \n");
    personSQL.append("        (account,name,birthday,secret,create_date )      \n");
    personSQL.append("  values( ?,     ?,   ?,       ?,     ?)                 \n");
    
    // ���J�R�n
    StringBuffer hobbySQL = new StringBuffer();
    hobbySQL.append("   insert into tb_hobby          \n");
    hobbySQL.append("         (person_id, hobby)      \n");
    hobbySQL.append("  values (?,         ?)          \n");

    PreparedStatement preStmt = null;
	ResultSet rs = null;
	try {      
	  conn.setAutoCommit(false);

	  preStmt = conn.prepareStatement(personSQL.toString());
	  
      // ���J�H����T
	  preStmt.setString(1,person.getAccount());
	  preStmt.setString(2,person.getName());
	  preStmt.setDate(3,person.getBirthday());
	  preStmt.setBoolean(4,person.isSecret());
	  preStmt.setTimestamp(5,person.getCreateDate());

	  preStmt.executeUpdate();            // �����s

	  rs = preStmt.getGeneratedKeys();    // ��o�۰ʴ��J�� id ��
	  rs.next();
	  int personId = rs.getInt(1);        // ��o�Ĥ@�C�����


      // �妸���J�R�n��T
      preStmt = conn.prepareStatement(hobbySQL.toString());
      for(Iterator<String> it = person.getHobby().iterator();it.hasNext();){
    	preStmt.setInt(1,personId);
    	preStmt.setString(2,it.next());
    	preStmt.addBatch();               // �W�[�妸
      } // end for(Iterator<String> it = person.getHobby().iterator();it.hasNext();){

 	  preStmt.executeBatch();             // �妸����
	  
	  conn.commit();                      // �ǰe���

	}catch(Exception e){
	  e.printStackTrace();
	}finally {
	  if (rs != null)      { rs.close();      rs=null;      }
	  if (preStmt != null) { preStmt.close(); preStmt=null; }
	  if (conn != null)    { conn.close();    conn = null;  }
	 }
  }  // end public void addPerson

  
  
  
  
  
  
  
  // �C�X�ϥΪ̸�T
  public List <Person1> listPersons(Connection conn) throws SQLException{
	List <Person1> list = new ArrayList<Person1>();
    
	Statement stmt = null;
	ResultSet rs = null;
	try{
	  // �M��ӤH��T
	  stmt = conn.createStatement();
	  rs = stmt.executeQuery("select * from tb_person ");
	  while(rs.next()){
		Person1 person = new Person1();
		
		person.setId(rs.getInt("id"));
		person.setAccount(rs.getString("account"));
		person.setName(rs.getString("name"));
		person.setBirthday(rs.getDate("birthday"));
		person.setCreateDate(rs.getTimestamp("create_date"));
		person.setSecret(rs.getBoolean("secret"));
		
		list.add(person);
	  } // end while(rs.next()){

	  
	  for(Iterator<Person1> it = list.iterator();it.hasNext();){
		Person1 person = it.next();
		
		// �d���Ҧ����R�n
		rs = stmt.executeQuery("select * from tb_hobby where person_id = "+person.getId());
		while(rs.next()){
		  person.getHobby().add(rs.getString("hobby"));	
		} // end while(rs.next()){
	  } // end for(Iterator<Person1>it = list.iterator();it.hasNext();){
	  
	}catch(Exception e){
	  e.printStackTrace();	
	}finally{
	  if(rs!=null)   { rs.close();    rs = null;    }
	  if(stmt!=null) { stmt.close();  stmt = null;  }
	  if(conn!=null) { conn.close();  conn = null;  }
	}
 	return list;
  } // end listPersons
  
  
  
  
}
