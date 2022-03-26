<%-- 
    Document   : listaHabitacion
    Created on : 04-feb-2019, 20:12:11
    Author     : José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel</title>
    </head>
    <body>
        <h1>Listado de Habitaciones</h1>
        
        <table border="1">
            
            <tr><th>Número</th><th>Denominación</th></tr>
            
            <c:forEach items="${lista}" var="H">
                <tr><td>${H.idH}</td><td>${H.denominacion}</td></tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="index.html">Volver</a>
    </body>
</html>
