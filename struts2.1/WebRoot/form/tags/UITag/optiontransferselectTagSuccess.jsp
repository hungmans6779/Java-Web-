<%@ page language="java" contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="/struts-tags"        prefix="struts"  %>
<%@ taglib uri="/struts-dojo-tags"   prefix="sx"      %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'optiontransferselectTagSuccess.jsp' starting page</title>
    <sx:head />
  </head>
  
  <body>
    已經勾選的省份：<struts:property value="%{province}" /><br/>
    剩餘的省份：    <struts:property value="%{city}" /><br/>
  </body>
  
</html>