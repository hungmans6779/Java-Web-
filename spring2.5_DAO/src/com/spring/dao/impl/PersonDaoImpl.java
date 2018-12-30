package com.spring.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlFunction;

import com.spring.dao.IPersonDao;
import com.spring.entity.Person;


/*
 *  ��@ Person �� DAO ����
 *  
 *  �~�� Spring �� DAO �Ҳդ���  JdbcDaoSupport ���O�C  JdbcDaoSupport ���ѤF JdbcTemplate ����A�ʸˤF�`�Ϊ� JDBC �ާ@�C
 *  PersonDaoImpl ���٩w�q�F�@�Ӫ�l�Ƥ�k�A�Ω��l�ƪ��c(�p�G���s�b�h�إ�)�C
 *  
 *  �ѩ�{���X�����~�ӤF Spring ���Ѫ� JdbcDaoSupport�A�]���S���ϥ� Connection�B Statement �� JDBC API�A�]���������o�Ǹ귽�C
 *  JdbcDaoSupport �|�۰ʺ��@�o�Ǹ귽�C
 *  �{���X���� Spring �ʸ˦n�� JdbcTemplate �Ӱ��� SQL�B�d�� Person �M��B�d�߳�@ Person �ݩʭȡB�d�� Person ���`�ơC
 *  �d�� Person �C��ɶǦ^���O�@�� List<Map<String,Object>> ������ơC  
 */
public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {


  // ��l�Ƹ�Ʈw
  public void initDataBase(){
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
	
	System.out.println(PersonDaoImpl.class.getName()+",initDataBase()  execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	getJdbcTemplate().execute(sqlStr.toString());
  } // end initDataBase()
  
  
  
  
  
  

  // �W�[Person ����
  public void addPerson(Person person) {
	StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  insert into tb_person               \n");
    sqlStr.append("    (name, sex,  age,  birthday)      \n");
    sqlStr.append("    values                            \n");
    sqlStr.append("    (?,    ?,    ?,    ?)             \n");
   
    System.out.println(PersonDaoImpl.class.getName()+",addPerson(Person person) execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
    
    getJdbcTemplate().update(sqlStr.toString(),new Object[]{
    	                                                      person.getName(),
    	                                                      person.getSex(),
    	                                                      person.getAge(),
    	                                                      person.getBirthday()});                                                
  } // end addPerson
  
  
  
  
  
  
  

  // �Ǧ^�Ҧ�Person ���ƥ� 
  public int getPersonsCount() {
	StringBuffer sqlStr = new StringBuffer("select count(*) from tb_person ");
	  
	System.out.println(PersonDaoImpl.class.getName()+",getPersonsCount() execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	return getJdbcTemplate().queryForInt(sqlStr.toString());
  } // end  getPersonsCount()
  
  
  
  
  
  
  

  // �ھ� id ��oPerson �m�W   
  public String getPersonName(Integer id){
	StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("  select name        \n");
	sqlStr.append("    from tb_person   \n");
	sqlStr.append("   where id = ?      \n");
	 
	System.out.println(PersonDaoImpl.class.getName()+",getPersonName(Integer id)  execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	return (String)getJdbcTemplate().queryForObject(sqlStr.toString(),new Object[]{id},String.class);
  } // end getPersonName
  
  
  
  
  
  
  

  // �Ǧ^�Ҧ���Person 
  @SuppressWarnings("all")
  public List<Person> listPersons(){
	StringBuffer sqlStr = new StringBuffer();
    sqlStr.append("  select id,name,sex,age,birthday    \n");
    sqlStr.append("    from tb_person                   \n");
   
	System.out.println(PersonDaoImpl.class.getName()+",listPersonss()  execute...");
	System.out.println("sqlStr = "+sqlStr.toString());

    List<Map<String,Object>> list = getJdbcTemplate().queryForList(sqlStr.toString());
        
    List <Person> personList = new ArrayList<Person>();
    Person person = null;
	for(Map<String,Object> row:list){
	  person = new Person();
	  person.setId((Integer)row.get("id"));
	  person.setName((String)row.get("name"));
	  person.setSex((String)row.get("sex"));
	  person.setBirthday((Date)row.get("birthday"));

	  personList.add(person);
	} // end for(Map<String,Object> row:list){
    
	return personList;
  } // end listPersons()
  
  
  
  
  
  
  

  // �Ǧ^�Ҧ���Person(�ĥ�MappingSqlQuery ��)
  public List findAllPersons(){

    StringBuffer sqlStr = new StringBuffer();
	sqlStr.append("select * from tb_person   \n");
	  
	System.out.println(PersonDaoImpl.class.getName()+",findAllPersons() execute...");
	System.out.println("sqlStr = "+sqlStr.toString());
	
	/*
	 *  MappingSqlQuery �O�@�ө�H���O�A�}�o�̻ݭn�ꥦ�� mapRow(ResultSet,int) ��k��{�q ResultSet �� Java ���󪺬M�g�C
     *  �Ӥ�k�����Ǧ^�������O����C  
	 */
	PersonMappingQuery personQuery = new PersonMappingQuery();
	personQuery.setDataSource(getDataSource());       // �]�w��ƨӷ�
	personQuery.setSql(sqlStr.toString());            // �]�w SQL
	personQuery.compile();
	  
	return personQuery.execute(new Object[]{});      // �����ʸ˫᪺List 
  } // end findAllPersons()
  
  
  
  
  
  
  

  // ��@�ϥ� SqlUpdate
  public int sqlUpdate(Integer id,String sex){
	
	/*
	 *  SqlUpdate �ΨӰ���SQL ��s�ԭz�A�i�H�]�w�ѼơC�i��P JdbcDaoSupport �O�@�˪��C
     *  SqlUpdate �i�H�N�Y�ӥ\��ҲդơC
	 */
	UpdateCreditRating ucr = new UpdateCreditRating(getDataSource());
	
	return ucr.run(id,sex); 
  } // end sqlUpdate
  
  
  
  
  
  
  

  // ���� SpringFramework SqlFunction 
  public int countRows() {
	  
	/*
	 *  SqlFunction �Ǧ^��@�檺�d�ߵ��G�A�w�]�Ǧ^ int �����C
	 *  �}�o�̥i�H�����^��L��������ơB�\��۷�� JdbcTemplate �� queryForInt()�BqueryForString()�BqueryForObject() ���C
	 *  
	 */
    SqlFunction sf = new SqlFunction(getDataSource(),"select count(*) from tb_person ")	;
    
    sf.compile();
    int count = sf.run();
    
	return count;
  } // end countRows()
  
  
  
  
  
  
  

  // ���եΪ�
  public String testTransactions(Integer id) {
	Person person = new Person();
	person.setName("B.J.");
	person.setSex("");
	addPerson(person);
	  
	return getPersonName(id);  
  } // end testTransactions
  
  
  
  
  
  
  


  
  
  
  
  


}
