package com.ipartek.formacion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ipartek.formacion.pojo.Alumno;
import com.ipartek.formacion.pojo.Candidato;
import com.ipartek.formacion.pojo.Curso;
import com.ipartek.formacion.pojo.Modulo;
import com.ipartek.formacion.pojo.exception.CandidatoException;
import com.ipartek.formacion.pojo.exception.DniException;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.AlumnoServiceImp;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.service.CursoServiceImp;
import com.ipartek.formacion.service.ModuloService;
import com.ipartek.formacion.service.ModuloServiceImp;
import com.ipartek.formacion.service.Util;

public class Main {

	public static void main(String[] args) {
		String str="78933302Q";
		System.out.println(str.substring(0, 8));
		System.out.println(str.substring(8));
		AlumnoService aService=new AlumnoServiceImp();
		List<Alumno> listAlumnos=aService.getAll();
		
		
		CursoService cService=new CursoServiceImp();
		List<Curso>listCursos= cService.getAll();
		
		ModuloService mService=new ModuloServiceImp();
		Modulo modulo=null;
		modulo=new Modulo();
		modulo=mService.createModulo(modulo);
		List<Modulo>listModulos=mService.getAll();
		System.out.println("Lista de módulos: ");
		for(Modulo i:listModulos){
			System.out.println(i.getNombre());
		}
		
		int[] notas={4,6,9};
		for(int i: notas){
			System.out.println(i);
		}
		
		
		
		int mod=78933302%23;
		System.out.println("resto: "+ mod);
		
		Util util=null;
		util=new Util();
		try {
			System.out.println("Validado: " + Util.validarDni("78933302Q"));
		} catch (CandidatoException e) {
			e.getMessage();
			e.printStackTrace();
		}
		
	}
	
	public static String saludarAlumno(Candidato alumno){
		String saludo="";
		saludo+="Hola " + alumno.getNombre();
		return saludo;
	}
	
	public static void haAprobado(Candidato alumno){
		String mensaje="";
		
		if(alumno.getNota()>=5.0){
			mensaje+="Has aprobado";
		}else{
			mensaje+="Has suspendido";
		}
		
		System.out.println(mensaje);
	}
	
	private static void evaluar(Candidato alumno){
		int nota=(int)Math.floor(alumno.getNota());
		
		if(alumno instanceof Alumno){
			Alumno aux=(Alumno) alumno;
			aux.getCurso();
		}
		
		switch(nota){
		case 5:{
			String mensaje="Es un candidato normalillo";
			System.out.println(mensaje);
			break;
		}
		
		case 6:{
			String mensaje="No está mal el candidato";
			System.out.println(mensaje);
			break;
		}
			
		case 7:{
			String mensaje="Es un buen candidato";
			System.out.println(mensaje);
			break;
		}
		
		case 8:{
			String mensaje="Es un gran candidato";
			System.out.println(mensaje);
			break;
		}
		
		case 9:
			
			
		case 10:{
			String mensaje="HAY QUE PILLARLO";
			System.out.println(mensaje);
			break;
		}
		
		default:{
			String mensaje="Mejor que no venga";
			System.out.println(mensaje);
			break;
		}
		
		}
	}
	
	private void gestionarMap(){
		Curso curso=new Curso();
		ModuloService mService= new ModuloServiceImp();
		Modulo modulo=mService.getById(0);
		Map<Integer,Modulo>modulos=curso.getModulos();
		modulos.put(modulo.getCodigo(), modulo);	//equivalente a arraylist.add();
		modulo=modulos.get(modulo.getCodigo());
		
		for(Modulo i:modulos.values()){
			System.out.println(i.getNombre());
		}
		
		for(Entry<Integer,Modulo> i: modulos.entrySet()){
			System.out.println(i.getKey());
			System.out.println(i.getValue().getNombre());
		}
	}
	
	private void matricularAlumnos(){
		CursoService cService=new CursoServiceImp();
		AlumnoService aService=new AlumnoServiceImp();
		Alumno alum=aService.getById(1);
		alum.setCurso(cService.getById(1));
		cService.darAlta(alum);
	}

}
