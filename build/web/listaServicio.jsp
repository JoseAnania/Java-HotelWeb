<%-- 
    Document   : listaServicio
    Created on : 04-feb-2019, 20:37:37
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
        <h1>Listado de Servicios</h1>
        
        <table border="1">
            
            <tr><th>Concepto</th><th>Número</th><th>Denominación</th><th>Importe</th></tr>
            
            <c:forEach items="${lista}" var="S">
                <tr><td>${S.concepto}</td><td>${S.idH}</td><td>${S.denominacion}</td><td>${S.importe}</td></tr>
            </c:forEach>
        </table>
        <br>
        <br>
        <a href="index.html">Volver</a>
    </body>
</html>
