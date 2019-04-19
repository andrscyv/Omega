<%-- 
    Document   : dataValidation
    Created on : 18/04/2019, 01:32:05 AM
    Author     : soeur
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validando datos</title>
    </head>
    <body>
        <%
            String name = request.getParameter("user");
            String db = request.getParameter("db");
            System.out.print(name+db);
            if(request.getParameter("user") != null && request.getParameter("db")!=null){
                HttpSession mySession = request.getSession();
                mySession.setAttribute("user", request.getParameter("user"));
                mySession.setAttribute("dbName", request.getParameter("db"));

                mySession.setMaxInactiveInterval(20);

                response.sendRedirect("tables.jsp");
                out.println("<p> Bienvenido "+request.getParameter("user")+"</p>");
                //out.println("<a href='profile.jsp'> Perfil </a>");
                
            }else{
                out.println("<p> Sesión no iniciada </p>");
                out.println("<a href='index.html'> Iniciar sesión </a>");
            }
        %>
    </body>
</html>
