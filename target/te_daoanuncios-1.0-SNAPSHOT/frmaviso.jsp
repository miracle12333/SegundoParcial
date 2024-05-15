<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%
    Aviso aviso=(Aviso)request.getAttribute("aviso");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo registro</h1>
        <form action="AvisoController" method="post">
            <input type="hidden" name="id" value="${aviso.id}"/>
            <table>
                <tr>
                    <td>nombres</td>
                    <td><input type="text" name="nombres" value="${aviso.nombres}"/></td>
                </tr>  
                <tr>
                    <td>apellidos</td>
                    <td><input type="text" name="apellidos" value="${aviso.apellidos}"/></td>                   
                </tr>
                <tr>
                    <td>seminario</td>
                    <td><input type="text" name="seminario" value="${aviso.seminario}"/></td>
                </tr>
                <tr>
                    <td>fecha_inscripcion</td>
                    <td><input type="text" name="fecha_inscripcion" value="${aviso.fecha_inscripcion}"/></td>
                </tr>
                <tr>
                    
                    <td><input type="submit"/></td><!-- comment -->
                    
                </tr>
           
            </table>  
        </form>
         
    </body>
</html>
