<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado alumnos</title>
</head>
<body>
<a href="index.jsp">Página principal</a>
<%
List<Alumno>alumnos=(List<Alumno>)request.getAttribute("listado_alumnos");
if(alumnos!=null){
	for(Alumno alumno:alumnos){
		out.write("<p><a href='alumnos.do?"+Constantes.PAR_CODIGO+"="+alumno.getCodigo()+"'> "+alumno.getNombre()+" "+alumno.getApellidos()+"</a></p>");
	}
}
%>
</body>
</html>