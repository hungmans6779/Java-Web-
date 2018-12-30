package com.helloweenvsfei.dao.dao.impl;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlFunction;

import com.helloweenvsfei.dao.dao.IPersonDAO;
import com.helloweenvsfei.dao.dao.PersonMappingQuery;
import com.helloweenvsfei.dao.dao.UpdateCreditRating;
import com.helloweenvsfei.dao.bean.Person;



public class PersonDAOImpl extends JdbcDaoSupport implements IPersonDAO {

	
	// ��l�Ƹ�ƪ�
	public void initDatabase(){
	  StringBuffer sqlStr = new StringBuffer();
	  sqlStr.append(" create table if not exists tb_person      \n");  
	  sqlStr.append("  (                                        \n");  
	  sqlStr.append("    id int auto_increment,                 \n");
	  sqlStr.append("    name varchar(255),                     \n");  
	  sqlStr.append("    sex varchar(10),                       \n");  
	  sqlStr.append("    age int,                               \n");  
	  sqlStr.append("    birthday timestamp,                    \n");  
	  sqlStr.append("    primary key (id)                       \n");  
	  sqlStr.append("  )                                        \n");  

	  getJdbcTemplate().execute(sqlStr.toString());	
	} // end public void initDatabase(){
	
	

	
	
	
	// �W�[ Person ����
	public void addPerson(Person person) {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  insert into tb_person               \n");
      sqlStr.append("    (name, sex,  age,  birthday)      \n");
      sqlStr.append("    values                            \n");
      sqlStr.append("    (?,    ?,    ?,    ?)             \n");
      

      getJdbcTemplate().update(sqlStr.toString(),
    		                   new Object[]{
    	                                     person.getName(),
    	                                     person.getSex(),
    	                                     person.getAge(),
    	                                     person.getBirthday()
    	                                   });
      
	} // end public void addPerson(Person person) {
	
	
	

	
	// �Ǧ^�Ҧ�Person ���ƥ� 
	public int getPersonsCount() {
      String sql = " select count(*) from tb_person  ";
	  return getJdbcTemplate().queryForInt(sql);
	}

	
	
	
	
	// �ھ� id ��oPerson �m�W  
	public String getPersonName(Integer id) {
      StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  select name from tb_person   \n");
      sqlStr.append("    where id = ?               \n");
       
	  return (String)getJdbcTemplate().queryForObject(sqlStr.toString(),new Object[]{id},String.class);
	} // end public String getPersonName(Integer id) {
	
	
	

	
	
	// �Ǧ^�Ҧ���Person 
	public List<Person> listPersons() {

	  StringBuffer sqlStr = new StringBuffer();
      sqlStr.append("  select id,name,sex,age,birthday    \n");
      sqlStr.append("    from tb_person                   \n");
     
      List<Map<String,Object>> list = getJdbcTemplate().queryForList(sqlStr.toString());
	  List<Person> personList = new ArrayList<Person>();
      for(Map <String,Object> row : list){
    	Person person = new Person();
    	person.setId((Integer)row.get("id"));
    	person.setName((String)row.get("name"));
        person.setSex((String)row.get("sex"));
    	person.setAge((Integer)row.get("age"));
    	person.setBirthday((Date)row.get("birthday"));  
    	
    	personList.add(person);       // �W�[��list
      } // end for(Map<String,Object>row:list){
      
	  return personList;  // �Ǧ^ list
	} // end public List<Person> listPersons()

	
	
	
	
	
	
	
	
	
	// ��@�ϥ� MappingSqlQuery ����H���O�ʸ� Java ����
	public List findAllPersons() {

	  PersonMappingQuery personQuery = new PersonMappingQuery();                 // �ϥΫʸˬd��
	  
	  personQuery.setDataSource(getDataSource());                                // �]�w��ƨӷ�
	  personQuery.setSql("select * from tb_person  ");                           // �]�w SQL
	  // personQuery.declareParameter(new SqlParameter(java.sql.Types.NUMERIC)); // �]�w�Ѽ�
	  personQuery.compile();                                                     // �ˬd SQL
	
	  return personQuery.execute(new Object[]{});                                // �����ʸ˫᪺List
	} // end public List findAllPersons() {

	
	
	
    	
	public String testTransactions(Integer id) {
	  Person person = new Person();
	  person.setName("P.J.");
	  person.setSex("");
	  addPerson(person);
	  
	  return getPersonName(id);
	} // end public void testTransactions() {

	
	
	
	
	// ��@�ϥ� SqlUpdate
	public int sqlUpdate(Integer id,String sex){
	  UpdateCreditRating ucr = new UpdateCreditRating(getDataSource());
	  
	  return ucr.run(id,sex);	
	}

	
	public int countRows(){
	  SqlFunction sf = new SqlFunction(getDataSource(),"select count(*) from tb_person ");
	  sf.compile();
	  return sf.run();
	}
	
}
