package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;

/**
 * Servlet implementation class CursoServlet
 */
public class CursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static CursoService cService=new CursoServiceImp();
    private List<Curso>cursos=null;
    private Curso curso=null;
    private RequestDispatcher rwd=null;
    private int id=-1;
    private int operacion=-1;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			id=Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));//recoger parametros por URL
			
			//getById
			getById(request);
			
		}catch(Exception e){
			getAll(request);
		}
		rwd.forward(request,response);
	}

	private void getById(HttpServletRequest request) {
		curso=cService.getById(id);
		request.setAttribute(Constantes.ATT_CURSO, curso);
		rwd=request.getRequestDispatcher(Constantes.JSP_CURSO);
	}

	private void getAll(HttpServletRequest request) throws ServletException, IOException {
		cursos=cService.getAll();
		request.setAttribute("listado_cursos", cursos);
		rwd= request.getRequestDispatcher(Constantes.JSP_LISTADO_CURSOS);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Procesaremos el delete , el update y el create
		//1º recoger datos del objeto curso
		recogerId(request);
		try{
			//operacion=Integer.parseInt(op);
			recogerDatos(request);
			switch(operacion){
			case Constantes.OP_CREATE:
				cService.createCurso(curso);
				break;
			case Constantes.OP_DELETE:
				cService.delete(curso.getCodigo());
				break;
			case Constantes.OP_UPDATE:
				cService.update(curso);
				break;
			}
		}catch(NumberFormatException e){
			//TODO alguien nos toquetea los argumentos del form
		}
		
		//2º diferenciar la create de las demás
		if(curso.getCodigo()<0){
			//create
			cService.createCurso(curso);
		}else if(curso.getNombre()==null){
			//delete
			recogerId(request);
			cService.delete(curso.getCodigo());
		}else{
			//update
			cService.update(curso);
		}
		
		rwd=request.getRequestDispatcher(Constantes.JSP_LISTADO_CURSOS);
		rwd.forward(request, response);
	}

	private void recogerId(HttpServletRequest request) {
		id=Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		
	}

	private void recogerDatos(HttpServletRequest request) {
		curso=new Curso();
		recogerId(request);
		curso.setCodigo(id);
		String nombre=request.getParameter(Constantes.PAR_NOMBRE);
		curso.setNombre(nombre);	
	}

}
