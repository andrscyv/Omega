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
            if(request.getParameter("password") != null && request.getParameter("userName")!=null){
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Omega","root","root");
                Statement query = con.createStatement();
                String name = request.getParameter("userName");
                ResultSet rs = query.executeQuery("SELECT * FROM USERS WHERE USER_NAME = '" + name + "'");
                
                String psswrd = "";
                String dbName = "";
                while(rs.next()) {
                    psswrd = rs.getString("PASSWORD");
                    dbName = rs.getString("DB_NAME");
                } 
                
                if(request.getParameter("password").equals(psswrd)){
                    HttpSession mySession = request.getSession();
                    mySession.setAttribute("user", name);
                    mySession.setAttribute("dbName", dbName);
                    
                    mySession.setMaxInactiveInterval(20);
                    
                    response.sendRedirect("tables.jsp");
                    out.println("<p> Bienvenido "+name+"</p>");
                    //out.println("<a href='profile.jsp'> Perfil </a>");
                }else{
                    out.println("<p> Datos incorrectos </p>");
                    out.println("<a href='index.html'> Regresar al inicio </a>");
                }
                
            }else{
                out.println("<p> Sesión no iniciada </p>");
                out.println("<a href='index.html'> Iniciar sesión </a>");
            }
        %>
    </body>
</html>
