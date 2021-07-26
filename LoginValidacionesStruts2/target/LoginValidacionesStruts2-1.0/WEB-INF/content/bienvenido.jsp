<%-- 
    JSP de bienvenido accediendo a textos de properties por s:text y valores de controlador
    por s:property
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
       
        <title> <s:text name="bienvenido.titulo"/> </title>
        <s:head/> <!-- implemente estilos css de struts para los mensajes de addActionError y addFieldError-->
    </head>
    <body>
        <h1> <s:text name="bienvenido.titulo"/> </h1>
        <s:actionmessage/> <!-- los mensajes de tipo addActionMessage no asociados podran mostrarse -->
        <s:actionerror/> <!-- los mensajes de tipo addFieldError no asociados podran mostrarse -->
        
        <h2> <s:text name="bienvenido.mensaje"/>:</h2>
        <br>
        <s:text name="form.usuario"/> : <s:property value="usuario"/>
        <br>
        <s:text name="form.password"/> : <s:property value="password"/>
          <br>
          <a href="<s:url action="login"/>"> <s:text name="bienvenido.regresar"/> </a>
          
    </body>
</html>
