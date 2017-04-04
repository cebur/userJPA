<%-- 
    Document   : usuarios
    Created on : 25-03-2017, 15:38:50
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>Usuarios</title>
    </head>
    <body>
        <h1>Usuario</h1>
        
        <p>Número usuarios</p>
        <c:out default="No hay usuario registrado" value="${numeroUsuarios}"  ></c:out>
        <br><br>
        
        <p>El primer usuario</p>
        <c:out default="No hay usuario registrado" value="${user}"  ></c:out>
        <br><br>
        
        <p>Lista Usuarios</p>
        <c:forEach var="u" items="${lista}" >
            <c:out default="No hay usuario registrado" value="${u.toString()}"  ></c:out>
            <br>
        </c:forEach>
        
    </body>
</html>
