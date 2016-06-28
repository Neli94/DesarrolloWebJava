package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.exception.AlumnoException;
import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.pojo.exception.DniException;

public class AlumnoServiceImp implements AlumnoService{
	private List<Alumno> alumnos;
	private static int i= 1;
	private void init(){
		Alumno alumno = null;
		try {
			alumno = new Alumno();
			alumno.setCodigo(1);
			alumno.setDni("68925141y");
			alumno.setNombre("Imanol");
			alumno.setApellidos("Jimenez Lopez");
			alumnos.add(alumno);
			i++;
		} catch (CandidatoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (DniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			alumno = new Alumno();
			alumno.setCodigo(2);
			alumno.setNombre("Josu");
			alumno.setDni("68925142z");
			alumno.setApellidos("Asua Gallego");
			alumnos.add(alumno);
			i++;
		} catch (CandidatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DniException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			alumno = new Alumno();
			alumno.setCodigo(3);
			alumno.setNombre("Alvaro");
			alumno.setApellidos("Rodriguez Miguel");
			alumnos.add(alumno);
			i++;
		} catch (CandidatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public AlumnoServiceImp(){
		this.alumnos=new ArrayList<Alumno>();
		init();
	}
	/*
	public static Alumno getAlumno(){
		Alumno alum=null;
		alum=new Alumno();
		alum.setNombre("Neli");
		alum.setApellidos("Gonzalez Martinez");
		alum.setNota(8.0);
		return alum;
	}*/
	
	private static Curso crearCursoAlumno(){
		Curso curso=null;
		curso = new Curso();
		curso.setCodigo(1);
		curso.setNombre("Desarrollo de Aplicaciones con Tecnologías Web");
		return curso;
	}
	
	@Override
	public Alumno createAlumno(Alumno alumno) {
		alumno.setCodigo(i);
		alumnos.add(alumno);
		i++;
		return alumno;
	}
	@Override
	public Alumno getById(int codigo) {
		Alumno alumno=null;
		try {
			alumno=new Alumno();
			alumno=alumnos.get(getIndex(codigo));
		} catch (CandidatoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alumno;
	}
	@Override
	public void delete(int codigo) {
		try {
			this.alumnos.remove(getIndex(codigo));
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private int getIndex(int codigo) throws AlumnoException{
		int index=-1;
		int i=0;
		boolean found=false;
		while(i<alumnos.size()&&found==false){
			Alumno aux=alumnos.get(i);
			if(aux.getCodigo()==codigo){
				found=true;
				index=i;
			}

			if(index==-1){
				throw new AlumnoException(AlumnoException.CODIGO_ERROR_INDEX_ALUMNO,AlumnoException.MSG_ERROR_INDEX_ALUMNO);
			}
			i++;
		}
		return index;
	}
	@Override
	public List<Alumno> getAll() {
		return this.alumnos;
	}

	@Override
	public Alumno update(Alumno alumno) {
		try {
			this.alumnos.add(getIndex(alumno.getCodigo()),alumno);
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumno;
	}

}
