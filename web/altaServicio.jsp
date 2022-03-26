<%-- 
    Document   : altaServicio
    Created on : 04-feb-2019, 20:19:27
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
        <h1>Alta de Servicios</h1>
        
        <form method="post" action="ServletAltaServicio">
            
            <label form="concepto">Concepto: </label>
            <input type="text" name="concepto"/>
            <br>
            <br>
            Auto: <select name="cboHabitacion" id="cboHabitacion" required="requiered">
                <option value="" disabled selected> Seleccione la Habitacion: </option>
                    <c:forEach items="${lista}" var="H">
                        <option value=${H.idH}>${H.idH}</option>
                    </c:forEach>               
            </select>
            <br>
            <br>
            <label form="importe">Importe: </label>
            <input type="text" name="importe"/>
            <br>
            <br>
            
            <input type="submit" value="Aceptar"/>
        </form>
        <br>
        <br>
        <a href="index.html">Volver</a>
    </body>
</html>
