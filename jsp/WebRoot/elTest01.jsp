<%@ page language="java" import="java.util.*" pageEncoding="BIG5" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'elTest01.jsp' starting page</title>
  </head>
  
  <body>
      userName:${param.userName}<br>
      age:${ param["age"] }<br> 
  </body>
</html>
