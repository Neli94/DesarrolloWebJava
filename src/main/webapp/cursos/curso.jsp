<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
		<%
		Curso curso = (Curso) request.getAttribute(Constantes.ATT_CURSO);
		int op=-1;
		if(curso!=null){
			op=Constantes.OP_UPDATE;
		 %>
		 <title>Curso <% out.write(curso.getNombre()); %></title>
		 <%
		}else{
			%>
			<title>Curso - Curso nuevo</title>
			<%
			curso=new Curso();
			op=Constantes.OP_CREATE;
		}
		%>
<title>Curso</title>
</head>
<body>
	<div id="wrapper"></div>
	<a href="index.jsp">Atrás</a>
	<!-- <%=Constantes.SERVLET_CURSOS %> -->
	
	<%
	if(curso!=null){
	%>
		<form name="" id="" method='post' action="<%=Constantes.SERVLET_CURSOS%>">
		<input type="hidden" 
				name="<%=Constantes.PAR_OPERACION %>" 
				id="<%=Constantes.PAR_OPERACION %>" 
				value="<%=op%>" />
			<input type="hidden" 
				name="<%=Constantes.PAR_CODIGO %>" 
				id="<%=Constantes.PAR_CODIGO %>" 
				value="<%=curso.getCodigo()%>" />
			<label for="<%=Constantes.PAR_NOMBRE%>" ></label>
			<input type="text" 
				name="<%=Constantes.PAR_NOMBRE%>" 
				id="<%=Constantes.PAR_NOMBRE%>" 
				value="<%=curso.getNombre()%>" />
			<input type="submit" />
		
		</form>
			
	<% }
	%>
	</div>
</body>
</html>