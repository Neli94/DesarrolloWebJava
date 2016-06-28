<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado Cursos</title>
</head>
<body>
<a href="index.jsp">Página principal</a>
<%
List<Curso>cursos=(List<Curso>)request.getAttribute("listado_cursos");
if(cursos!=null){
	for(Curso curso:cursos){
		out.write("<p><a href='cursos.do?"+Constantes.PAR_CODIGO+"="+curso.getCodigo()+"'>  "+": "+curso.getNombre()+"</a></p>");
	}
}
%>
</body>
</html>