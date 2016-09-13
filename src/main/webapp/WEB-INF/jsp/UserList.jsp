<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.aaa.entity.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<User> userList=(List<User>)request.getAttribute("userList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
	<tr>
		<td>user</td>
		<td>pswd</td>
	</tr>
	</thead>
	<%for(User user:userList) {%>
	<tr>
		<td><%=user.getUsername() %></td>
		<td><%=user.getPassword() %></td>
	</tr>
	<%} %>
</table>
</body>
</html>