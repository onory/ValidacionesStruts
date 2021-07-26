<%-- 
    este JSP cumple en el patron MVC como vista
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <!-- la etiqueta s:text llama el valor desde properties-->
        <title> <s:text name="form.cabecero" /> </title>
        <s:head/> <!-- implemente estilos css de struts para los mensajes de addActionError y addFieldError-->
    </head>
    <body>
        <!-- Formulario para recuperar valir de entrada-->
        <h1> <s:text name="form.titulo" /></h1>
        
        <s:actionerror/> <!-- los mensajes de tipo addFieldError no asociados podran mostrarse -->
        
        <s:form action="validarUsuario">   <!-- action hace mencion desde clase validar usuario por anotacion sin pasar por xml-->
            <!-- names se usara para tomar el GET y SEt del controlador-->
            <s:textfield key="form.usuario" name="usuario"/> 
            <s:textfield key="form.password" name="password"/>  
            <s:submit key="form.boton" name="submit"/>
        </s:form>
        
                 
    </body>
</html>
