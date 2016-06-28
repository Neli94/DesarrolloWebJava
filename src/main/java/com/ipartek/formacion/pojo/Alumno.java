package com.ipartek.formacion.pojo;

import com.ipartek.formacion.pojo.exception.CandidatoException;

public class Alumno extends Candidato implements Comparable<Alumno>{
	private Curso curso;

	/**
	 * @throws CandidatoException 
	 * 
	 */
	public Alumno() throws CandidatoException {
		super();
		this.curso=new Curso();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public String mostrarDatos(){
		return super.mostrarDatos() + " " + this.curso.getNombre();
	}
	

	@Override
	public int compareTo(Alumno a) {
		int igual=-1;
		if(a.getCodigo()==this.getCodigo()){
			igual=0;
		}else{
			if(a.getApellidos().compareToIgnoreCase(this.getApellidos())==0){
				igual=1;
			}else{
				igual=-1;
			}
		}
		return igual;
	}
	
	
	
	

}
