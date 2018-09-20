<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, javax.naming.*" %>
<% request.setCharacterEncoding("utf-8"); %>

<%
 String no = request.getParameter("no");
 String name = request.getParameter("name");
 
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201800001","201800001");
 
 PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?)");
 pstmt.setString(1,no);
 pstmt.setString(2,name);
 pstmt.executeUpdate();

 

 pstmt.close();

 conn.close();


 response.sendRedirect("read.jsp");