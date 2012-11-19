<%-- 
    Document   : index
    Created on : Nov 13, 2012, 1:46:28 PM
    Author     : Tomasz
--%>

<%@page import="cse305.project3.auction_objects.Person"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="cse305.project3.session_factory.SessionFactoryStore"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Employees</title>
    </head>
    <body>
        <h1>List of Employees</h1>
        <%
        out.println("from java<BR>");
        SessionFactory sessionFactory =
                    SessionFactoryStore.getSessionFactoryStore().getSessionFactory();

            Session sessionInJsp = sessionFactory.openSession();
            sessionInJsp.beginTransaction();
        
        // get all persons with last name Smith
            Query query=sessionInJsp.createQuery("from Person where lastName=:lastname");
            query.setParameter("lastname","Smith");
            List queryResult=query.list();
            
            out.println("<TABLE>");
            out.println("<TR>");
            out.println("<TD>ID</TD><TD>Last Name</TD><TD>First Name</TD>");
            out.println("</TR>");
            Iterator iter = queryResult.iterator();
            while(iter.hasNext()){
                out.println("<TR>");
                Person person = (Person)iter.next();
                out.println("<TD>"+person.getPersonID()+"</TD>");
                out.println("<TD>"+person.getLastName()+"</TD>");
                out.println("<TD>"+person.getFirstName()+"</TD>");
                out.println("</TR>");
            }
            out.println("</TABLE>");
            
            
         
            sessionInJsp.getTransaction().commit();
            sessionInJsp.close();
        %>
        
        
    </body>
</html>
