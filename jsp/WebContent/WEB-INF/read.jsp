<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201800001","201800001");
 
 PreparedStatement pstmt = conn.prepareStatement("select * from student");
 ResultSet rs = pstmt.executeQuery();
 
 while(rs.next()) {
  String no = rs.getString("no");
  String name = rs.getString("name"); %>
  <%= no %>
  <%= name %><br>
  <% }

 

  pstmt.close();

  rs.close();

  conn.close();
%>
</body>
</html>