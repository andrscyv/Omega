<%-- 
    Document   : tables
    Created on : 18/04/2019, 01:30:41 AM
    Author     : soeur
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- Este código se copia y pega en todas las vistas que tengamos --%>
        <%
            HttpSession mySession = request.getSession();
            if(mySession.getAttribute("userName") != null){
                out.print("<h1> Bienvenido " + mySession.getAttribute("userName"));
            }else{
                response.sendRedirect("dataValidation.jsp");
            }
            
        %>
        <h1 id="welcome"></h1>
    </body>
</html>
