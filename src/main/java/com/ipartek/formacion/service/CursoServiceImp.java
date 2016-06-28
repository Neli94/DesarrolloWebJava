package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.exception.CursoException;

public class CursoServiceImp implements CursoService{
	private List<Curso> cursos;
	private static int i= 1;
	
	public CursoServiceImp(){
		init();
	}
	
	private void init() {
		cursos = new ArrayList<Curso>();
		Curso curso = new Curso();
		curso.setNombre("Desarrollo de aplicaciones con tecnologías web Java / ASP.NET");
		createCurso(curso);
	}
	
	@Override
	public Curso createCurso(Curso curso) {
		curso.setCodigo(i);
		//curso.setNombre("Desarrollo de Aplicaciones Multiplataforma");
		cursos.add(curso);
		//i++;
		return curso;
	}

	@Override
	public Curso getById(int codigo) {
		Curso curso=null;
		curso=new Curso();
		try {
			curso=cursos.get(getIndex(codigo));
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return curso;
	}

	@Override
	public void delete(int codigo) {
		try {
			this.cursos.remove(getIndex(codigo));
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Curso> getAll() {
		return this.cursos;
	}

	@Override
	public Curso update(Curso curso) {
		try {
			this.cursos.add(getIndex(curso.getCodigo()),curso);
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return curso;
	}
	
	private int getIndex(int codigo) throws CursoException{
		int index=-1;
		int i=0;
		boolean found=false;
		while(i<cursos.size()&&found==false){
			Curso aux=cursos.get(i);
			if(aux.getCodigo()==codigo){
				found=true;
				index=i;
				//falta la excepcion
				if(index==-1){
					throw new CursoException(CursoException.CODIGO_ERROR_FECHA_NACIMIENTO,CursoException.MSG_ERROR_FECHA_NACIMIENTO);
				}
			}
			i++;
		}
		return index;
	}

	@Override
	public void darAlta(Alumno alumno) {
		//1. obtener cuerso
		int codigo=alumno.getCurso().getCodigo();
		Curso curso=getById(codigo);
		//2. obtener map
		Map<String,Alumno> alumnos=curso.getAlumnos();
		//3. meter el alumno en el map
		alumnos.put(alumno.getDni(), alumno);
		//4. guardar/actualizar el curso
		curso.setAlumnos(alumnos);
		update(curso);
	}

	@Override
	public void darBaja(Alumno alumno) {
		int codigo=alumno.getCurso().getCodigo();
		Curso curso=getById(codigo);
		Map<String,Alumno>alumnos=curso.getAlumnos();
		alumnos.remove(alumno.getDni());
		curso.setAlumnos(alumnos);
		update(curso);
	}
	

}
