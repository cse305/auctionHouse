<%-- 
    Document   : index
    Created on : Nov 13, 2012, 1:46:28 PM
    Author     : Tomasz
--%>

<%@page import="cse305.project3.servlets.TestServlet"%>
<%@page import="cse305.project3.servlets.InitServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
        InitServlet init = new InitServlet();
        TestServlet test = new TestServlet();
        
        %>
    </body>
</html>
