<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"       prefix="c"   %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"        prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"        prefix="sql" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL update1.jsp</title>
  </head>
  
  <body>
  
    <sql:setDataSource dataSource="jdbc/jstl" var="serverDataSource" />
             
    <sql:update var="result" dataSource="${serverDataSource}" sql="drop table if exists tb_corporation" ></sql:update>          
    Drop TABLE,影響到的資料條數：${result} <br>
    
    
    <sql:update var="result" dataSource="${serverDataSource}" >
       CREATE TABLE tb_corporation(
              ID           INT(4) UNSIGNED ZEROFILL DEFAULT '0000' NOT NULL,
              Name         CHAR(20)                 DEFAULT ''     NOT NULL,
              Description  CHAR(20)                 DEFAULT ''     NOT NULL,
              PRIMARY KEY(ID)
         );
    </sql:update>
    Create TABLE,影響到的資料條數：${result} <br>
    
    
    
    <sql:update var="result" dataSource="${serverDataSource}" >
       INSERT INTO tb_corporation VALUES (1,'Microsoft','微軟');
    </sql:update>
    INSERT 影響到的資料條數：${result} <br>
     
 
    <sql:update var="result" dataSource="${serverDataSource}" >
      INSERT INTO tb_corporation VALUES (2,'IBM','國際商用機器');
    </sql:update>
    INSERT 影響到的資料條數：${result} <br>
       
  </body>
</html>
