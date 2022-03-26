<%-- 
    Document   : altaHabitacion
    Created on : 04-feb-2019, 20:00:04
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
        <h1>Alta de Habitaciones</h1>
        
        <form method="post" action="ServletAltaHabitacion">
            
            
            
            <label form="idH">Número: </label>
            <input type="text" name="idH"/>
            <br>
            <br>
            <label form="denominacion">Denominación: </label>
            <input type="text" name="denominacion"/>
            <br>
            <br>
            
            <input type="submit" value="Aceptar"/>
            
        </form>
        <br>
        <br>
        <a href="index.html">Volver</a>
    </body>
</html>
