package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;

public interface CursoService {
	//CRUD: Create, Read, Update, Delete
	
	public Curso createCurso(Curso curso);
	
	public Curso getById(int codigo);
	
	public void delete(int codigo);
	
	public List<Curso> getAll();
	
	public Curso update(Curso curso);
	
	//dar de alta y dar de baja (pasandole un alumno y void), para dar de baja pasar el dni
	
	public void darAlta(Alumno alumno);
	
	public void darBaja(Alumno alumno);

}
