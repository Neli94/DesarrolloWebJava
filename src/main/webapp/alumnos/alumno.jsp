<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
		Alumno alumno = (Alumno) request.getAttribute(Constantes.ATT_ALUMNO);
		int op=-1;
		if(alumno!=null){
			op=Constantes.OP_UPDATE;
		 %>
		 <title>Alumno <% out.write(alumno.getNombre()); %></title>
		 <%
		}else{
			%>
			<title>Alumno - Alumno nuevo</title>
			<%
			alumno=new Alumno();
			op=Constantes.OP_CREATE;
		}
		%>
<title>Alumno</title>
</head>
<body>
	<div id="wrapper"></div>
	<a href="<%=Constantes.SERVLET_ALUMNOS %>">Atrás</a>
	<!-- <%=Constantes.SERVLET_ALUMNOS %> -->
	
	<%
	if(alumno!=null){
	%>
		<form name="" id="" method='post' action="<%=Constantes.SERVLET_ALUMNOS%>">
		<input type="hidden" 
				name="<%=Constantes.PAR_OPERACION %>" 
				id="<%=Constantes.PAR_OPERACION %>" 
				value="<%=op%>" />
			<input type="hidden" 
				name="<%=Constantes.PAR_CODIGO %>" 
				id="<%=Constantes.PAR_CODIGO %>" 
				value="<%=alumno.getCodigo()%>" />
			<label for="<%=Constantes.PAR_NOMBRE%>" ></label>
			<input type="text" 
				name="<%=Constantes.PAR_NOMBRE%>" 
				id="<%=Constantes.PAR_NOMBRE%>" 
				value="<%=alumno.getNombre()%>" />
			<input type="submit" />
		
		</form>
			
	<% }
	%>
	</div>
</body>
</html>