<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Hello JSP</title>
	</head>
<body>
	<%-- JSP Comment --%>
    <h1>Hello JSP!</h1>
    <p>
    <%
         out.println("Your IP address is ");
    %>
    <span style="color:red">
        <%= request.getRemoteAddr() %>
    </span>
    </p>
    <p>
    <%
         out.println("Time is ");
    %>
    <span style="color:green">
        <%= new java.util.Date().toString() %>
    </span>
    </p>
</body>
</html>