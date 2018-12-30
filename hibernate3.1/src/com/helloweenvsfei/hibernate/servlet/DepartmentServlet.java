package com.helloweenvsfei.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Department;
import com.helloweenvsfei.hibernate.bean.Employee;
import com.helloweenvsfei.hibernate.util.HibernateUtil;
import com.helloweenvsfei.hibernate.util.StringUtil;


/*
 *  DepartmentServlet �޲z Department ���骺�����ާ@�A�]�A�إ�(Create)�B��s(Update)�B�R��(Delete)�B�d��(Read)��GRUD �ާ@���C
 *  ���ݤ@�U�d�ߥ\��C�d�ߥ\��C�X�Ҧ��������A�]�A�����W�١B�g�z�B�]�A�����u�ơB�ҥ]�A�����u���A�ä䴩���@�U���Y�ƧǡC
 */

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentServlet() {
        super();    
    }

    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doPost(request,response);
	} // end doGet

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("UTF-8");
	 
	  
	  String action = request.getParameter("action"); // action �Ѽ�
	  if("add".equals(action)){
		add(request,response);           // �W�[����
	  }else if("query".equals(action)){
		query(request,response);         // ��Ajax �ΡA�d�߸g�z�W��
	  }else{
		list(request,response);          // �d�߳���
	  }
	  
	} // end doPost
	
	

	
	
	
	// �W�[����
	private void add(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  String id = request.getParameter("id");                         // ��o id
	  String name = request.getParameter("name");                     // ��o�����W��
	  String description = request.getParameter("description");       // ��o�y�z
	  String lineManagerId = request.getParameter("lineManagerId");   // ��o�g�z id
	  
	  
	  RequestDispatcher rd = request.getRequestDispatcher("/addDepartment.jsp");
	  
	  
	  // �}�Ҷ��q
	  Session session = HibernateUtil.getSession();
	  
	  // �}�ҥ��
	  Transaction trans = session.beginTransaction();
	  
	  List list = session.createQuery("from Department d where d.name = :name ").setParameter("name",name).list();
	  if(list.size()>0){
	    request.setAttribute("message","�����W��\""+name+"\"�w�g�s�b");
	    rd.forward(request, response);
	    session.close();
	    return;
	  } // end if(list.size()>0){
	  
	  
	  Department d = new Department();  // �s�W�@�ӳ���
	  d.setName(name);                  // �]�w�W��
	  d.setDescription(description);    // �]�w�y�z
  	  if(!StringUtil.isNull(lineManagerId)){
  	    Employee lineManager = (Employee)session.get(Employee.class,new Integer(lineManagerId));  // �d�߸Ӹg�z
  	    d.setLineManager(lineManager);                                                            // �]�w�g�z
  	  }
	 
  	  // ���[�ƪ���
  	  session.persist(d);
  	  
  	  // ������
  	  trans.commit();
  	  
  	  // �������q
  	  session.close();
	  
  	  
  	  request.setAttribute("message","����\""+d.getName()+"\"�x�s���\�C");
  	  
  	  list(request,response); // �d�߳���
	} // add
	
	
	
	
	
	
	// ��Ajax �ΡA�d�߸g�z�W��
	private void query(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  String key = request.getParameter("key"); // ��o����r
	  String hql = "from Employee e";
	  
	  if(!StringUtil.isNull(key)){
		hql += " where e.name like '%"+key+"%'";
	  }
	  final int SIZE = 8;
	  
	  Session session = HibernateUtil.getSession();
	  List<Employee > employeeList = session.createQuery(hql).setMaxResults(SIZE).list();
	  
	  session.close();
	  
	  StringBuffer buffer  = new StringBuffer();
	  buffer.append("{");
	  for(int i=0;i<employeeList.size();i++){
		if(i!=0) buffer.append(",");
		Employee employee = employeeList.get(i);
		buffer.append(employee.getId()+":\""+employee.getName()+"\"");
	  }
	  if(employeeList.size()>=SIZE){
		buffer.append(",0:\"�W�L"+SIZE+"�����...\"");  
	  }
	  
	  buffer.append("}");
	  
	  response.getWriter().write(buffer.toString());
	  
	  
	} // query
	
	
	
	
	
	
	// �d�߳���
	private void list(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  String sort = request.getParameter("SORT");    // �ƧǦC
	  String order = request.getParameter("order");  // �ƧǤ覡�G�@���B����
	  
	  if(StringUtil.isNull(sort)){
		sort="id";                       // �w�]�� id �Ƨ�
	  }
	  if(StringUtil.isNull(order)){
		order="desc";                    // �w�]�������ƦC  
	  }
	  
	
	  String departmentName = request.getParameter("departmentName");          // �����W��
	  String managerName = request.getParameter("managerName");                // �g�z�m�W
	  String employeeSize = request.getParameter("employeeSize");              // ���u�ƶq
	  String employeesOperator = request.getParameter("employeesOperator");    // �ƶq�ާ@ 
	  
	  
	  String where = "";
	  
	  // �d�߳����W��
	  if(!StringUtil.isNull(departmentName)){
		if(where.length()!=0){
		  where += " and ";	
		}
		where +=" d.name like :departmentName ";
	  } 
	  
	  // �d�߸g�z�m�W
	  if(!StringUtil.isNull(managerName)){
		if(where.length()!=0){
		  where += " and ";	
		}
		where +=" d.lineManager.name like :managerName ";
	  }   
	  
	  // �d�߭��u��
	  if(!StringUtil.isNull(employeeSize)){
		if(where.length()!=0){
		  where += " and ";	
		}
		where +=" d.employees.size "+employeesOperator+" :employeeSize ";
		// where +=" size(d.employees) "+employeesOperator+" :employeeSize ";
	  }   
	  
	  
	  String hql = " from Department d ";  // HQL �ԭz
      if(where.length()!=0){
        hql += "where "+where;	  
      }
      hql += " order by d."+sort+" "+order; // �s���ƧǦC
     
      System.out.println(DepartmentServlet.class.getName()+",hql = "+hql);
      
     
      
      
      
      
      
      // �}�Ҷ��q
      Session session = HibernateUtil.getSession();
	  
      // �}�ҥ��
      Transaction trans = session.beginTransaction();
      
      Query query = session.createQuery(hql);
      
      if(hql.contains("departmentName")){
        query.setParameter("departmentName","%"+departmentName+"%");
      }
      
      if(hql.contains("managerName")){
        query.setParameter("managerName","%"+managerName+"%");
      }
        
      if(hql.contains("employeeSize")){
        query.setInteger("employeeSize",Integer.parseInt(employeeSize));
      }
        
      
      // �ˬd�@�U�d�ߥX������
      List<Department> departmentList = query.list();
      for(Department d:departmentList){
        d.getEmployees().size();	  
      }
      
      
      // ������
      trans.commit();
      
      // �������q
      session.close();
      

      request.setAttribute("departmentList",departmentList);   // �N departmentList �����x�s�� request
      request.setAttribute("sort",sort);                       // �x�s�ƧǦC
      request.setAttribute("order",order);                     // �x�s�ƧǤ覡
      request.setAttribute("url",StringUtil.getURL(request));  // �p��URL
      
      // ��X HQL �ԭz
      if(request.getAttribute("message")==null){
    	request.setAttribute("message","HQL�G"+hql);  
      }
      
      
      
      // ��� listDepartment.jsp ����
      RequestDispatcher rd = request.getRequestDispatcher("/listDepartment.jsp");
      rd.forward(request,response);                              
      
	} // list
	
	
	
	
}
