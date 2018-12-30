package com.helloweenvsfei.hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helloweenvsfei.hibernate.bean.Employee;
import com.helloweenvsfei.hibernate.util.HibernateUtil;
import com.helloweenvsfei.hibernate.util.Pagination;
import com.helloweenvsfei.hibernate.util.StringUtil;

public class EmployeeServlet extends HttpServlet {

	
	/**
	 * Constructor of the object.
	 */
	public EmployeeServlet() {
		super();
	}

	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
	} // end doGet

	
	
	
	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setCharacterEncoding("UTF-8");
			
	  String action = request.getParameter("action");
	  if("add".equals(action)){
		addEmployee(request,response);    // �W�[���u
		return;
	  }else if("edit".equals(action)){
		edit(request,response);           // �ק���u  
	  }else if("save".equals(action)){
		save(request,response);           // �x�s���u  
	  }else if("delete".equals(action)){
		delete(request,response);         // �R�����u  
	  }else{
	    listEmployee(request,response);   // �C�X�Ҧ����u
	  }
	} // end doPost


	
	
	
	

	// �W�[���u
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
      
	  Employee employee = StringUtil.getRandomEmployee();  // �H������ Employee ���
      
	  // �}�Ҷ��q
	  Session session = HibernateUtil.getSession();
	  
	  // �}�ҥ��
	  Transaction trans = session.beginTransaction();
	  
	  // ���[�ƪ���(�x�s  employee ) 
	  session.persist(employee);
	  
	  // ������
	  trans.commit();
	  
	  // �������q
	  session.close();

	  request.setAttribute("message","�w�W�[�H�����u�G"+employee.getName());
	  
	  listEmployee(request,response);   // �C�X�Ҧ����u	  
	} // end addEmployee
	
	
	
	
	
	
	
	
	// �ק���u  
	private void edit(HttpServletRequest request,HttpServletResponse reponse) throws ServletException,IOException{
		 
	} // end edit
	
	
	
	
	// �x�s���u  
	private void save(HttpServletRequest request,HttpServletResponse reponse) throws ServletException,IOException{
		 
	} // end save
	
	
	
	
	// �R�����u  
	private void delete(HttpServletRequest request,HttpServletResponse reponse) throws ServletException,IOException{
		 
	} // end delete
	
		
	
	
	
	
	
	
	
	
	// �C�X�Ҧ����u
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
      String sort = request.getParameter("sort");    // �ƧǦC
      String order = request.getParameter("order");  // �ƦC�覡      
      if(StringUtil.isNull(sort)){
    	sort="id";
      }
      if(StringUtil.isNull(order)){
    	order="desc";  
      }
      
      
      String name = request.getParameter("name");                         // �m�W
      String age = request.getParameter("age");                           // �~��
      String ageOperate = request.getParameter("ageOperate");             // �ާ@�A�j��B����
      String sex = request.getParameter("sex");                           // �n�d�ߪ��ʧO
      String birthday = request.getParameter("birthday");                 // �n�d�ߪ��ͤ�
      String time = request.getParameter("time");                         // �n�d�ߪ��ɶ�
      String salary = request.getParameter("salary");                     // �n�d�ߪ��~��
      String salaryOperate = request.getParameter("salaryOperate");       // �ާ@�j��B����
      String description = request.getParameter("description");           // �Ƶ�
      String disabled = request.getParameter("disabled");                 // �O�_�Q����
      
      
      String where = "";
     
      // �p�G�d�ߩm�W
      if(!StringUtil.isNull(name)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.name like :name ";
      }

      // �p�G�d�ߩʧO
      if(!StringUtil.isNull(sex)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.sex = :sex ";
      }      

      // �p�G�d�ߦ~��
      if(!StringUtil.isNull(age)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.age '"+ageOperate+" :age ";   // ��´����A�j��B����B�p�� 
      }          

      // �p�G�d�ߥͤ�
      if(!StringUtil.isNull(birthday)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.birthday = :birthday ";
      }         
      
      // �p�G�d�ߤW�Z�ɶ�
      if(!StringUtil.isNull(time)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" :time between e.startTime and e.endTime ";
      }         
      
      // �p�G�d���~��
      if(!StringUtil.isNull(salary)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.salary '"+salaryOperate+" :salary ";   // ��´����A�j��B����B�p�� 
      }      
           
      // �p�G�d�߳Ƶ�
      if(!StringUtil.isNull(description)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.description like :description ";
      }   
        
      // �p�G�d�ߪ��A
      if(!StringUtil.isNull(disabled)){
    	if(!StringUtil.isNull(where)){
    	  where +=" and ";  
    	}
    	where +=" e.disabled = :disabled ";
      }     
      
      
      String hql = " from Employee e ";
      if(!StringUtil.isNull(where)){
    	hql += "where "+where;  
      }
      hql += " order by e."+sort+" "+order;  // �l�[�ƧǤ䴩
      
      
      System.out.println(EmployeeServlet.class.getName()+", hql1 = "+hql);
      
      
      Query query = HibernateUtil.getSession().createQuery("select count(e) "+hql);
      
      
      if(hql.contains("name")){
    	query.setParameter("name","%"+name+"%");
      } 
      if(hql.contains("sex")){
      	query.setParameter("sex",sex);
      } 
      if(hql.contains("age")){
      	query.setInteger("age",new Integer(age));
      }  
      if(hql.contains("birthday")){
      	query.setDate("birthday",Date.valueOf(birthday));
      } 
      if(hql.contains("time")){
      	query.setTime("time",Time.valueOf(time));
      } 
      if(hql.contains("salary")){
      	query.setDouble("salary",new Double(salary));
      } 
      if(hql.contains("description")){
      	query.setParameter("description","%"+description+"%");
      } 
      if(hql.contains("disabled")){
      	query.setBoolean("disabled","true".equals(disabled));
      } 
      
      
      Number result = (Number)query.uniqueResult();
      int count = result.intValue();
      
      
      
      
      Pagination pagination = new Pagination();  // ������
      pagination.setRecordCount(count);          // �]�w�O���`��
      pagination.setRequest(request);            // �]�w request
      
      
      query = HibernateUtil.getSession().createQuery(hql).setFirstResult(pagination.getFirstResult()).setMaxResults(pagination.getPageSize());
      
      
      List<Employee> employeeList = query.list();
      request.setAttribute("url",StringUtil.getURL(request));
      request.setAttribute("sort",sort);
      request.setAttribute("pagination",pagination);
      request.setAttribute("employeeList",employeeList);
      
      if(request.getAttribute("message")==null){
    	 request.setAttribute("message","HQL�G"+hql); 
      }
      
      request.getRequestDispatcher("/listEmployee.jsp").forward(request, response);
            
      return; 
	} // end listEmployee
	
	
	
	
	
	
}
