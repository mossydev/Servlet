<%-- 
    Document   : mostrarUsuarios
    Created on : 16 sep. 2023, 15:29:09
    Author     : moss_
--%>

<%@page import="Logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Usuarios</title>
    </head>
    <body>
        <h1>Lista de Usuarios Registrados</h1>
        <%
            List<Usuario>listaUsuarios=(List) request.getSession().getAttribute("listaUsuarios");
            
            int cont=1;
            
        for(Usuario usu : listaUsuarios){
        
        %>
        
        <p>Usuario No. <%=cont%> </p>
        <p>Id: <%=usu.getId()%></p>
        <p>Dni: <%=usu.getDni()%></p>
        <p>Nombre: <%=usu.getNombre()%></p>
        <p>Apellido: <%=usu.getApellido()%></p>
        <p>Teléfono: <%=usu.getTelefono()%></p>
        <p>-------------------------------------</p>
        <%cont = cont +1;%>
        <% } %>
    </body>
</html>
