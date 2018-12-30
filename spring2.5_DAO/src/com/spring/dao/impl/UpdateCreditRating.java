package com.spring.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;


/*
 *  SqlUpdate �ΨӰ���SQL ��s�ԭz�A�i�H�]�w�ѼơC�i��P JdbcDaoSupport �O�@�˪��C
 *  SqlUpdate �i�H�N�Y�ӥ\��ҲդơC
 */
public class UpdateCreditRating extends SqlUpdate{

	
  // �غc���
  public UpdateCreditRating(DataSource ds){
	  
    StringBuffer sqlStr = new StringBuffer();
    sqlStr.append(" update tb_person             \n");
	sqlStr.append("    set sex = ?               \n");
	sqlStr.append("  where id = ?                \n");

	setDataSource(ds);            // �]�w��Ʈw
	setSql(sqlStr.toString());
	
	declareParameter(new SqlParameter(Types.VARBINARY));   // �]�w�ѼƦ�m
	declareParameter(new SqlParameter(Types.INTEGER));     // �]�w�Ѽƪ���m
	compile();                                             // �sĶ SQL
  } // end UpdateCreditRating
  
  
  
  
  // ����
  public int run(Integer id,String rating){
	Object [] params = new Object[]{ 
			                       new String(rating),
			                       new Integer(id)};
	
	return update(params);
  } // end run

  
  
  
  
  
}
