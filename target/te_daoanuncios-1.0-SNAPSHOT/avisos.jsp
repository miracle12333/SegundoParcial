<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%
    List<Aviso> avisos = (List<Aviso>) request.getAttribute("avisos");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .title {
                text-align: center;
                font-size: 2em; 
                margin-top: 20px; 
                margin-bottom: 20px; 
            }
            .info-container {
                width: 50%;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                background-color: #f9f9f9;
                text-align: center; 
            }
            .info-container p {
                margin: 10px 0;
                font-size: 1.2em; 
            }
        </style>
    </head>
    <body>
        <div class="info-container">
            <p>SEGUNDO PARCIAL TEM-742</p>
            <p>NOMBRE: Grover Eduardo Choque Chura</p>
            <p>CARNET: 134935588</p>
        </div>
        <h1 class="title">Registro Dia Del Internet</h1>
        <p><a href="AvisoController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>seminario</th>
                <th>confirmacion</th>
                <th>fecha_inscripcion</th>
                <th></th>
                <th></th>


            </tr>
            <c:forEach var="item" items="${avisos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombres}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.seminario}</td>
                    <td><input type="checkbox" name="selected" value="${item.id}"/></td>

                    <td>${item.fecha_inscripcion}</td>
                    <td><a href="AvisoController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="AvisoController?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>


        </table>
    </body>
</html>
