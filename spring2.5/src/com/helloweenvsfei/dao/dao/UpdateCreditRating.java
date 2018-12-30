package com.helloweenvsfei.dao.dao;


import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class UpdateCreditRating extends SqlUpdate{

	
	
  public UpdateCreditRating(DataSource ds){
	  
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append(" update tb_person             \n");
	sqlStr.append("    set sex = ?               \n");
	sqlStr.append("  where id = ?                \n");


	
	setDataSource(ds);         // �]�w��ƨӷ�
	setSql(sqlStr.toString()); // �]�w SQL
	declareParameter(new SqlParameter(Types.VARCHAR));
	declareParameter(new SqlParameter(Types.INTEGER));
	compile();
  } // end public UpdateCreditRating(DataSource ds){
  
  
  
  
  
  public int run(int id,String sex){
	  
	Object [] params = new Object[]{
			                         new String(sex),
			                         new Integer(id)
			                       };

	return update(params);
  } // end public int run(int id,int rating){ 
  
  
  
	
}
