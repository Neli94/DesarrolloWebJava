package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.AlumnoServiceImp;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;

/**
 * Servlet implementation class AlumnoServlet
 */
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AlumnoService aService=new AlumnoServiceImp();
    private List<Alumno>alumnos=null;
    private Alumno alumno=null;
    private RequestDispatcher rwd=null;
    private int id=-1;
    private int operacion=-1;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumnoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		//System.out.println(alumnos.size());
	}

	private void getAll(HttpServletRequest request) {
		alumno=aService.getById(id);
		request.setAttribute(Constantes.ATT_ALUMNO, alumno);
		rwd=request.getRequestDispatcher(Constantes.JSP_ALUMNO);
	}

	private void getById(HttpServletRequest request) {
		alumnos=aService.getAll();
		request.setAttribute("listado_alumnos", alumnos);
		rwd= request.getRequestDispatcher(Constantes.JSP_LISTADO_ALUMNOS);
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
						aService.createAlumno(alumno);
						break;
					case Constantes.OP_DELETE:
						aService.delete(alumno.getCodigo());
						break;
					case Constantes.OP_UPDATE:
						aService.update(alumno);
						break;
					}
				}catch(NumberFormatException e){
					//TODO alguien nos toquetea los argumentos del form
				}
				
				//2º diferenciar la create de las demás
				if(alumno.getCodigo()<0){
					//create
					aService.createAlumno(alumno);
				}else if(alumno.getNombre()==null){
					//delete
					recogerId(request);
					aService.delete(alumno.getCodigo());
				}else{
					//update
					aService.update(alumno);
				}
				
				rwd=request.getRequestDispatcher(Constantes.JSP_LISTADO_ALUMNOS);
				rwd.forward(request, response);
	}
	
	private void recogerId(HttpServletRequest request) {
		id=Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO));
		
	}

	private void recogerDatos(HttpServletRequest request) {
		try {
			alumno=new Alumno();
		} catch (CandidatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recogerId(request);
		alumno.setCodigo(id);
		String nombre=request.getParameter(Constantes.PAR_NOMBRE);
		alumno.setNombre(nombre);
		
	}

}
