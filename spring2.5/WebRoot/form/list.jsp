<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2 page</title>
    <style type="text/css" >
	  body, td, th, input {font-size: 12px; }
	  table {border-collapse: collapse; border: 1px solid #000000; }
	  th, td {border-collapse: collapse; border: 1px solid #000000; padding: 4px; }
	</style>
  </head>
  
  <body>
  
    <struts:form action="add_cat" >
	  <struts:textfield name="cat.name" label="名字" value="" />
	  <struts:submit value=" 添加 "></struts:submit>
	</struts:form>
    
    
    <table>
      <tr>
        <th>ID</th>
        <th>name</th>
        <th>CreateDate</th>
      </tr>  
      <struts:iterator value="catList">
        <tr>
          <td><struts:property value="id" /></td>
          <td><struts:property value="name" /></td>
          <td><struts:property value="createdDate" /></td>
        </tr>
      </struts:iterator>
    </table>
    
  </body>
  
</html>
